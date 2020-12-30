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
		
		long totalReqs = trafficSpecsDto.getReqcnt1()+ trafficSpecsDto.getReqcnt2()
						+trafficSpecsDto.getReqcnt3()+ trafficSpecsDto.getReqcnt4();
		
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
		
		long totalReqPerSec = totalReqs/periodInSec;
		long readReq = (totalReqPerSec * trafficSpecsDto.getReadRatio())/
				(trafficSpecsDto.getReadRatio() + trafficSpecsDto.getWriteRatio());
		long writeReq = totalReqPerSec - readReq;
		String readReqFormula = "Read requests = (Total Requests per second X read ratio)/(read ratio + write ration)";
		String writeReqFormula = "Write requests = (Total Requests per second - Read requests)";
		
		Traffic traffic = new Traffic(readReq, writeReq, readReqFormula, writeReqFormula, trafficSpecsDto.getFrqncy());
		
		return traffic;
	}

}
