package com.techsol.systemdesignestimator.web;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.techsol.systemdesignestimator.model.Availability;
import com.techsol.systemdesignestimator.service.AvailabilityEstimatorService;
import com.techsol.systemdesignestimator.service.AvailabilityEstimatorServiceImpl;
import com.techsol.systemdesignestimator.web.dto.ArchSpecificationDto;

@Controller
public class AvailabilityEstimateController {
	
	private AvailabilityEstimatorService availabilityEstimatorService;
	
	public AvailabilityEstimateController() {
		this.availabilityEstimatorService = new AvailabilityEstimatorServiceImpl();
	}
	 
	
	@PostMapping(value="/availability")
	public ModelAndView estimateAvailability(@RequestBody String archSpec) throws JSONException {
		List<ArchSpecificationDto> archSpecList = new ArrayList<ArchSpecificationDto>();
		System.out.println(archSpec);
		JSONObject jsonObject= new JSONObject(archSpec);
		int partCnt = jsonObject.length();
		for (int i=0; i<partCnt; i++) {
			JSONObject compSpec = jsonObject.getJSONObject(Integer.toString(i));
			ArchSpecificationDto partSpecDto = new ArchSpecificationDto(compSpec.getString("serviceName"), Integer.parseInt(compSpec.getString("avgAvailability")), Integer.parseInt(compSpec.getString("instanceCount")));
			archSpecList.add(partSpecDto);
		}
		
		Availability availabilityEstimate = availabilityEstimatorService.calculateAvailability(archSpecList);
		
		ModelAndView availbltyEstimateMV = new ModelAndView();
		
		availbltyEstimateMV.addObject("availability", availabilityEstimate);
		availbltyEstimateMV.setViewName("AvailabilityEstimate");
		return availbltyEstimateMV;
		
	}
}
