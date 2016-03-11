package in.k2s.raspberry.garden.control.view.yahoo.weather;

public class Atmosphere {
	
	private Integer humidity;
	
	private Double pressure;
	
	public Atmosphere() {}
	
	public Atmosphere(Integer humidity, Double pressure) {
		super();
		this.humidity = humidity;
		this.pressure = pressure;
	}
	
	public Atmosphere(String humidity, String pressure) {
		super();
		this.humidity = new Integer(humidity);
		this.pressure = new Double(pressure);
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public Double getPressure() {
		return pressure;
	}

	public void setPressure(Double pressure) {
		this.pressure = pressure;
	}
	
}