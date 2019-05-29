package com.weather.exceptions;

/**
 * @author rijkaard.nunez
 *
 */
public class WeatherCityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public WeatherCityException() {
	}

	/**
	 * @param message
	 */
	public WeatherCityException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public WeatherCityException(String message, Throwable cause) {
		super(message, cause);
	}

}
