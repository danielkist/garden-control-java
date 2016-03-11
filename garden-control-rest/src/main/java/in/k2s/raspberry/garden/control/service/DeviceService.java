package in.k2s.raspberry.garden.control.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.PinState;

import in.k2s.raspberry.garden.control.singleton.DeviceSingleton;
import in.k2s.raspberry.garden.control.util.ThreadUtil;
import in.k2s.raspberry.garden.control.view.Device;
import in.k2s.raspberry.garden.control.view.DeviceAction;

@Service
public class DeviceService {
	
	@Autowired DeviceSingleton singleton;
	
	@Async
	public void doAction(DeviceAction action) {
		Device device = singleton.getDevice(action.getDeviceId());
		if(device != null) {
			PinState originalState = device.getState();
			device.setState(action.getNewState());
			singleton.update(device);
			System.out.println("Action: " + action.getDeviceId() + " Sleep:" + calculateDuration(action));
			ThreadUtil.sleep(calculateDuration(action));
			if(action.getReturnToPreviusState() && action.getReturnState() == null) {
				device.setState(originalState);
				singleton.update(device);
			} else if(action.getReturnState() != null) {
				device.setState(action.getReturnState());
				singleton.update(device);
			}
		}
	}
	
	private Long calculateDuration(DeviceAction action) {
		if(action.getDuration() == null && action.getEnd() == null) return 1L;
		if(action.getDuration() != null) return action.getDuration();
		Long begin = action.getBegin().getTime();
		Long end = action.getEnd().getTime();
		if(begin < System.currentTimeMillis()) begin = System.currentTimeMillis();
		
		return end - begin;
	}

}
