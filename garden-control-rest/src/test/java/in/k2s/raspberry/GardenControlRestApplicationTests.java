package in.k2s.raspberry;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import in.k2s.raspberry.garden.control.GardenControlRestApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GardenControlRestApplication.class)
public class GardenControlRestApplicationTests {

	@Test
	public void contextLoads() {
	}

}
