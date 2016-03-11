package in.k2s.raspberry.garden.control.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import in.k2s.raspberry.garden.control.service.DeviceService;
import in.k2s.raspberry.garden.control.singleton.DeviceSingleton;
import in.k2s.raspberry.garden.control.util.ThreadUtil;
import in.k2s.raspberry.garden.control.view.Device;
import in.k2s.raspberry.garden.control.view.DeviceAction;
import in.k2s.raspberry.garden.control.view.LatestAction;

@RestController
public class DeviceController {
	
	final static Logger logger   = LoggerFactory.getLogger(DeviceController.class);
	
	@Autowired DeviceSingleton singleton;
	@Autowired DeviceService service;
	
	@RequestMapping(value = "/device/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Device> list() {
		ThreadUtil.sleep(100L);
		return singleton.getDeviceCollection();
    }
	
	@RequestMapping(value = "/device/latest-action", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public LatestAction latestAction() {
		return new LatestAction(singleton.getLatestAction());
    }
	
	@RequestMapping(value = "/device/action", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Device doAction(@RequestBody DeviceAction view) {
		view.updateDurationToMilis();
		service.doAction(view);
		ThreadUtil.sleep(100L);
		return singleton.getDevice(view.getDeviceId());
    }

}