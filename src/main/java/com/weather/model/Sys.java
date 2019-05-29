/**
 * 
 */
package com.weather.model;

import java.io.Serializable;

/**
 * @author rijkaard.nunez
 *
 */
public class Sys implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private Long sunrise;
	/**
	 * 
	 */
	private Long sunset;

	/**
	 * @return the sunrise
	 */
	public Long getSunrise() {
		return sunrise;
	}

	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(Long sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @return the sunset
	 */
	public Long getSunset() {
		return sunset;
	}

	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(Long sunset) {
		this.sunset = sunset;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
