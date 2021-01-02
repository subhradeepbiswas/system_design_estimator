package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.UserEstimate;
import com.techsol.systemdesignestimator.web.dto.UserEstimatorDto;

public interface UserEstimatorService {
	UserEstimate calculateSimultaneousUserCount(UserEstimatorDto userEstDto);
}
