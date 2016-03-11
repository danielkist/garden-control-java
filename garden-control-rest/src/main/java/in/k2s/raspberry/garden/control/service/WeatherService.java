package in.k2s.raspberry.garden.control.service;

import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.http.HttpUtil;
import in.k2s.raspberry.garden.control.parser.YahooWeatherParser;
import in.k2s.raspberry.garden.control.view.yahoo.weather.YahooWeather;

@Service
public class WeatherService {
	
	//@Value("${yahoo.weather.api.woeid}")
	private String woeid = "455861";
	
	public YahooWeather load() {
		String url  = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%3D{WOEID}&format=json&diagnostics=true&callback=";
		url = url.replace("{WOEID}", woeid);
		String json = new HttpUtil().doGet(url);
		YahooWeather bean = YahooWeatherParser.parse(json);
		return bean;
	}

}
