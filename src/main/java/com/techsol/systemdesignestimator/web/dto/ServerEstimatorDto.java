package com.techsol.systemdesignestimator.web.dto;

public class ServerEstimatorDto {
	private double reqProcessingTime;
    private int qps;
    private int qpsPerc;
    private int cores;
    
	public ServerEstimatorDto(double reqProcessingTime, int qps, int qpsPerc, int cores) {
		super();
		this.reqProcessingTime = reqProcessingTime;
		this.qps = qps;
		this.qpsPerc = qpsPerc;
		this.cores = cores;
	}
	
	public double getReqProcessingTime() {
		return reqProcessingTime;
	}
	public int getQps() {
		return qps;
	}
	public int getQpsPerc() {
		return qpsPerc;
	}
	public int getCores() {
		return cores;
	}
    
    
}
