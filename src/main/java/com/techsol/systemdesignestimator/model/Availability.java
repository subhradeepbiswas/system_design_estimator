package com.techsol.systemdesignestimator.model;

public class Availability {
	private double result;
	private String calculationDetails;
	
	public Availability(double result, String calculationDetails) {
		this.result = result;
		this.calculationDetails = calculationDetails;
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

}
