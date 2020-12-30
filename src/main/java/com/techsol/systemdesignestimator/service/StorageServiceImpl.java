package com.techsol.systemdesignestimator.service;

import java.util.*;

import com.techsol.systemdesignestimator.model.Storage;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public class StorageServiceImpl implements StorageService{
	
	@Override
	public Storage calculateStorage(TrafficSpecificationDto trafficSpecsDto) {
		
		int periodInSec = 0;
		int sec = 60;
		int min = 60;
		int hrs = 24;
		int daysInMonth = 30;
		int daysInWeek = 7;
		int monthsPerYear = 12;
		int tenYears = 10;
		
		Map<String, Integer> trafficTypeToByteMap = new HashMap<>();
		trafficTypeToByteMap.put("Text (ASCII)", 1);
		trafficTypeToByteMap.put("Text (UTF-8)", 4);
		trafficTypeToByteMap.put("Image", 1000);
		trafficTypeToByteMap.put("Video", 50000000);
		trafficTypeToByteMap.put(null, 50000000);
		
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
		
		long totalBytesInInputFreq = (long) (trafficTypeToByteMap.get(trafficSpecsDto.getSelect1())
								* trafficSpecsDto.getAvglength1() * trafficSpecsDto.getReqcnt1())
							+ (trafficTypeToByteMap.get(trafficSpecsDto.getSelect2())
									* trafficSpecsDto.getAvglength2() * trafficSpecsDto.getReqcnt2())
							+ (trafficTypeToByteMap.get(trafficSpecsDto.getSelect3())
									* trafficSpecsDto.getAvglength3() * trafficSpecsDto.getReqcnt3())
							+ (trafficTypeToByteMap.get(trafficSpecsDto.getSelect4())
									* trafficSpecsDto.getAvglength4() * trafficSpecsDto.getReqcnt4());
		long bytesPerSec = totalBytesInInputFreq/periodInSec;
		long bytesInTenYears = bytesPerSec * tenYears * monthsPerYear * daysInMonth * hrs * min * sec;
		StringBuilder storageTextBuilder = new StringBuilder();
		int unitIdentifier = 1;
		String unitText = "";
		while (bytesInTenYears > 1000) {
			switch (unitIdentifier) {
			case 1:
				unitText = " Bytes";
				break;
			case 2:
				unitText = " KB ";
				break;
			case 3:
				unitText = " MB ";
				break;
			case 4:
				unitText = " GB ";
				break;
			case 5:
				unitText = " TB ";
				break;
			case 6:
				unitText = " PB ";
				break;
			}
			
			storageTextBuilder.insert(0, (bytesInTenYears%1000)+unitText);
			bytesInTenYears = bytesInTenYears/1000;
			unitIdentifier++;
		}
		String consideration = "We have made below Assumptions/considerations to calculate storage estimate: \n"
				+ "1 char with ASCII encoding = 1 byte \n"
				+ "1 char with UTF-8 encoding = 4 bytes \n"
				+ "1 min long video = 50 MB \n";
		String formula = "Calculation steps and formula used for Storage Estimation:\n"
				+ " 1. Total incoming bytes in given period (TIB) =  avg. length of ASCII Text X # of such Requests\n"
				+ "                                          + 4 X avg. length UTF-8 Text X # of such Requests\n"
				+ "                                          + 1000 X avg. size of image X # of such Requests\n"
				+ "                                          + 50000000 X avg. size of video X # of such Requests\n"
				+ " 2. Convert the input frequency to second (IFS) \n"
				+ " 3. Calculate Incoming bytes per second (i.e. TIB/IFS) \n"
				+ " 4. Calculate Incoming bytes for 10 years (Output)";
		
		Storage storage = new Storage(consideration, formula, storageTextBuilder.toString());
		return storage;
	}

}
