package com.techsol.systemdesignestimator.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.techsol.systemdesignestimator.model.ServerEstimate;
import com.techsol.systemdesignestimator.service.ServerEstimatorService;
import com.techsol.systemdesignestimator.service.ServerEstimatorServiceImpl;
import com.techsol.systemdesignestimator.web.dto.ServerEstimatorDto;

@Controller
public class ServerEstimateController {
	private ServerEstimatorService serverEstService;
	
	public ServerEstimateController() {
		super();
		this.serverEstService = new ServerEstimatorServiceImpl();
	}

	@PostMapping(value="/calcserverestimates")
	public ModelAndView getServerEstimates(ServerEstimatorDto serverEstimatorDto) {
		ServerEstimate serverEstimate = serverEstService.calculateServerRequirement(serverEstimatorDto);
		ModelAndView serverEstimateMV = new ModelAndView();
		
		serverEstimateMV.addObject("server", serverEstimate);
		serverEstimateMV.setViewName("ServerEstimate");
		return serverEstimateMV;
	}
}
