package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;

import com.pi4j.io.gpio.PinState;

public class DeviceHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long time;
	
	private PinState state;

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public PinState getState() {
		return state;
	}

	public void setState(PinState state) {
		this.state = state;
	}

}
