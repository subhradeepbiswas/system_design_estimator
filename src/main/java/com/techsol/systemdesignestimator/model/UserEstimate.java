package com.techsol.systemdesignestimator.model;

public class UserEstimate {
	private String formula;
	private int totalProcessCapacityPerSec;
	private int totalSimultaneousUserCount;
	
	public UserEstimate(String formula, int totalProcessCapacityPerSec, int totalSimultaneousUserCount) {
		super();
		this.formula = formula;
		this.totalProcessCapacityPerSec = totalProcessCapacityPerSec;
		this.totalSimultaneousUserCount = totalSimultaneousUserCount;
	}

	public String getFormula() {
		return formula;
	}

	public int getTotalProcessCapacityPerSec() {
		return totalProcessCapacityPerSec;
	}

	public int getTotalSimultaneousUserCount() {
		return totalSimultaneousUserCount;
	}
	
}
