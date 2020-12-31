package com.techsol.systemdesignestimator.model;

public class Bandwidth {
	private String formula;
	private String requiredBandwidth;
	
	public Bandwidth(String formula, String requiredBandwidth) {
		this.formula = formula;
		this.requiredBandwidth = requiredBandwidth;
	}

	public String getFormula() {
		return formula;
	}

	public String getRequiredBandwidth() {
		return requiredBandwidth;
	}
	
	
}
