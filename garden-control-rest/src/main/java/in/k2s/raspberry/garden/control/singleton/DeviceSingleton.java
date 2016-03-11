package in.k2s.raspberry.garden.control.singleton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;

import in.k2s.raspberry.garden.control.enumeration.PinEnum;
import in.k2s.raspberry.garden.control.view.Device;

@Service
@Scope(value = "singleton")
public class DeviceSingleton {
	
	private String ambient = "RASPBERRY";
	
	final static Logger logger                = LoggerFactory.getLogger(DeviceSingleton.class);
	final static Map<String, Device> map      = new HashMap<String, Device>();
	final static Map<String, GpioPin> gpioMap = new HashMap<String, GpioPin>();
	static Boolean initialized                = false;
	static Long latestAction;
	static GpioController gpio;
	
	public DeviceSingleton() {
		if(!isInitialized()) {
			this.init(new Device("RELAY_01", "Irrigation", PinEnum.GPIO_01, PinMode.DIGITAL_OUTPUT, PinState.LOW));
		}
	}
	
	public boolean isInitialized() {
		return initialized;
	}
	
	public void init(Device ... pins) {
		init(Arrays.asList(pins));
	}
	
	public void init(List<Device> pins) {
		updateLatestAction();
		if(ambient.equalsIgnoreCase("RASPBERRY")) gpio = GpioFactory.getInstance();
		for (Device device : pins) {
			map.put(device.getId(), device);
		}
		initialized = true;
	}
	
	public Device getDevice(Device device) {
		return getDevice(device.getName());
	}
	
	public Device getDevice(String id) {
		return map.get(id);
	}
	
	public List<Device> getDeviceCollection() {
		final List<Device> list = new ArrayList<Device>();
		if(initialized) {
			list.addAll(map.values());
		}
		return list;
	}
	
	public void update(Device device) {
		updateLatestAction();
		if(ambient.equalsIgnoreCase("RASPBERRY")) {
			GpioPin p = getGpioPin(device);
			if(p != null) {
				if(p instanceof GpioPinDigitalOutput) {
					GpioPinDigitalOutput pout = (GpioPinDigitalOutput) p;
					pout.setState(device.getState());
				}
			}
		}
		device.addAction();
		map.put(device.getId(), device);
		logger.info(String.format("SET [%s]%s STATE TO: %s", device.getId(), device.getName(), device.getState().toString()));
	}
	
	public Long getLatestAction() {
		return latestAction;
	}
	
	
	/*
	 * Private Methods
	 */
	private GpioPin getGpioPin(Device view) {
		if(map.get(view.getId()) == null) return null;
		if(gpioMap.get(view.getId()) == null) {
			gpioMap.put(view.getId(), parse(map.get(view.getId())));
		}
		return gpioMap.get(view.getId());
	}
	
	private GpioPin parse(Device deviceView) {
		GpioPin pin = null;
		if(deviceView.getMode().equals(PinMode.ANALOG_INPUT)) {
			pin = gpio.provisionAnalogInputPin(deviceView.getGpioPin(), deviceView.getName());
		} else if(deviceView.getMode().equals(PinMode.ANALOG_OUTPUT)) {
			pin = gpio.provisionAnalogOutputPin(deviceView.getGpioPin(), deviceView.getName());
		} else if(deviceView.getMode().equals(PinMode.DIGITAL_INPUT)) {
			pin = gpio.provisionDigitalInputPin(deviceView.getGpioPin(), deviceView.getName());
		} else if(deviceView.getMode().equals(PinMode.DIGITAL_OUTPUT)) {
			pin = gpio.provisionDigitalOutputPin(deviceView.getGpioPin(), deviceView.getName(), deviceView.getState());
		}  
		return pin;
	}
	
	private void updateLatestAction() {
		latestAction = System.currentTimeMillis();		
	}
	

}
