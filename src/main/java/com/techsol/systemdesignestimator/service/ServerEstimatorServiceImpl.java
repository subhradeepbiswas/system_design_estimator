package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.web.dto.ServerEstimatorDto;

public class ServerEstimatorServiceImpl implements ServerEstimatorService{

	@Override
	public ServerEstimate calculateServerRequirement(ServerEstimatorDto serverEstDto) {
		int ServerCapacityPerSec = (int) (serverEstDto.getCores()/serverEstDto.getReqProcessingTime());
		int serverRequired = (int) ((serverEstDto.getQps()* (double) (serverEstDto.getQpsPerc()/100.00))/ServerCapacityPerSec);
		String formula = "Steps and Formula to calculate number of servers: <br>"
				+" 1. No. of Requests 1 Server with "+serverEstDto.getCores()+" CPU cores can process per second = "
				+serverEstDto.getCores()+"/"+serverEstDto.getReqProcessingTime()+" = "+ServerCapacityPerSec+"<br>"
				+" (note: Avg. processing time is the time required to process one request by 1 CPU core) <br>" 
				+" 2. No. of required servers = ("+serverEstDto.getQps()+" X ("+serverEstDto.getQpsPerc()+"/100))/"+ServerCapacityPerSec;
		ServerEstimate serverEstimate = new ServerEstimate(formula, serverRequired);
		return serverEstimate;
	}

}
