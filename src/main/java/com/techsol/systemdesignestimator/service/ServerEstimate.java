package com.techsol.systemdesignestimator.service;

public class ServerEstimate {
	private String formula;
	private int serverRequired;
	
	public ServerEstimate(String formula, int serverRequired) {
		super();
		this.formula = formula;
		this.serverRequired = serverRequired;
	}
	
	public String getFormula() {
		return formula;
	}
	public void setFormula(String formula) {
		this.formula = formula;
	}
	public int getServerRequired() {
		return serverRequired;
	}
	public void setServerRequired(int serverRequired) {
		this.serverRequired = serverRequired;
	}
	
	
}
