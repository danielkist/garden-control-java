package in.k2s.raspberry.garden.control.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.k2s.raspberry.garden.control.service.WeatherService;
import in.k2s.raspberry.garden.control.singleton.WeatherSingleton;
import in.k2s.raspberry.garden.control.view.yahoo.weather.YahooWeather;

@RestController
public class WeatherController {
	
	final static Logger logger   = LoggerFactory.getLogger(WeatherController.class);
	
	@Autowired WeatherSingleton weatherSingleton;
	@Autowired WeatherService   weatherService;
	
	@RequestMapping(value = "/weather/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public YahooWeather load() {
		if(weatherSingleton.getWeather() == null) weatherSingleton.setWeather(weatherService.load());
		return weatherSingleton.getWeather();
    }

}