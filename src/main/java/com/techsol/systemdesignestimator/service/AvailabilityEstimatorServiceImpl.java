package com.techsol.systemdesignestimator.service;

import java.util.List;

import com.techsol.systemdesignestimator.model.Availability;
import com.techsol.systemdesignestimator.web.dto.ArchSpecificationDto;

public class AvailabilityEstimatorServiceImpl implements AvailabilityEstimatorService{

	@Override
	public Availability calculateAvailability(List<ArchSpecificationDto> archSpecs) {
		double result = 0.00000000;
		double temp = 1.00000000;
		boolean begin = true;
		StringBuilder calculationDetails = new StringBuilder();
		
		for (ArchSpecificationDto component: archSpecs) {
			if (begin) {
				temp = (1-Math.pow((1-component.getAvgAvailability()/100.00), component.getInstanceCount()));
				begin = false;
			} else {
				calculationDetails.append("X <br>");
				temp = temp * (1-Math.pow((1-component.getAvgAvailability()/100.00), component.getInstanceCount())) ;
			}
			calculationDetails.append("1 - (1 - "+component.getAvgAvailability()+")^"+component.getInstanceCount()+" (for "+component.getServiceName()+") <br>");
		}
		calculationDetails.append("X 100");
		result = begin == false ? temp * 100.00: 0.0000;
		Availability availability = new Availability(result, calculationDetails.toString());
		return availability;
	}

}
