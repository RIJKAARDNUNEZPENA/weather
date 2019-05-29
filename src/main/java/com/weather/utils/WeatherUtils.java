package com.weather.utils;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author rijkaard.nunez
 *
 */
public class WeatherUtils {
	/**
	 * 
	 */
	private static final int NUEVE = 9;
	/**
	 * 
	 */
	private static final int CINCO = 5;
	/**
	 * 
	 */
	private static final int MILISEGUNDOS = 1000;
	/**
	 * 
	 */
	private static final double DEGREES_CELCIUS = 273.15;

	/**
	 * 
	 */
	private static final int MIN_DEGREE_FAHRENHEIT = 32;

	/**
	 * @param kelvinDegrees
	 * @param formatDegree
	 * @return
	 */
	public static Double kelvinToFahrenheit(Double kelvinDegrees, String formatDegree) {
		DecimalFormat decimalFormat = new DecimalFormat(formatDegree);
		return Double.valueOf(decimalFormat.format(
				Double.valueOf(((((kelvinDegrees - DEGREES_CELCIUS) * NUEVE) / CINCO) + MIN_DEGREE_FAHRENHEIT))));

	}

	/**
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateFormat(Date date, String format) {
		DateFormat dateFormat = new SimpleDateFormat(format);
		return dateFormat.format(date);

	}

	/**
	 * @param time
	 * @param timeFormat
	 * @return
	 */
	public static String parseTimeToDate(Long time, String timeFormat) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);
		Date date = new Date(time * MILISEGUNDOS);
		return dateFormat.format(date);
	}

	/**
	 * @param kelvinDedrees
	 * @param formatDegree
	 * @return
	 */
	public static Double kelvinToCelsius(Double kelvinDedrees, String formatDegree) {
		DecimalFormat decimalFormat = new DecimalFormat(formatDegree);
		Double celsius = kelvinDedrees - DEGREES_CELCIUS;
		return Double.valueOf(decimalFormat.format(celsius));
	}

}
