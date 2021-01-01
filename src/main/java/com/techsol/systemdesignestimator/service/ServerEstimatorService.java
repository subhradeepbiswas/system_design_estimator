package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.web.dto.ServerEstimatorDto;

public interface ServerEstimatorService {
	ServerEstimate calculateServerRequirement(ServerEstimatorDto serverEstDto);
}
