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
		
		long outageInSec = (long) ((double) (365.00*24.00*36.00) * (double) (100.00000000000000-result));
		
		long mins = outageInSec/60;
		int secs = 0;
		if (mins > 0) {
			secs = (int) (outageInSec%60);
		} 
		
		long hrs = mins/60;
		mins = mins%60;
		
		StringBuilder outage = new StringBuilder();
		if (hrs > 0) {
			outage.append(hrs+" Hours "+mins+" Mins "+secs+" Secs");
		} else if (mins > 0) {
			outage.append(mins+" Mins "+secs+" Secs");
		} else {
			outage.append(outageInSec+" Secs");
		}
		
		Availability availability = new Availability(result, calculationDetails.toString(), outage.toString());
		return availability;
	}

}
