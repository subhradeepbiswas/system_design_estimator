package com.techsol.systemdesignestimator.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techsol.systemdesignestimator.model.Traffic;
import com.techsol.systemdesignestimator.service.TrafficService;
import com.techsol.systemdesignestimator.service.TrafficServiceImpl;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

@Controller
public class MainController {
	
	private TrafficService trafficService;
	
	public MainController(){
		this.trafficService = new TrafficServiceImpl();
	}
	
	@RequestMapping("/")
	public String getLandingPage() {
		return "Landing";
	}
	
	@PostMapping(value="/hardwareestimates")
	public String getEstimates(TrafficSpecificationDto trafficSpecDto, Model model) {
		System.out.println(trafficSpecDto.getFrqncy());
		System.out.println(trafficSpecDto.getSelect1());
		System.out.println(trafficSpecDto.getAvglength1());
		System.out.println(trafficSpecDto.getReqcnt1());
		
		Traffic traffic = trafficService.calculateTraffic(trafficSpecDto);
		
		model.addAttribute("name", "Subh");
		model.addAttribute("surname", "Biswas");
		
		return "TrafficEstimate";
		
	}
}
