package com.techsol.systemdesignestimator.web.dto;

public class ArchSpecificationDto {
    private String serviceName;
    private Integer avgAvailability, instanceCount;
    
    public ArchSpecificationDto() {
		
	}
    
	public ArchSpecificationDto(String serviceName, Integer avgAvailability, Integer instanceCount) {
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
	public Integer getAvgAvailability() {
		return avgAvailability;
	}
	public void setAvgAvailability(Integer avgAvailability) {
		this.avgAvailability = avgAvailability;
	}
	public Integer getInstanceCount() {
		return instanceCount;
	}
	public void setInstanceCount(Integer instanceCount) {
		this.instanceCount = instanceCount;
	}

}
