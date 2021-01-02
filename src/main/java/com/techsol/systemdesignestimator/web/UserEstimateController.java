package com.techsol.systemdesignestimator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techsol.systemdesignestimator.model.UserEstimate;
import com.techsol.systemdesignestimator.service.UserEstimatorService;
import com.techsol.systemdesignestimator.service.UserEstimatorServiceImpl;
import com.techsol.systemdesignestimator.web.dto.UserEstimatorDto;

@Controller
public class UserEstimateController {

	private UserEstimatorService userEstService;
	
	public UserEstimateController() {
		super();
		this.userEstService = new UserEstimatorServiceImpl();
	}

	@PostMapping(value="/calcusersestimates")
	public ModelAndView getServerEstimates(UserEstimatorDto userEstimatorDto) {
		UserEstimate userEstimate = userEstService.calculateSimultaneousUserCount(userEstimatorDto);
		ModelAndView userEstimateMV = new ModelAndView();
		
		userEstimateMV.addObject("user", userEstimate);
		userEstimateMV.setViewName("UserEstimate");
		return userEstimateMV;
	}
	
}
