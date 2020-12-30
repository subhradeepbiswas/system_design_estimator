package com.techsol.systemdesignestimator.model;

public class Storage {
	private String consideration;
	private String formula;
	private String estimatedStorage;
	
	public Storage(String consideration, String formula, String storageText) {
		this.consideration = consideration;
		this.formula = formula;
		this.estimatedStorage = storageText;
	}

	public String getConsideration() {
		return consideration;
	}

	public void setConsideration(String consideration) {
		this.consideration = consideration;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getEstimatedStorage() {
		return estimatedStorage;
	}

	public void setEstimatedStorage(String estimatedStorage) {
		this.estimatedStorage = estimatedStorage;
	};
	
}
