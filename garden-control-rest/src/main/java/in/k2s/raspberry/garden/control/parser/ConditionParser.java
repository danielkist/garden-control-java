package in.k2s.raspberry.garden.control.parser;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;

import com.google.gson.internal.LinkedTreeMap;

import in.k2s.raspberry.garden.control.enumeration.WeatherEnum;
import in.k2s.raspberry.garden.control.view.yahoo.weather.Condition;

public class ConditionParser {
	
	@SuppressWarnings("rawtypes")
	public static Condition parse(LinkedTreeMap map) {
		Condition bean = new Condition();
		bean.setCondition(ConditionParser.codeToEnum(map.get("text").toString()));
		bean.setDate(ConditionParser.parseDate(map.get("date").toString()));
		bean.setTime(ConditionParser.parseTime(map.get("date").toString()));
		if(map.get("high") != null) bean.setHigh(convertFahrenheitToCelsius(map.get("high").toString()));
		if(map.get("low") != null) bean.setLow(convertFahrenheitToCelsius(map.get("low").toString()));
		if(map.get("temp") != null) bean.setTemp(convertFahrenheitToCelsius(map.get("temp").toString()));
		return bean;
	}

	private static WeatherEnum codeToEnum(String condition) {
		condition = condition.toLowerCase();
		if(condition.contains("partly") && condition.contains("cloudy")) return WeatherEnum.PARTLY_SUNNY;
		else if(condition.contains("cloudy") || condition.contains("clouds")) return WeatherEnum.CLOUDY;
		else if(condition.contains("thunderstorm")) return WeatherEnum.THUNDERSTORM;
		else if(condition.contains("sunny") || condition.contains("mostly clear")) return WeatherEnum.SUNNY;
		else if(condition.contains("snow")) return WeatherEnum.SNOWY;
		else if(condition.contains("showers") || condition.contains("rain")) return WeatherEnum.RAINY;
		
		return WeatherEnum.UNDEFINED;
	}
	
	private static LocalDate parseDate(String date) {
		LocalDate d;
		String[] fields = date.split(" ");
		if(fields.length > 3) {
			//Tue, 09 Feb 2016 2:01 pm BRST
			d = LocalDate.of(new Integer(fields[3]), getMonth(fields[2]), new Integer(fields[1]));
		} else {
			d = LocalDate.of(new Integer(fields[2]), getMonth(fields[1]), new Integer(fields[0]));
		}
		return d;
	}
	
	private static LocalTime parseTime(String date) {
		LocalTime t = null;
		int index = date.indexOf(":");
		if(index > 0) {
			Integer hour   = new Integer(date.substring(index - 2, index).trim());
			Integer minute = new Integer(date.substring(index + 1, index + 3));
			if(date.toLowerCase().contains("pm")) hour = hour + 12;
			if(hour.equals(24)) hour = 0;
			t = LocalTime.of(hour, minute);
		}
		return t;
	}
	
	private static Month getMonth(String month) {
		if(month.equalsIgnoreCase("jan")) {
			return Month.JANUARY;
		} else if(month.equalsIgnoreCase("feb")) {
			return Month.FEBRUARY;
		} else if(month.equalsIgnoreCase("mar")) {
			return Month.MARCH;
		} else if(month.equalsIgnoreCase("apr")) {
			return Month.APRIL;
		} else if(month.equalsIgnoreCase("may")) {
			return Month.MAY;
		} else if(month.equalsIgnoreCase("jun")) {
			return Month.JUNE;
		} else if(month.equalsIgnoreCase("jul")) {
			return Month.JULY;
		} else if(month.equalsIgnoreCase("aug")) {
			return Month.AUGUST;
		} else if(month.equalsIgnoreCase("sep")) {
			return Month.SEPTEMBER;
		} else if(month.equalsIgnoreCase("oct")) {
			return Month.OCTOBER;
		} else if(month.equalsIgnoreCase("nov")) {
			return Month.NOVEMBER;
		} else {
			return Month.DECEMBER;
		}
	}
	
	private static Integer convertFahrenheitToCelsius(String t) {
		Integer temperatue = new Integer(t);
		return ((temperatue - 32)*5)/9;
	}
	

}
