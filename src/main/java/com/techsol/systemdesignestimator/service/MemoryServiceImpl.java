package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Memory;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public class MemoryServiceImpl implements MemoryService{

	@Override
	public Memory calculateMemory(TrafficSpecificationDto trafficSpecsDto, long incomingBytesPerSec) {
		System.out.println(incomingBytesPerSec);
		long bytesReadPerSec = incomingBytesPerSec * (trafficSpecsDto.getReadRatio()/trafficSpecsDto.getWriteRatio());
		//System.out.println("Inside memory service" + trafficSpecsDto.getCachePercent());
		long cacheInBytePerDay =  (long) ((bytesReadPerSec * 3600 * 24) *  (double) (trafficSpecsDto.getCachePercent()/ 100.00));
		StringBuilder cacheTextBuilder = new StringBuilder();
		int unitIdentifier = 1;
		String unitText = "";
		
		while (cacheInBytePerDay > 0) {
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
			
			if (unitText == " PB ") {
				cacheTextBuilder.insert(0, cacheInBytePerDay+unitText);
				break;
			} else {
				if (cacheInBytePerDay >= 1000) {
					cacheTextBuilder.insert(0, (cacheInBytePerDay%1000)+unitText);
					cacheInBytePerDay = cacheInBytePerDay/1000;
					unitIdentifier++;
				} else {
					cacheTextBuilder.insert(0, cacheInBytePerDay+unitText);
					break;
				}
			}
		}
		
		String consideration = "Consideration/Assumption: <br>"
							+ "Cache requirement calculation is done based on the data read daily, <br>"
							+ "meaning if the new data is read today, yesterday's data is evicted <br> "
							+ "from the cache to accommodate the today's data. <br>";
		String formula = "Formula for Cache Estimation: Cache requirement % X (incoming bytes per second X (read ratio/write ratio) X 3600 X 24) <br>";
		
		Memory memory = new Memory(consideration, formula, cacheTextBuilder.toString(), bytesReadPerSec);
		
		return memory;
	}

}
