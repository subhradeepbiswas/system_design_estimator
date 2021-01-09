package com.techsol.systemdesignestimator.web.dto;

public class ArchSpecificationDto {
    private String serviceName;
    private double avgAvailability;
    private int instanceCount;
    
    public ArchSpecificationDto() {
		
	}
    
	public ArchSpecificationDto(String serviceName, double avgAvailability, int instanceCount) {
		super();
		this.serviceName = serviceName;
		this.avgAvailability = avgAvailability;
		this.instanceCount = instanceCount;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}
	public double getAvgAvailability() {
		return avgAvailability;
	}
	public void setAvgAvailability(double avgAvailability) {
		this.avgAvailability = avgAvailability;
	}
	public int getInstanceCount() {
		return instanceCount;
	}
	public void setInstanceCount(int instanceCount) {
		this.instanceCount = instanceCount;
	}

}
