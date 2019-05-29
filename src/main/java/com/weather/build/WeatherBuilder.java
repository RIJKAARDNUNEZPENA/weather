package com.weather.build;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.Weather;
import com.weather.model.WeatherClientResponse;
import com.weather.model.WeatherResponse;
import com.weather.utils.WeatherUtils;

/**
 * @author rijkaard.nunez
 *
 */
public class WeatherBuilder {
	private static final Logger logger = LogManager.getLogger(WeatherBuilder.class);

	private WeatherBuilder() {
		super();
	}

	public static WeatherResponse getComponetWeather(WeatherClientResponse weatherClient, String timeFormat,
			String decimalFormat) throws WeatherCityException {

		WeatherResponse weatherResponse = new WeatherResponse();
		try {
			Optional<WeatherClientResponse> optionalWeatherClient = Optional.ofNullable(weatherClient);
			if (optionalWeatherClient.isPresent()) {
				String sunset = WeatherUtils.parseTimeToDate(Optional.ofNullable(weatherClient.getSys())
						.map(a -> weatherClient.getSys().getSunset()).orElse(Long.valueOf(0)), timeFormat);
				String sunrise = WeatherUtils.parseTimeToDate(Optional.ofNullable(weatherClient.getSys())
						.map(a -> weatherClient.getSys().getSunrise()).orElse(Long.valueOf(0)), timeFormat);
				Double celsiusDegree = WeatherUtils.kelvinToCelsius(Optional.ofNullable(weatherClient.getMain())
						.map(a -> weatherClient.getMain().getTemp()).orElse(Double.valueOf(0)), decimalFormat);
				Double fahrenheitDegree = WeatherUtils.kelvinToFahrenheit(Optional.ofNullable(weatherClient.getMain())
						.map(a -> weatherClient.getMain().getTemp()).orElse(Double.valueOf(0)), decimalFormat);
				weatherResponse.setSunset(Optional.ofNullable(sunset).map(a -> sunset).orElse(StringUtils.EMPTY));
				weatherResponse.setSunrise(Optional.ofNullable(sunrise).map(a -> sunrise).orElse(StringUtils.EMPTY));
				weatherResponse.setCelciusTemperature(celsiusDegree);
				weatherResponse.setDescriptionWeather(getDesciption(weatherClient.getWeather()));
				weatherResponse.setFarengeithTemperature(fahrenheitDegree);
				weatherResponse.setNameCity(weatherClient.getName());
				weatherResponse.setId(weatherClient.getId());
				weatherResponse.setSunrise(sunrise);
				weatherResponse.setSunset(sunset);
				weatherResponse.setTodayDate(new Date());

			}

		} catch (Exception e) {
			logger.error("[getWeatherForCity] An error in parse objet WeatherResponse ", e.getMessage());
			throw new WeatherCityException(
					"[getWeatherForCity] An error in parse objet WeatherResponse ".concat(e.getMessage()));
		}
		return weatherResponse;

	}

	public static String getDesciption(List<Weather> weathers) {

		Optional<Weather> weather = weathers.stream().findFirst();
		return Optional.ofNullable(weather).map(a -> weather.get().getDescription()).orElse(StringUtils.EMPTY);
	}
}
