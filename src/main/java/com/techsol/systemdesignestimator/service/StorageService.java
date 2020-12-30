package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Storage;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public interface StorageService {
	Storage calculateStorage(TrafficSpecificationDto trafficSpecsDto);
}
