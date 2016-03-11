package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;
import java.util.Date;

import com.pi4j.io.gpio.PinState;

public class DeviceAction implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String deviceId;
	
	private PinState newState;
	
	private PinState returnState;
	
	private Long duration;
	
	private Date begin;
	
	private Date end;
	
	private Boolean returnToPreviusState = true;
	
	public void updateDurationToMilis() {
		if(this.getDuration() != null) {
			this.setDuration(this.getDuration() * 1000);
		}
	}

	public PinState getNewState() {
		return newState;
	}

	public void setNewState(PinState newState) {
		this.newState = newState;
	}

	public PinState getReturnState() {
		return returnState;
	}

	public void setReturnState(PinState returnState) {
		this.returnState = returnState;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public Boolean getReturnToPreviusState() {
		return returnToPreviusState;
	}

	public void setReturnToPreviusState(Boolean returnToPreviusState) {
		this.returnToPreviusState = returnToPreviusState;
	}

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public String getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}
