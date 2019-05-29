package com.weather.services;

import org.springframework.http.ResponseEntity;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.WeatherResponse;

/**
 * @author rijkaard.nunez
 *
 */
public interface WeatherService {
	/**
	 * @param city.
	 * @return Weather.
	 */
	public ResponseEntity<WeatherResponse> getWeatherForCity(String city) throws WeatherCityException;

}
