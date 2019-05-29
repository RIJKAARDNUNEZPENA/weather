package com.weather.client;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.weather.exceptions.WeatherCityException;
import com.weather.model.WeatherClientResponse;

/**
 * @author rijkaard.nunez
 *
 */
@Component
public class OpenWeatherMapClient {
	/**
	 * 
	 */
	private static final String ACCEPT = "Accept";
	/**
	 * 
	 */
	private static final String STATUSCODE = "StatusCode :";
	/**
	 * 
	 */
	private static final int STATUS_200 = 200;
	/**
	 * 
	 */
	private static final int CERO = 0;
	/**
	 * 
	 */
	@Autowired
	private RestTemplate restTemplate;
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

	/**
	 * 
	 */
	@Bean
	public RestTemplate rest() {
		return new RestTemplate();
	}

	/**
	 * @param city
	 * @return Response from WeatherClient
	 * @throws Exception
	 */
	public WeatherClientResponse callOpenWeatherService(String city) throws WeatherCityException {
		HttpHeaders header = new HttpHeaders();
		header.set(ACCEPT, MediaType.APPLICATION_JSON_VALUE);
		HttpEntity<WeatherClientResponse> entityWeather = new HttpEntity<>(header);
		StringBuilder endPointWeatherMapClient = new StringBuilder(openWeatherMapClientUrl).append(city).append(appid);
		ResponseEntity<WeatherClientResponse> result = restTemplate.exchange(endPointWeatherMapClient.toString(),
				HttpMethod.GET, entityWeather, WeatherClientResponse.class);
		validateStatus(result);
		return Optional.ofNullable(result).map(a -> result.getBody()).orElse(null);

	}

	public void validateStatus(ResponseEntity<WeatherClientResponse> result) throws WeatherCityException {

		if (Optional.ofNullable(result).isPresent() && STATUS_200 != Optional.ofNullable(result.getStatusCodeValue())
				.map(a -> result.getStatusCodeValue()).orElse(CERO)) {

			throw new WeatherCityException(STATUSCODE.concat(String.valueOf(result.getStatusCodeValue())));

		}
	}

}
