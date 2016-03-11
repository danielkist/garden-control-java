package in.k2s.raspberry.garden.control.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.service.WeatherService;
import in.k2s.raspberry.garden.control.singleton.WeatherSingleton;

@Service
public class WeatherSchedule {
	
	@Autowired WeatherService service;
	@Autowired WeatherSingleton singleton;
	
	/*
	 * fixedDelay specifically controls the next execution time when the last execution finishes.
	 * fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running
	 */
	@Scheduled(fixedDelay= 1 * 60 * 60 * 1000) //1 hour delay
    public void updateWeather() throws InterruptedException{
		singleton.setWeather(service.load());
    }

}
