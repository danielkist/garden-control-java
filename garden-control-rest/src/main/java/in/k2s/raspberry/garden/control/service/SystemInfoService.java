package in.k2s.raspberry.garden.control.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import in.k2s.raspberry.garden.control.enumeration.HttpProtocolEnum;
import in.k2s.raspberry.garden.control.enumeration.SystemBoard;
import in.k2s.raspberry.garden.control.view.SystemInfo;

@Service
public class SystemInfoService {
	
	private String ambient = "RASPBERRY";

	public SystemInfo collectSystemInfo() {
		SystemInfo si = new SystemInfo();
		if(ambient.equals("RASPBERRY")) {
			si.setBoard(SystemBoard.RASPBERRY_PY_2_B);
			si.setCpuClock(700);
			si.setCpuCores(4);
			si.setCpuLoad(getCpuLoad());
			si.setCpuTemp(getTemp());
			si.setHdSize("16Gb");
			si.setHdUsed((new Random().nextInt(4) + 1) + "Gb");
			si.setNetworkIp(getIp());
			si.setNetworkMacAddress(getMacAddress());
			si.setRamInstaled("512Mb");
			si.setRamSwap("100Mb");
			si.setRamSwapUsed((new Random().nextInt(100)) + "Mb");
			si.setRamUsed(getFreeMem());
			si.setServerPort("8080");
			si.setServerProtocol(HttpProtocolEnum.HTTP);
			si.setSystemDate(new Date());
		}
		return si;
	}
	
	private Double getCpuLoad() {
		List<String> lines = exec("sar -u 1 3");
		String info = lines.get(lines.size() - 1);
		while(info.indexOf("  ") >= 0) info = info.replace("  ", " ");
		String[] fields = info.split(" ");
		Double maxLoad = 100.0;
		Double iddle   = new Double(fields[fields.length - 1]);
		return new BigDecimal(maxLoad - iddle).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
	private String getFreeMem() {
		List<String> lines = exec("free -h");
		String info = lines.get(1);
		while(info.indexOf("  ") >= 0) info = info.replace("  ", " ");
		String[] fields = info.split(" ");
		return fields[2];
	}
	
	private Double getTemp() {
		List<String> lines = exec("vcgencmd measure_temp");
		if(lines == null || lines.size() == 0) return -273.15; //Absolute Zero 
		String info = lines.get(0);
		int begin   = info.indexOf("=") + 1;
		int end     = info.indexOf("'");
		return new Double(info.substring(begin, end));
	}
	
	private String getIp() {
		List<String> lines = exec("ifconfig");
		String info = "Undefined";
		for (String line : lines) {
			if(line.contains("inet addr") && line.indexOf("127.0.0.1") < 0) {
				info = line;
				break;
			}
		}
		while(info.indexOf("  ") >= 0) info = info.replace("  ", " ");
		info = info.trim();
		info = info.split(" ")[1];
		return info.replace("addr:", "");
	}
	
	private String getMacAddress() {
		String prefix = "HWaddr";
		List<String> lines = exec("ifconfig");
		String info = "Undefined";
		for (String line : lines) {
			if(line.contains(prefix)) {
				info = line;
				break;
			}
		}
		int begin = info.indexOf(prefix) + prefix.length() + 1;
		info = info.substring(begin);
		return info;
	}
	
	@SuppressWarnings("resource")
	private List<String> exec(String cmd) {
		List<String> lines = new ArrayList<String>();
		try {
			Process process = Runtime.getRuntime().exec(cmd);
			Scanner leitor = new Scanner(process.getInputStream());
			while (leitor.hasNextLine()) lines.add(leitor.nextLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

}
