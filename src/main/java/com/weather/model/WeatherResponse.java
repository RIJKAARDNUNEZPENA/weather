package com.weather.model;

import java.io.Serializable;
import java.util.Date;

/**
 * This class describe the atributes of weather
 * 
 * @author rijkaard.nunez
 *
 */
public class WeatherResponse implements Serializable {
	/**
	 * 
	 */
	private String id;
	/**
	 * 
	 */
	private static final long serialVersionUID = -9083525042287419021L;
	/**
	 * 
	 */
	private Date todayDate;
	/**
	 * 
	 */
	private String nameCity;
	/**
	 * 
	 */
	private String descriptionWeather;
	/**
	 * 
	 */
	private Double farengeithTemperature;
	/**
	 * 
	 */
	private Double celciusTemperature;
	/**
	 * 
	 */
	private String sunrise;
	/**
	 * 
	 */
	private String sunset;

	/**
	 * @return the todayDate
	 */
	public Date getTodayDate() {
		return todayDate;
	}

	/**
	 * @param todayDate the todayDate to set
	 */
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}

	/**
	 * @return the nameCity
	 */
	public String getNameCity() {
		return nameCity;
	}

	/**
	 * @param nameCity the nameCity to set
	 */
	public void setNameCity(String nameCity) {
		this.nameCity = nameCity;
	}

	/**
	 * @return the descriptionWeather
	 */
	public String getDescriptionWeather() {
		return descriptionWeather;
	}

	/**
	 * @param descriptionWeather the descriptionWeather to set
	 */
	public void setDescriptionWeather(String descriptionWeather) {
		this.descriptionWeather = descriptionWeather;
	}

	/**
	 * @return the farengeithTemperature
	 */
	public Double getFarengeithTemperature() {
		return farengeithTemperature;
	}

	/**
	 * @param farengeithTemperature the farengeithTemperature to set
	 */
	public void setFarengeithTemperature(Double farengeithTemperature) {
		this.farengeithTemperature = farengeithTemperature;
	}

	/**
	 * @return the celciusTemperature
	 */
	public Double getCelciusTemperature() {
		return celciusTemperature;
	}

	/**
	 * @param celciusTemperature the celciusTemperature to set
	 */
	public void setCelciusTemperature(Double celciusTemperature) {
		this.celciusTemperature = celciusTemperature;
	}

	/**
	 * @return the sunrise
	 */
	public String getSunrise() {
		return sunrise;
	}

	/**
	 * @param sunrise the sunrise to set
	 */
	public void setSunrise(String sunrise) {
		this.sunrise = sunrise;
	}

	/**
	 * @return the sunset
	 */
	public String getSunset() {
		return sunset;
	}

	/**
	 * @param sunset the sunset to set
	 */
	public void setSunset(String sunset) {
		this.sunset = sunset;
	}

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

	@Override
	public String toString() {
		return "WeatherResponse [todayDate=" + todayDate + ", nameCity=" + nameCity + ", descriptionWeather="
				+ descriptionWeather + ", farengeithTemperature=" + farengeithTemperature + ", celciusTemperature="
				+ celciusTemperature + ", sunrise=" + sunrise + ", sunset=" + sunset + ",id=" + id + "]";
	}

}
