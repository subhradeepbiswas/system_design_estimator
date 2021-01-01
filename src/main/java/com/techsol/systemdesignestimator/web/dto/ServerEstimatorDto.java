package com.techsol.systemdesignestimator.web.dto;

public class ServerEstimatorDto {
	private double reqProcessingTime;
    private int qps;
    private int qpsPerc;
    private int cores;
    private int replicationFactor;
    
	public ServerEstimatorDto(double reqProcessingTime, int qps, int qpsPerc, int cores, int replicationFactor) {
		super();
		this.reqProcessingTime = reqProcessingTime;
		this.qps = qps;
		this.qpsPerc = qpsPerc;
		this.cores = cores;
		this.replicationFactor = replicationFactor;
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

	public int getReplicationFactor() {
		return replicationFactor;
	}
    
}
