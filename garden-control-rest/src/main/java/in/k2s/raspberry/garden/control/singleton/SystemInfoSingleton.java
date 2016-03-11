package in.k2s.raspberry.garden.control.singleton;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.view.SystemInfo;

@Service
@Scope(value = "singleton")
public class SystemInfoSingleton {
	
	private SystemInfo SystemInfo;

	public SystemInfo getSystemInfo() {
		return SystemInfo;
	}

	public void setSystemInfo(SystemInfo SystemInfo) {
		this.SystemInfo = SystemInfo;
	}

}
