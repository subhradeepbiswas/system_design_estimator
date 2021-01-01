package com.techsol.systemdesignestimator.web.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class TrafficSpecificationDto {
	
	private String frqncy;
	private String select1; 
	private int avglength1=0;
	private long reqcnt1 = 0;
	private String select2; 
	private int avglength2=0;
	private long reqcnt2 = 0;
	private String select3; 
	private int avglength3=0;
	private long reqcnt3 = 0;
	private String select4; 
	private int avglength4=0;
	private long reqcnt4 = 0;
	private int readRatio;
	private int writeRatio;
	private int cachePercent;
	
	public TrafficSpecificationDto() {
		
	}
	public TrafficSpecificationDto(String frqncy, String select1, int avglength1, long reqcnt1, int readRatio, int writeRatio, int cachePercent) {
		this.frqncy = frqncy;
		this.select1 = select1; 
		this.avglength1 = avglength1;
		this.reqcnt1 = reqcnt1;
		this.readRatio = readRatio;
		this.writeRatio = writeRatio;
		this.cachePercent = cachePercent;
	}
	public TrafficSpecificationDto(String frqncy, String select1, int avglength1, long reqcnt1,
								String select2, int avglength2, long reqcnt2, int readRatio, int writeRatio, int cachePercent) {
		this.frqncy = frqncy;
		this.select1 = select1; 
		this.avglength1 = avglength1;
		this.reqcnt1 = reqcnt1;
		this.select2 = select2; 
		this.avglength2 = avglength2;
		this.reqcnt2 = reqcnt2;
		this.readRatio = readRatio;
		this.writeRatio = writeRatio;
		this.cachePercent = cachePercent;
	}
	public TrafficSpecificationDto(String frqncy, String select1, int avglength1, long reqcnt1,
								String select2, int avglength2, long reqcnt2,
								String select3, int avglength3, long reqcnt3, int readRatio, int writeRatio, int cachePercent) {
		this.frqncy = frqncy;
		this.select1 = select1; 
		this.avglength1 = avglength1;
		this.reqcnt1 = reqcnt1;
		this.select2 = select2; 
		this.avglength2 = avglength2;
		this.reqcnt2 = reqcnt2;
		this.select3 = select3; 
		this.avglength3 = avglength3;
		this.reqcnt3 = reqcnt3;
		this.readRatio = readRatio;
		this.writeRatio = writeRatio;
		this.cachePercent = cachePercent;
	}
	public String getFrqncy() {
		return frqncy;
	}
	public void setFrqncy(String frqncy) {
		this.frqncy = frqncy;
	}
	public String getSelect1() {
		return select1;
	}
	public void setSelect1(String select1) {
		this.select1 = select1;
	}
	public int getAvglength1() {
		return avglength1;
	}
	public void setAvglength1(int avglength1) {
		this.avglength1 = avglength1;
	}
	public long getReqcnt1() {
		return reqcnt1;
	}
	public void setReqcnt1(long reqcnt1) {
		this.reqcnt1 = reqcnt1;
	}
	public String getSelect2() {
		return select2;
	}
	public void setSelect2(String select2) {
		this.select2 = select2;
	}
	public int getAvglength2() {
		return avglength2;
	}
	public void setAvglength2(int avglength2) {
		this.avglength2 = avglength2;
	}
	public long getReqcnt2() {
		return reqcnt2;
	}
	public void setReqcnt2(long reqcnt2) {
		this.reqcnt2 = reqcnt2;
	}
	public String getSelect3() {
		return select3;
	}
	public void setSelect3(String select3) {
		this.select3 = select3;
	}
	public int getAvglength3() {
		return avglength3;
	}
	public void setAvglength3(int avglength3) {
		this.avglength3 = avglength3;
	}
	public long getReqcnt3() {
		return reqcnt3;
	}
	public void setReqcnt3(long reqcnt3) {
		this.reqcnt3 = reqcnt3;
	}
	public String getSelect4() {
		return select4;
	}
	public void setSelect4(String select4) {
		this.select4 = select4;
	}
	public int getAvglength4() {
		return avglength4;
	}
	public void setAvglength4(int avglength4) {
		this.avglength4 = avglength4;
	}
	public long getReqcnt4() {
		return reqcnt4;
	}
	public void setReqcnt4(long reqcnt4) {
		this.reqcnt4 = reqcnt4;
	}
	public int getReadRatio() {
		return readRatio;
	}
	public void setReadRatio(int readRatio) {
		this.readRatio = readRatio;
	}
	public int getWriteRatio() {
		return writeRatio;
	}
	public void setWriteRatio(int writeRatio) {
		this.writeRatio = writeRatio;
	}
	
	public void setCachePercent(int cachePercent) {
		this.cachePercent = cachePercent;
	}
	public int getCachePercent() {
		return cachePercent;
	}
	
	
}
