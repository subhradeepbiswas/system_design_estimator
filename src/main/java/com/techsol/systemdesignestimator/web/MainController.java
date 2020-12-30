package com.techsol.systemdesignestimator.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView getEstimates(TrafficSpecificationDto trafficSpecDto) {
		System.out.println(trafficSpecDto.getReqcnt1() +" "+trafficSpecDto.getReqcnt2());
		
		Traffic traffic = trafficService.calculateTraffic(trafficSpecDto);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject(traffic);
		mav.setViewName("TrafficEstimate");
		
		return mav;
		
	}
}
