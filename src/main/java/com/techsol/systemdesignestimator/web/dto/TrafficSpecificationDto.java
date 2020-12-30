package com.techsol.systemdesignestimator.web.dto;

import org.springframework.web.bind.annotation.RequestParam;

public class TrafficSpecificationDto {
	
	private String frqncy;
	private String select1; 
	private String avglength1;
	private String reqcnt1;
	private String select2; 
	private String avglength2;
	private String reqcnt2;
	private String select3; 
	private String avglength3;
	private String reqcnt3;
	private String select4; 
	private String avglength4;
	private String reqcnt4;
	
	public TrafficSpecificationDto() {
		
	}
	public TrafficSpecificationDto(String frqncy, String select1, String avglength1, String reqcnt1) {
		this.frqncy = frqncy;
		this.select1 = select1; 
		this.avglength1 = avglength1;
		this.reqcnt1 = reqcnt1;
	}
	public TrafficSpecificationDto(String frqncy, String select1, String avglength1, String reqcnt1,
								String select2, String avglength2, String reqcnt2) {
		this.frqncy = frqncy;
		this.select1 = select1; 
		this.avglength1 = avglength1;
		this.reqcnt1 = reqcnt1;
		this.select2 = select2; 
		this.avglength2 = avglength2;
		this.reqcnt2 = reqcnt2;
	}
	public TrafficSpecificationDto(String frqncy, String select1, String avglength1, String reqcnt1,
								String select2, String avglength2, String reqcnt2,
								String select3, String avglength3, String reqcnt3) {
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
	public String getAvglength1() {
		return avglength1;
	}
	public void setAvglength1(String avglength1) {
		this.avglength1 = avglength1;
	}
	public String getReqcnt1() {
		return reqcnt1;
	}
	public void setReqcnt1(String reqcnt1) {
		this.reqcnt1 = reqcnt1;
	}
	public String getSelect2() {
		return select2;
	}
	public void setSelect2(String select2) {
		this.select2 = select2;
	}
	public String getAvglength2() {
		return avglength2;
	}
	public void setAvglength2(String avglength2) {
		this.avglength2 = avglength2;
	}
	public String getReqcnt2() {
		return reqcnt2;
	}
	public void setReqcnt2(String reqcnt2) {
		this.reqcnt2 = reqcnt2;
	}
	public String getSelect3() {
		return select3;
	}
	public void setSelect3(String select3) {
		this.select3 = select3;
	}
	public String getAvglength3() {
		return avglength3;
	}
	public void setAvglength3(String avglength3) {
		this.avglength3 = avglength3;
	}
	public String getReqcnt3() {
		return reqcnt3;
	}
	public void setReqcnt3(String reqcnt3) {
		this.reqcnt3 = reqcnt3;
	}
	public String getSelect4() {
		return select4;
	}
	public void setSelect4(String select4) {
		this.select4 = select4;
	}
	public String getAvglength4() {
		return avglength4;
	}
	public void setAvglength4(String avglength4) {
		this.avglength4 = avglength4;
	}
	public String getReqcnt4() {
		return reqcnt4;
	}
	public void setReqcnt4(String reqcnt4) {
		this.reqcnt4 = reqcnt4;
	}
	
	
}
