package in.k2s.raspberry.garden.control.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.service.SystemInfoService;
import in.k2s.raspberry.garden.control.singleton.SystemInfoSingleton;

@Service
public class SystemInfoSchedule {
	
	@Autowired SystemInfoService service;
	@Autowired SystemInfoSingleton singleton;
	
	/*
	 * fixedDelay specifically controls the next execution time when the last execution finishes.
	 * fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running
	 */
	@Scheduled(fixedDelay= 5 * 1000)
    public void updateSystemInfo() throws InterruptedException{
		singleton.setSystemInfo(service.collectSystemInfo());
    }

}
