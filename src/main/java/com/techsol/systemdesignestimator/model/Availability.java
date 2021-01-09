package com.techsol.systemdesignestimator.model;

public class Availability {
	private double result;
	private String calculationDetails;
	private String outage;
	
	public Availability(double result, String calculationDetails, String outage) {
		this.result = result;
		this.calculationDetails = calculationDetails;
		this.outage = outage;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public String getCalculationDetails() {
		return calculationDetails;
	}

	public void setCalculationDetails(String calculationDetails) {
		this.calculationDetails = calculationDetails;
	}

	public String getOutage() {
		return outage;
	}

	public void setOutage(String outage) {
		this.outage = outage;
	}

}
