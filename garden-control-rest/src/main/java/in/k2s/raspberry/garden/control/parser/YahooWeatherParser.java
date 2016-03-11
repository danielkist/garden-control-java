package in.k2s.raspberry.garden.control.parser;

import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.LinkedTreeMap;

import in.k2s.raspberry.garden.control.view.yahoo.weather.Astronomy;
import in.k2s.raspberry.garden.control.view.yahoo.weather.Atmosphere;
import in.k2s.raspberry.garden.control.view.yahoo.weather.Condition;
import in.k2s.raspberry.garden.control.view.yahoo.weather.YahooWeather;

public class YahooWeatherParser {
	
	@SuppressWarnings({"rawtypes"})
	public static YahooWeather parse(String json) {
		Gson gson = new GsonBuilder().create();
		LinkedTreeMap map = gson.fromJson(json , LinkedTreeMap.class);
		return YahooWeatherParser.parse(map);
	}
	
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static YahooWeather parse(LinkedTreeMap map) {
		YahooWeather bean = new YahooWeather();
		if(map != null) {
        	LinkedTreeMap query = (LinkedTreeMap) map.get("query");
        	if(query != null) {
        		LinkedTreeMap results = (LinkedTreeMap) query.get("results");
        		if(results != null) {
        			LinkedTreeMap channel = (LinkedTreeMap) results.get("channel");
        			
        			Astronomy astronomy = AstronomyParser.parse((LinkedTreeMap) channel.get("astronomy"));
        			bean.setAstronomy(astronomy);
    				
    				Atmosphere atmosphere = AtmosphereParser.parse((LinkedTreeMap) channel.get("atmosphere"));
    				bean.setAtmosphere(atmosphere);
    				
    				LinkedTreeMap item      = (LinkedTreeMap) channel.get("item");
    				Condition condition     = ConditionParser.parse((LinkedTreeMap) item.get("condition"));
    				bean.setCurrent(condition);
    				
    				List<LinkedTreeMap> forecast = (List<LinkedTreeMap>) item.get("forecast");
    				for (LinkedTreeMap c : forecast) {
    					bean.addForecastItem(ConditionParser.parse(c));
					}
        		}
        	}
        }
		
		return bean;
	}

}
