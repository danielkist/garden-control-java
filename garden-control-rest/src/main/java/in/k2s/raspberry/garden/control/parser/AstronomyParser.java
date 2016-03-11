package in.k2s.raspberry.garden.control.parser;

import com.google.gson.internal.LinkedTreeMap;

import in.k2s.raspberry.garden.control.view.yahoo.weather.Astronomy;

public class AstronomyParser {
	
	@SuppressWarnings("rawtypes")
	public static Astronomy parse(LinkedTreeMap map) {
		Astronomy bean = new Astronomy();
		bean.setSunrise(map.get("sunrise").toString());
		bean.setSunset(map.get("sunset").toString());
		return bean;
	}

}
