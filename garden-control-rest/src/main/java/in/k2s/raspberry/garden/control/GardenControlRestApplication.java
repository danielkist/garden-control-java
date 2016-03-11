package in.k2s.raspberry.garden.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
public class GardenControlRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GardenControlRestApplication.class, args);
	}
}