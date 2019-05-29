package com.weather.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import com.weather.client.OpenWeatherMapClient;
import com.weather.exceptions.WeatherCityException;
import com.weather.model.Main;
import com.weather.model.Sys;
import com.weather.model.Weather;
import com.weather.model.WeatherClientResponse;
import com.weather.model.WeatherResponse;
import com.weather.services.impl.WeatherServiceImpl;

@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")

public class WeatherServiceTest {
	private static final Logger logger = LogManager.getLogger(WeatherServiceTest.class);

	@InjectMocks
	private WeatherServiceImpl weatherService;

	@Mock
	private OpenWeatherMapClient openWeatherMapClient;

	private final static String CITY = "Hong Kong";
	private final static String TIMEFORMAT = "timeFormat";
	private final static String DECIMALFORMAT = "decimalFormat";
	private final static String ID = "123456";

	@Value("${OpenWeatherMapClient.time.format}")
	private String timeFormat;

	@Value("${OpenWeatherMapClient.decimal.format}")
	private String decimalFormat;

	@Before
	public void beforeTest() {

		ReflectionTestUtils.setField(weatherService, TIMEFORMAT, timeFormat);
		ReflectionTestUtils.setField(weatherService, DECIMALFORMAT, decimalFormat);

	}

	@Test
	public void getWeatherByCity200ValidResponseTest() {

		ResponseEntity<WeatherResponse> response = null;
		try {
			Mockito.when(openWeatherMapClient.callOpenWeatherService(anyString())).thenReturn(createResponseEntityOk());

			response = this.weatherService.getWeatherForCity(CITY);

		} catch (WeatherCityException e) {
			logger.error(
					"[getWeatherByCity200ValidResponseTest] An error has ocurred in call getWeatherByCity200ValidResponseTest ",
					e.getMessage());
			fail("unexpected Exception".concat(e.getMessage()));
		}

		assertNotNull(response);
		logger.debug(response.toString());
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(CITY, response.getBody().getNameCity());

	}

	@Test(expected = WeatherCityException.class)
	public void getWeatherByCityNullRequestTest() throws WeatherCityException {
		Mockito.when(openWeatherMapClient.callOpenWeatherService(anyString())).thenThrow(WeatherCityException.class);
		ResponseEntity<WeatherResponse> response = this.weatherService.getWeatherForCity(CITY);
	}

	public static WeatherClientResponse createResponseEntityOk() {

		WeatherClientResponse clientResponse = new WeatherClientResponse();
		clientResponse.setId(ID);
		Main main = new Main();
		main.setTemp(14.2);
		clientResponse.setMain(main);

		Sys sys = new Sys();
		sys.setSunset(12330L);
		sys.setSunrise(12322156L);
		clientResponse.setSys(sys);

		Weather weather = new Weather();
		weather.setDescription("scattered clouds");
		weather.setId("1819729");
		weather.setMain(CITY);

		List<Weather> list = new ArrayList<Weather>();
		list.add(weather);
		clientResponse.setName(CITY);
		clientResponse.setWeather(list);

		return clientResponse;
	}
}
