package com.weather.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

import java.util.Date;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.WeatherResponse;
import com.weather.services.WeatherService;

@AutoConfigureMockMvc
@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WeatherControllerTest {

	@InjectMocks
	WeatherController weatherController;

	@Mock
	private WeatherService weatherService;

	private final static String CITY = "London";
	private final static String DESCRIPTION = "scattered clouds";

	@Test
	public void homePageTest() throws Exception {

		ModelAndView modelAndView = weatherController.home();

		assertNotNull(modelAndView);
		assertEquals("index", modelAndView.getViewName());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void successPageTest() throws Exception {

		ResponseEntity<WeatherResponse> response = new ResponseEntity<>(this.buildValidWeatherAppResponse(),
				HttpStatus.OK);
		Mockito.when(weatherService.getWeatherForCity(anyString())).thenReturn(response);
		ModelAndView modelAndView = weatherController.getWeatherByCity(CITY);

		assertEquals("weatherPage", modelAndView.getViewName());
		Map<String, Object> map = modelAndView.getModel();
		assertNotNull(map.get("response"));
		ResponseEntity<WeatherResponse> result = (ResponseEntity<WeatherResponse>) map.get("response");
		assertNotNull(result);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertEquals(CITY, result.getBody().getNameCity());
		assertEquals(DESCRIPTION, result.getBody().getDescriptionWeather());

	}

	@SuppressWarnings("unchecked")
	@Test
	public void unSuccessPageTest() throws WeatherCityException {

		Mockito.when(weatherService.getWeatherForCity(anyString())).thenThrow(WeatherCityException.class);
		ModelAndView modelAndView = weatherController.getWeatherByCity(CITY);
		assertNotNull(modelAndView);
		assertEquals("errorPage", modelAndView.getViewName());

	}

	private WeatherResponse buildValidWeatherAppResponse() {
		WeatherResponse response = new WeatherResponse();

		response.setCelciusTemperature(57.94);
		response.setDescriptionWeather(DESCRIPTION);
		response.setFarengeithTemperature(14.41);
		response.setNameCity(CITY);
		response.setSunrise("4:36 AM");
		response.setSunset("4:36 AM");
		response.setTodayDate(new Date());

		return response;
	}
}
