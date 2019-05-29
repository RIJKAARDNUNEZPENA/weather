/**
 * 
 */
package com.weather.model;

import java.io.Serializable;
import java.util.List;

/**
 * @author rijkaard.nunez
 *
 */
public class WeatherClientResponse implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private String name;
	/**
	 * 
	 */
	private List<Weather> weather;
	/**
	 * 
	 */
	private Main main;
	/**
	 * 
	 */
	private Sys sys;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the weather
	 */
	public List<Weather> getWeather() {
		return weather;
	}

	/**
	 * @param weather the weather to set
	 */
	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	/**
	 * @return the main
	 */
	public Main getMain() {
		return main;
	}

	/**
	 * @param main the main to set
	 */
	public void setMain(Main main) {
		this.main = main;
	}

	/**
	 * @return the sys
	 */
	public Sys getSys() {
		return sys;
	}

	/**
	 * @param sys the sys to set
	 */
	public void setSys(Sys sys) {
		this.sys = sys;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
