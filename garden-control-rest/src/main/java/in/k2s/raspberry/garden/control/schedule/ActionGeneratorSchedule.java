package in.k2s.raspberry.garden.control.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.service.DeviceService;

@Service
public class ActionGeneratorSchedule {
	
	@Autowired DeviceService service;
	
	/*
	 * fixedDelay specifically controls the next execution time when the last execution finishes.
	 * fixedRate makes Spring run the task on periodic intervals even if the last invocation may be still running
	 */
	@Scheduled(fixedDelay= 10 * 1000)
    public void updateSystemInfo() throws InterruptedException{
//		DeviceAction action = new DeviceAction();
//		action.setDeviceId("RELAY_01");
//		action.setNewState(PinState.HIGH);
//		action.setDuration(new Random().nextInt(7) * 1000L);
//		service.doAction(action);
    }

}
