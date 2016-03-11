package in.k2s.raspberry.garden.control.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.view.yahoo.weather.YahooWeather;

@Service
@Scope(value = "singleton")
public class WeatherSingleton {
	
	YahooWeather weather;

	public YahooWeather getWeather() {
		return weather;
	}

	public void setWeather(YahooWeather weather) {
		this.weather = weather;
	}
	
	

}
