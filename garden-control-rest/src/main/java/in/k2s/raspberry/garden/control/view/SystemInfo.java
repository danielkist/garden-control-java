package in.k2s.raspberry.garden.control.view;

import java.io.Serializable;
import java.util.Date;

import in.k2s.raspberry.garden.control.enumeration.HttpProtocolEnum;
import in.k2s.raspberry.garden.control.enumeration.SystemBoard;

public class SystemInfo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private SystemBoard board;
	
	private Integer cpuCores;
	
	private Integer cpuClock;
	
	private Double cpuLoad;
	
	private Double cpuTemp;
	
	private String ramInstaled;
	
	private String ramUsed;
	
	private String ramSwap;
	
	private String ramSwapUsed;
	
	private String hdSize;
	
	private String hdUsed;
	
	private String networkIp;
	
	private String networkMacAddress;
	
	private String serverPort;
	
	private HttpProtocolEnum serverProtocol;
	
	private Date systemDate;

	public SystemBoard getBoard() {
		return board;
	}

	public void setBoard(SystemBoard board) {
		this.board = board;
	}

	public Integer getCpuCores() {
		return cpuCores;
	}

	public void setCpuCores(Integer cpuCores) {
		this.cpuCores = cpuCores;
	}

	public Integer getCpuClock() {
		return cpuClock;
	}

	public void setCpuClock(Integer cpuClock) {
		this.cpuClock = cpuClock;
	}

	public Double getCpuLoad() {
		return cpuLoad;
	}

	public void setCpuLoad(Double cpuLoad) {
		this.cpuLoad = cpuLoad;
	}

	public Double getCpuTemp() {
		return cpuTemp;
	}

	public void setCpuTemp(Double cpuTemp) {
		this.cpuTemp = cpuTemp;
	}

	public String getRamInstaled() {
		return ramInstaled;
	}

	public void setRamInstaled(String ramInstaled) {
		this.ramInstaled = ramInstaled;
	}

	public String getRamUsed() {
		return ramUsed;
	}

	public void setRamUsed(String ramUsed) {
		this.ramUsed = ramUsed;
	}

	public String getRamSwap() {
		return ramSwap;
	}

	public void setRamSwap(String ramSwap) {
		this.ramSwap = ramSwap;
	}

	public String getRamSwapUsed() {
		return ramSwapUsed;
	}

	public void setRamSwapUsed(String ramSwapUsed) {
		this.ramSwapUsed = ramSwapUsed;
	}

	public String getHdSize() {
		return hdSize;
	}

	public void setHdSize(String hdSize) {
		this.hdSize = hdSize;
	}

	public String getHdUsed() {
		return hdUsed;
	}

	public void setHdUsed(String hdUsed) {
		this.hdUsed = hdUsed;
	}

	public String getNetworkIp() {
		return networkIp;
	}

	public void setNetworkIp(String networkIp) {
		this.networkIp = networkIp;
	}

	public String getNetworkMacAddress() {
		return networkMacAddress;
	}

	public void setNetworkMacAddress(String networkMacAddress) {
		this.networkMacAddress = networkMacAddress;
	}

	public String getServerPort() {
		return serverPort;
	}

	public void setServerPort(String serverPort) {
		this.serverPort = serverPort;
	}

	public HttpProtocolEnum getServerProtocol() {
		return serverProtocol;
	}

	public void setServerProtocol(HttpProtocolEnum serverProtocol) {
		this.serverProtocol = serverProtocol;
	}

	public Date getSystemDate() {
		return systemDate;
	}

	public void setSystemDate(Date systemDate) {
		this.systemDate = systemDate;
	}

}
