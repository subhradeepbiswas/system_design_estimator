package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.ServerEstimate;
import com.techsol.systemdesignestimator.model.UserEstimate;
import com.techsol.systemdesignestimator.web.dto.ServerEstimatorDto;
import com.techsol.systemdesignestimator.web.dto.UserEstimatorDto;

public class UserEstimatorServiceImpl implements UserEstimatorService{

	@Override
	public UserEstimate calculateSimultaneousUserCount(UserEstimatorDto userEstDto) {
		int totalProcessCapacityPerSec = (int) ((userEstDto.getServers() * userEstDto.getAvgcores())/userEstDto.getMinReqstProcessingTime());
		int totalSimultaneousUserCount = (int) (totalProcessCapacityPerSec * 60 * (double) (userEstDto.getClickFreq()/60.00));
		
		String formula = "Steps and Formula to calculate number of servers: <br>"
				+" 1. No. of Requests above infrastructure can process every second (TRPS) = ("+userEstDto.getServers()+" X "+ userEstDto.getAvgcores() +") / "+userEstDto.getMinReqstProcessingTime()+"<br>"
				+"<i>[i.e. = (Server count X Avg. cores per server) / Avg. request processing time by 1 core ]</i> <br>" 
				+" 2. Max simultaneous users = (TRPS from above X 60 X ("+userEstDto.getClickFreq()+"/60)) <br>"
				+"<i>[i.e. = (TRPS X 60 X click interval in minutes)]</i> <br>";
		
		return new UserEstimate(formula, totalProcessCapacityPerSec, totalSimultaneousUserCount);
	}

}
