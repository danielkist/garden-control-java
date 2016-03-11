package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;

import in.k2s.raspberry.garden.control.view.yahoo.weather.YahooWeather;

public class Dashboard implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private YahooWeather weather;

	public YahooWeather getWeather() {
		return weather;
	}

	public void setWeather(YahooWeather weather) {
		this.weather = weather;
	}

}
