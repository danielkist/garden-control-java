package in.k2s.raspberry.garden.control.parser;

import com.google.gson.internal.LinkedTreeMap;

import in.k2s.raspberry.garden.control.view.yahoo.weather.Atmosphere;

public class AtmosphereParser {
	
	@SuppressWarnings("rawtypes")
	public static Atmosphere parse(LinkedTreeMap map) {
		Atmosphere bean = new Atmosphere();
		bean.setHumidity(new Integer(map.get("humidity").toString()));
		bean.setPressure(new Double(map.get("pressure").toString()));
		return bean;
	}

}
