package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.web.dto.ServerEstimatorDto;

public class ServerEstimatorServiceImpl implements ServerEstimatorService{

	@Override
	public ServerEstimate calculateServerRequirement(ServerEstimatorDto serverEstDto) {
		int ServerCapacityPerSec = (int) (serverEstDto.getCores()/serverEstDto.getReqProcessingTime());
		int minServerRequired = (int) ((serverEstDto.getQps()* (double) (serverEstDto.getQpsPerc()/100.00))/ServerCapacityPerSec);
		int totalServerRequiredWithReplica = minServerRequired * serverEstDto.getReplicationFactor();
		String formula = "Steps and Formula to calculate number of servers: <br>"
				+" 1. No. of Requests 1 Server with "+serverEstDto.getCores()+" CPU cores can process per second = "
				+serverEstDto.getCores()+"/"+serverEstDto.getReqProcessingTime()+" = "+ServerCapacityPerSec+"<br>"
				+" (note: Avg. processing time is the time required to process one request by 1 CPU core) <br>" 
				+" 2. Minimum no. of required servers = ("+serverEstDto.getQps()+" X ("+serverEstDto.getQpsPerc()+"/100))/"+ServerCapacityPerSec+"<br>"
				+" 3. Total no. of required servers with replication = "+minServerRequired+" X "+serverEstDto.getReplicationFactor()+" = "+totalServerRequiredWithReplica+"<br>";
		ServerEstimate serverEstimate = new ServerEstimate(formula, minServerRequired, totalServerRequiredWithReplica);
		return serverEstimate;
	}

}
