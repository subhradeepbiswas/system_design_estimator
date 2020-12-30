package com.techsol.systemdesignestimator.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.techsol.systemdesignestimator.model.Bandwidth;
import com.techsol.systemdesignestimator.model.Memory;
import com.techsol.systemdesignestimator.model.Storage;
import com.techsol.systemdesignestimator.model.Traffic;
import com.techsol.systemdesignestimator.service.BandwidthService;
import com.techsol.systemdesignestimator.service.BandwidthServiceImpl;
import com.techsol.systemdesignestimator.service.MemoryService;
import com.techsol.systemdesignestimator.service.MemoryServiceImpl;
import com.techsol.systemdesignestimator.service.StorageService;
import com.techsol.systemdesignestimator.service.StorageServiceImpl;
import com.techsol.systemdesignestimator.service.TrafficService;
import com.techsol.systemdesignestimator.service.TrafficServiceImpl;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

@Controller
public class MainController {
	
	private TrafficService trafficService;
	private StorageService storageService;
	private MemoryService memoryService;
	private BandwidthService bandwidthService;
	
	public MainController(){
		this.trafficService = new TrafficServiceImpl();
		this.storageService = new StorageServiceImpl();
		this.memoryService = new MemoryServiceImpl();
		this.bandwidthService = new BandwidthServiceImpl();
	}
	
	@RequestMapping("/")
	public String getLandingPage() {
		return "Landing";
	}
	
	@PostMapping(value="/hardwareestimates")
	public ModelAndView getEstimates(TrafficSpecificationDto trafficSpecDto) {
		System.out.println(trafficSpecDto.getReqcnt1() +" "+trafficSpecDto.getReqcnt2());
		
		Traffic traffic = trafficService.calculateTraffic(trafficSpecDto);
		Storage storage = storageService.calculateStorage(trafficSpecDto);
		Memory memory = memoryService.calculateMemory(trafficSpecDto);
		Bandwidth bandwidth = bandwidthService.calculateBandwidth(trafficSpecDto);
		
		ModelAndView hardwareResultMV = new ModelAndView();
		
		hardwareResultMV.addObject("traffic", traffic);
		hardwareResultMV.addObject("storage", storage);
		hardwareResultMV.addObject("memory", memory);
		hardwareResultMV.addObject("bandwidth", bandwidth);
		hardwareResultMV.setViewName("HardwareResult");
		
		return hardwareResultMV;
		
	}
}
