package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Traffic;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public class TrafficServiceImpl implements TrafficService{

	@Override
	public Traffic calculateTraffic(TrafficSpecificationDto trafficSpecsDto) {
		int periodInSec = 0;
		int sec = 60;
		int min = 60;
		int hrs = 24;
		int daysInMonth = 30;
		int daysInWeek = 7;
		
		switch (trafficSpecsDto.getFrqncy())
		{
		     case "Minute":
		    	 periodInSec = sec;
		     ;
		     case "Hour":
		    	 periodInSec = sec*min;
		     ;
		     case "Day":
		    	 periodInSec = sec*min*hrs;
		     ;
		     case "Week":
		    	 periodInSec = sec*min*hrs*daysInWeek;
		     ;
		     case "Month":
		    	 periodInSec = sec*min*hrs*daysInMonth;
		     ;
		}
		
		return null;
	}

}
