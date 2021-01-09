package com.techsol.systemdesignestimator.service;

import java.util.List;

import com.techsol.systemdesignestimator.model.Availability;
import com.techsol.systemdesignestimator.web.dto.ArchSpecificationDto;

public interface AvailabilityEstimatorService {
	public Availability calculateAvailability(List<ArchSpecificationDto> archSpecs);
}
