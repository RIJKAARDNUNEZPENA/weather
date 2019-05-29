package com.weather.services.impl;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.weather.build.WeatherBuilder;
import com.weather.client.OpenWeatherMapClient;
import com.weather.exceptions.WeatherCityException;
import com.weather.model.WeatherClientResponse;
import com.weather.model.WeatherResponse;
import com.weather.services.WeatherService;

/**
 * @author rijkaard.nunez
 *
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	private static final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);

	@Autowired
	private OpenWeatherMapClient openWeatherMapClient;

	@Value("${OpenWeatherMapClient.time.format}")
	private String timeFormat;

	@Value("${OpenWeatherMapClient.decimal.format}")
	private String decimalFormat;

	/**
	 *
	 */
	@Override
	public ResponseEntity<WeatherResponse> getWeatherForCity(String city) throws WeatherCityException {

		ResponseEntity<WeatherResponse> weatherResponse = null;
		WeatherClientResponse weatherClient = null;
		try {
			weatherClient = openWeatherMapClient.callOpenWeatherService(city);
			if (Optional.ofNullable(weatherClient).isPresent()) {

				weatherResponse = new ResponseEntity<>(
						WeatherBuilder.getComponetWeather(weatherClient, timeFormat, decimalFormat), HttpStatus.OK);

			} else {
				throw new WeatherCityException("An error has ocurred in call openweathermap.com ");
			}
		} catch (WeatherCityException e) {
			logger.error("[getWeatherForCity] An error has ocurred in call endPointWeatherMapClient ", e.getMessage());
			throw new WeatherCityException(e.getMessage());
		}
		return weatherResponse;

	}

}
