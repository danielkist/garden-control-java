package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;

public class LatestAction implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long time;
	
	public LatestAction() {}
	
	public LatestAction(Long time) {
		this.time = time;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

}
