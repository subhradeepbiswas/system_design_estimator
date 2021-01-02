package com.techsol.systemdesignestimator.model;

public class ServerEstimate {
	private String formula;
	private int serverRequired;
	private int totalServerRequiredWithReplica;
	
	public ServerEstimate(String formula, int serverRequired, int totalServerRequiredWithReplica) {
		super();
		this.formula = formula;
		this.serverRequired = serverRequired;
		this.totalServerRequiredWithReplica = totalServerRequiredWithReplica;
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
	public int getTotalServerRequiredWithReplica() {
		return totalServerRequiredWithReplica;
	}
	
}
