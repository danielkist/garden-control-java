package in.k2s.raspberry.garden.control.bundle;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConfigurationBundle {
	
	private static final Logger logger   = LoggerFactory.getLogger(ConfigurationBundle.class);
	private static Properties properties = null;
	
	
	private ConfigurationBundle() {}
	
	public static String getParam(String param) {
		if(properties == null) { load(); }
		String value = properties.getProperty(param);
		return value;
	}
	
	private static void load() {
		properties = new Properties();
		String FILE = "configuration.properties";
		try {
			properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream(FILE));
			logger.info("[ApplicationBundle] "+FILE+" loaded");
		} catch (IOException e) {
			logger.error("[ApplicationBundle] "+FILE+" load exception");
		}
	}

}
