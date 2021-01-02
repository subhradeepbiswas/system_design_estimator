package com.techsol.systemdesignestimator.web.dto;

public class UserEstimatorDto {
	private int servers;
    private int avgcores;
    private double minReqstProcessingTime;
    private int clickFreq;
    
	public UserEstimatorDto(int servers, int avgcores, double minReqstProcessingTime, int clickFreq) {
		super();
		this.servers = servers;
		this.avgcores = avgcores;
		this.minReqstProcessingTime = minReqstProcessingTime;
		this.clickFreq = clickFreq;
	}

	public int getServers() {
		return servers;
	}

	public int getAvgcores() {
		return avgcores;
	}

	public double getMinReqstProcessingTime() {
		return minReqstProcessingTime;
	}

	public int getClickFreq() {
		return clickFreq;
	}
	
    
}
