package in.k2s.raspberry.garden.control.view.yahoo.weather;

import java.time.LocalTime;

public class Astronomy {
	
	private LocalTime sunrise;
	
	private LocalTime sunset;
	
	public Astronomy() {}
	
	public Astronomy(LocalTime sunrise, LocalTime sunset) {
		super();
		this.sunrise = sunrise;
		this.sunset = sunset;
	}

	public Astronomy(String sunrise, String sunset) {
		super();
		this.sunrise = convert(sunrise);
		this.sunset = convert(sunset);
	}

	public LocalTime getSunrise() {
		return sunrise;
	}
	
	/**
	 * Pattern: hh:mm AM/PM 
	 * @param sunrise
	 */
	public void setSunrise(String sunrise) {
		this.sunrise = convert(sunrise);
	}

	public void setSunrise(LocalTime sunrise) {
		this.sunrise = sunrise;
	}

	public LocalTime getSunset() {
		return sunset;
	}
	
	/**
	 * Pattern: hh:mm AM/PM 
	 * @param sunrise
	 */
	public void setSunset(String sunset) {
		this.sunset = convert(sunset);
	}

	public void setSunset(LocalTime sunset) {
		this.sunset = sunset;
	}
	
	private LocalTime convert(String time) {
		String[] fields = time.split(" ");
		String[] hm     = fields[0].split(":");
		Integer hour    = new Integer(hm[0]);
		Integer minute  = new Integer(hm[1]);
		if(fields[1].equalsIgnoreCase("PM")) hour = hour + 12;
		return LocalTime.of(hour, minute);
	}
	
}