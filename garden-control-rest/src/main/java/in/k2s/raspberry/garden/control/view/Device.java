package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

import in.k2s.raspberry.garden.control.enumeration.PinEnum;

public class Device implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	
	private String name;
	
	private PinEnum pin;
	
	private PinMode mode;
	
	private PinState state;
	
	private Long latestHigh;
	
	private Long latestLow;
	
	private List<DeviceHistory> history = new ArrayList<DeviceHistory>();
	
	public Device() {}
	
	public Device(String id, String name, PinEnum pin, PinMode mode, PinState state) {
		super();
		this.id    = id;
		this.name  = name;
		this.pin   = pin;
		this.mode  = mode;
		this.state = state;
		addAction();
	}
	
	public void addAction() {
		DeviceHistory action = new DeviceHistory();
		action.setState(this.getState());
		action.setTime(System.currentTimeMillis());
		this.addAction(action);
	}
	
	public void addAction(DeviceHistory action) {
		if(action.getState().isLow()) setLatestLow(action.getTime());
		if(action.getState().isHigh()) setLatestHigh(action.getTime());
		
		this.getHistory().add(action);
	}
	
	public void setPin(GpioPin pin) {
		setPin(PinEnum.valueOf(String.format("GPIO_%02d", pin.getPin().getAddress())));
	}
	
	public Pin getGpioPin() {
		String pinName = getPin().name().replace("_0", " ").replace("_", " ");
		return RaspiPin.getPinByName(pinName);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PinEnum getPin() {
		return pin;
	}

	public void setPin(PinEnum pin) {
		this.pin = pin;
	}

	public PinMode getMode() {
		return mode;
	}

	public void setMode(PinMode mode) {
		this.mode = mode;
	}

	public PinState getState() {
		return state;
	}

	public void setState(PinState state) {
		this.state = state;
	}

	public Long getLatestHigh() {
		return latestHigh;
	}

	public void setLatestHigh(Long latestHigh) {
		this.latestHigh = latestHigh;
	}

	public Long getLatestLow() {
		return latestLow;
	}

	public void setLatestLow(Long latestLow) {
		this.latestLow = latestLow;
	}

	public List<DeviceHistory> getHistory() {
		return history;
	}

	public void setHistory(List<DeviceHistory> history) {
		this.history = history;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
