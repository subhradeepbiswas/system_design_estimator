package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Traffic;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public interface TrafficService {
	Traffic calculateTraffic(TrafficSpecificationDto trafficSpecsDto);
}
