/**
 * 
 */
package com.weather.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.client.RestTemplate;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.Main;
import com.weather.model.Sys;
import com.weather.model.Weather;
import com.weather.model.WeatherClientResponse;

/**
 * @author rijkaard.nunez
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:applicationTest.properties")
public class OpenWeatherMapClientTest {
	private static final Logger logger = LogManager.getLogger(OpenWeatherMapClientTest.class);

	@InjectMocks
	private OpenWeatherMapClient openWeatherMapClient;
	@Mock
	private RestTemplate restMock;
	/**
	 * 
	 */
	@Value("${OpenWeatherMapClient.URL}")
	private String openWeatherMapClientUrl;
	/**
	 * 
	 */
	@Value("${OpenWeatherMapClient.appid}")
	private String appid;

	@Before
	public void configureSystemUnderTest() {
		ReflectionTestUtils.setField(openWeatherMapClient, "openWeatherMapClientUrl", openWeatherMapClientUrl);
		ReflectionTestUtils.setField(openWeatherMapClient, "appid", appid);
	}

	@Test(expected = WeatherCityException.class)
	public void callOpenWeatherServiceValidResponseExceptionTest() throws WeatherCityException {
		ResponseEntity<WeatherClientResponse> weatherClientEntity = new ResponseEntity<WeatherClientResponse>(
				HttpStatus.BAD_REQUEST);

		WeatherClientResponse response = null;
		Mockito.when(restMock.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class),
				ArgumentMatchers.<Class<WeatherClientResponse>>any())).thenReturn(weatherClientEntity);
		response = openWeatherMapClient.callOpenWeatherService("123456");

	}

	@Test(expected = WeatherCityException.class)
	public void validatestatusResponseExceptionTest() throws WeatherCityException {
		ResponseEntity<WeatherClientResponse> weatherClientEntity = new ResponseEntity<WeatherClientResponse>(
				HttpStatus.BAD_REQUEST);

		WeatherClientResponse response = null;
		Mockito.when(restMock.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class),
				ArgumentMatchers.<Class<WeatherClientResponse>>any())).thenReturn(weatherClientEntity);
		openWeatherMapClient.validateStatus(weatherClientEntity);

	}

	@Test
	public void callOpenWeatherServiceValidResponseTest() {

		WeatherClientResponse response = null;

		Mockito.when(restMock.exchange(anyString(), any(HttpMethod.class), any(HttpEntity.class),
				ArgumentMatchers.<Class<WeatherClientResponse>>any())).thenReturn(createResponseEntityOk());
		try {
			response = openWeatherMapClient.callOpenWeatherService("123456");
		} catch (WeatherCityException e) {
			logger.error(
					"[callOpenWeatherServiceValidResponseTest] An error has ocurred in call callOpenWeatherServiceValidResponseTest ",
					e.getMessage());

		}
		assertNotNull(response);
		assertEquals("123456", response.getId());

	}

	public static ResponseEntity<WeatherClientResponse> responseEntityMock() {
		WeatherClientResponse clientResponse = new WeatherClientResponse();
		clientResponse.setId("Id");
		Main main = new Main();
		main.setTemp(17.8);
		Sys sys = new Sys();
		sys.setSunset(877647L);
		sys.setSunrise(87688989L);
		Weather weather = new Weather();
		weather.setDescription("scattered clouds");
		weather.setId("\"1819729\"");
		weather.setMain("Hong Kong");
		List<Weather> list = new ArrayList<Weather>();
		list.add(weather);
		clientResponse.setSys(sys);
		clientResponse.setMain(main);
		clientResponse.setWeather(list);

		return new ResponseEntity<WeatherClientResponse>(clientResponse, HttpStatus.OK);
	}

	public static ResponseEntity<WeatherClientResponse> createResponseEntityOk() {

		WeatherClientResponse clientResponse = new WeatherClientResponse();
		clientResponse.setId("123456");
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
		weather.setMain("Hong Kong");

		List<Weather> list = new ArrayList<Weather>();
		list.add(weather);
		clientResponse.setName("Hong Kong");
		clientResponse.setWeather(list);
		ResponseEntity<WeatherClientResponse> responseEntity = new ResponseEntity<WeatherClientResponse>(clientResponse,
				HttpStatus.OK);
		return responseEntity;
	}

}
