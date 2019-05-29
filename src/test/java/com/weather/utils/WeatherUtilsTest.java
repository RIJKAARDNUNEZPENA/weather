package com.weather.utils;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author rijkaard.nunez
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class WeatherUtilsTest {
	@Value("${OpenWeatherMapClient.time.format}")
	private String timeFormat;

	@Value("${OpenWeatherMapClient.decimal.format}")
	private String decimalFormat;

	@Value("${OpenWeatherMapClient.date.format}")
	private String dateCurrentFormat;

	/**
	 * 
	 */
	@Test
	public void dateFormater() {
		Date dateBirthday = new GregorianCalendar(1989, Calendar.APRIL, 10).getTime();
		String dateBirthdayFormat = WeatherUtils.dateFormat(dateBirthday, dateCurrentFormat);
		assertEquals("10/04/1989", dateBirthdayFormat);
	}

	/**
	 * 
	 */
	@Test
	public void parseTime() {

		Long sunrise = 1556488307L;

		String sunriseFormat = WeatherUtils.parseTimeToDate(sunrise, timeFormat);
		assertEquals("04.51 PM", sunriseFormat);
	}

	/**
	 * 
	 */
	@Test
	public void parseMaxTime() {

		Long sunrise = Long.MAX_VALUE;

		String sunriseFormat = WeatherUtils.parseTimeToDate(sunrise, timeFormat);
		assertEquals("05.59 PM", sunriseFormat);
	}

	/**
	 * 
	 */
	@Test
	public void parseKelvinToCelsius() {
		Double kelvinDegree = 25d;
		Double celsiusDregree = WeatherUtils.kelvinToCelsius(kelvinDegree, decimalFormat);
		assertEquals(Double.valueOf(-248.15), celsiusDregree);
	}

	/**
	 * 
	 */
	@Test
	public void parsekelvinToFahrenheit() {
		Double kelvinDegree = 25d;
		Double fahrenheitDegree = WeatherUtils.kelvinToFahrenheit(kelvinDegree, decimalFormat);

		assertEquals(Double.valueOf(-414.67), fahrenheitDegree);

	}

	/**
	 * 
	 */
	@Test
	public void parsekelvinToCelsiusMaxDegree() {

		Double kelvinDegree = Double.MAX_VALUE;
		Double celsiusDegree = WeatherUtils.kelvinToCelsius(kelvinDegree, decimalFormat);

		assertEquals(Double.valueOf(1.7976931348623157E308), celsiusDegree);
	}

	/**
	 * 
	 */
	@Test(expected = NumberFormatException.class)
	public void parseKelvinToFahrenheitMaxError() {

		Double kelvinDegree = Double.MAX_VALUE;
		Double fahrenheitDegree = WeatherUtils.kelvinToFahrenheit(kelvinDegree, decimalFormat);
		assertEquals(Double.valueOf(1.7976931348623157E308), fahrenheitDegree);
	}

}
