package com.techsol.systemdesignestimator.service;

import com.techsol.systemdesignestimator.model.Bandwidth;
import com.techsol.systemdesignestimator.web.dto.TrafficSpecificationDto;

public class BandwidthServiceImpl implements BandwidthService{

	@Override
	public Bandwidth calculateBandwidth(long bytesWrittenPerSec, long bytesReadPerSec) {
		long totalBandwidthReq = bytesWrittenPerSec + bytesReadPerSec;
		String requiredBandwidthInText = "";
		int unitIdentifier = 1;
		String unitText = "";
		
		while (totalBandwidthReq > 0) {
			switch (unitIdentifier) {
			case 1:
				unitText = " Bytes/Sec";
				break;
			case 2:
				unitText = " KBPS";
				break;
			case 3:
				unitText = " MBPS";
				break;
			case 4:
				unitText = " GBPS";
				break;
			case 5:
				unitText = " TBPS";
				break;
			case 6:
				unitText = " PBPS";
				break;
			}
			
			if (unitText == " PB ") {
				requiredBandwidthInText = String.valueOf(totalBandwidthReq+1)+unitText;
				break;
			} else {
				if (totalBandwidthReq >= 1000) {
					totalBandwidthReq = totalBandwidthReq/1000;
					unitIdentifier++;
				} else {
					requiredBandwidthInText = String.valueOf(totalBandwidthReq+1)+unitText;
					break;
				}
			}
		}
		
		String formula = "Formula for Bandwidth Estimation: Bytes read per second + Bytes written per second <br>";
		Bandwidth bandwidth = new Bandwidth(formula, requiredBandwidthInText);
		return bandwidth;
	}

}
