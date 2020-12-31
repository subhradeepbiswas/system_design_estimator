package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Memory;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public interface MemoryService {
	Memory calculateMemory(TrafficSpecificationDto trafficSpecsDto, long incomingBytesPerSec);
}
