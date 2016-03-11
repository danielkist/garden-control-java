package in.k2s.raspberry.garden.control.view.yahoo.weather;

import java.util.ArrayList;
import java.util.List;

public class YahooWeather {
	
	private Astronomy astronomy;
	
	private Condition current;
	
	private List<Condition> forecast;
	
	private Atmosphere atmosphere;
	
	public void addForecastItem(Condition condition) {
		if(forecast == null) forecast = new ArrayList<Condition>();
		forecast.add(condition);
	}

	public Astronomy getAstronomy() {
		return astronomy;
	}

	public void setAstronomy(Astronomy astronomy) {
		this.astronomy = astronomy;
	}

	public Condition getCurrent() {
		return current;
	}

	public void setCurrent(Condition current) {
		this.current = current;
	}

	public List<Condition> getForecast() {
		return forecast;
	}

	public void setForecast(List<Condition> forecast) {
		this.forecast = forecast;
	}

	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}
	
}