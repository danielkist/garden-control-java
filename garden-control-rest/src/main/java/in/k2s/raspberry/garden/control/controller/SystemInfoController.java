package in.k2s.raspberry.garden.control.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.k2s.raspberry.garden.control.singleton.SystemInfoSingleton;
import in.k2s.raspberry.garden.control.view.SystemInfo;

@RestController
public class SystemInfoController {
	
	final static Logger logger   = LoggerFactory.getLogger(SystemInfoController.class);
	
	@Autowired SystemInfoSingleton singleton;
	
	@RequestMapping(value = "/system-info/load", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public SystemInfo status() {
		return singleton.getSystemInfo();
    }

}