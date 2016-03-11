package in.k2s.raspberry.garden.control.view.yahoo.weather;

import java.time.LocalDate;
import java.time.LocalTime;

import in.k2s.raspberry.garden.control.enumeration.WeatherEnum;

public class Condition {
	
	private LocalDate date;
	
	private LocalTime time;
	
	private Integer temp;
	
	private Integer high;
	
	private Integer low;
	
	private WeatherEnum condition;
	
	public Condition() {}

	public Integer getTemp() {
		return temp;
	}

	public void setTemp(Integer temp) {
		this.temp = temp;
	}

	public Integer getHigh() {
		return high;
	}

	public void setHigh(Integer high) {
		this.high = high;
	}

	public Integer getLow() {
		return low;
	}

	public void setLow(Integer low) {
		this.low = low;
	}

	public WeatherEnum getCondition() {
		return condition;
	}

	public void setCondition(WeatherEnum condition) {
		this.condition = condition;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}
	
}
