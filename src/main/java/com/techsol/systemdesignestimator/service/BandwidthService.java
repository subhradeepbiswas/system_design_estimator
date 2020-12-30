package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Bandwidth;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public interface BandwidthService {
	Bandwidth calculateBandwidth(TrafficSpecificationDto trafficSpecsDto);
}
