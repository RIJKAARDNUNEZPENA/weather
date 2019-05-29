/**
 * 
 */
package com.weather.controller;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.WeatherResponse;
import com.weather.services.WeatherService;
import com.weather.services.impl.WeatherServiceImpl;

/**
 * @author rijkaard.nunez
 *
 */
@Controller
public class WeatherController {
	private static final Logger logger = LogManager.getLogger(WeatherServiceImpl.class);

	/**
	 * 
	 */
	@Autowired
	private WeatherService weatherService;

	/**
	 * @return
	 */
	@GetMapping(value = "/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");

		return modelAndView;
	}

	/**
	 * @param city
	 * @return
	 */
	@GetMapping(value = "/weatherByCity")
	public ModelAndView getWeatherByCity(@RequestParam String city) {
		ModelAndView modelAndView = new ModelAndView();

		ResponseEntity<WeatherResponse> weather = null;
		try {
			weather = weatherService.getWeatherForCity(city);
			Optional<ResponseEntity<WeatherResponse>> optionalWeatherResponse = Optional.ofNullable(weather);
			if (optionalWeatherResponse.isPresent()) {
				modelAndView.setViewName("weatherPage");
				modelAndView.addObject("response", weather);
				modelAndView.addObject("weather", weather.getBody());
			}
		} catch (WeatherCityException e) {
			logger.error("An exception has ocurred:" + e.getMessage());
			modelAndView.setViewName("errorPage");
			modelAndView.addObject("message", e.getMessage());
		}
		return modelAndView;
	}

}
