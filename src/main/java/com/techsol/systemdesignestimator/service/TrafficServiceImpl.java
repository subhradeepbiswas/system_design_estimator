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
		
		System.out.println(trafficSpecsDto.getFrqncy());
		
		switch (trafficSpecsDto.getFrqncy())
		{
		     case "Minute":
		    	 periodInSec = sec;
		    	 break;
		     case "Hour":
		    	 periodInSec = sec*min;
		    	 break;
		     case "Day":
		    	 periodInSec = sec*min*hrs;
		    	 break;
		     case "Week":
		    	 periodInSec = sec*min*hrs*daysInWeek;
		    	 break;
		     case "Month":
		    	 periodInSec = sec*min*hrs*daysInMonth;
		    	 break;
		}
		
		long totalWritePerSec = totalReqs/ periodInSec;
		long readReq = (totalReqs/ periodInSec) * (trafficSpecsDto.getReadRatio()/trafficSpecsDto.getWriteRatio());
		
		String readReqFormula = "Read requests per second = Total Requests per second X (read ratio/write ratio)";
		String writeReqFormula = "Write requests per second = Total Requests from above table / # of seconds in frequency field";
		
		System.out.println(totalWritePerSec);
		System.out.println(readReq);
		
		Traffic traffic = new Traffic(readReq, totalWritePerSec, readReqFormula, writeReqFormula, trafficSpecsDto.getFrqncy());
		
		return traffic;
	}

}
