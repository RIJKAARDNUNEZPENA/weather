/**
 * 
 */
package com.weather.model;

import java.io.Serializable;

/**
 * @author rijkaard.nunez
 *
 */
public class Main implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	private double temp;
	/**
	 * 
	 */
	private double pressure;
	/**
	 * 
	 */
	private double humidity;
	/**
	 * 
	 */
	private double temp_min;
	/**
	 * 
	 */
	private double temp_max;

	/**
	 * @return the temp
	 */
	public double getTemp() {
		return temp;
	}

	/**
	 * @param temp the temp to set
	 */
	public void setTemp(double temp) {
		this.temp = temp;
	}

	/**
	 * @return the pressure
	 */
	public double getPressure() {
		return pressure;
	}

	/**
	 * @param pressure the pressure to set
	 */
	public void setPressure(double pressure) {
		this.pressure = pressure;
	}

	/**
	 * @return the humidity
	 */
	public double getHumidity() {
		return humidity;
	}

	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}

	/**
	 * @return the temp_min
	 */
	public double getTemp_min() {
		return temp_min;
	}

	/**
	 * @param temp_min the temp_min to set
	 */
	public void setTemp_min(double temp_min) {
		this.temp_min = temp_min;
	}

	/**
	 * @return the temp_max
	 */
	public double getTemp_max() {
		return temp_max;
	}

	/**
	 * @param temp_max the temp_max to set
	 */
	public void setTemp_max(double temp_max) {
		this.temp_max = temp_max;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
