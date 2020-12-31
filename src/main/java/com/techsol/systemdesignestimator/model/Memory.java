package com.techsol.systemdesignestimator.model;

public class Memory {
	private String consideration;
	private String formula;
	private String estimatedCache;
	private long bytesReadPerSec;
	
	public Memory(String consideration, String formula, String reqdMemoryText, long bytesReadPerSec) {
		this.consideration = consideration;
		this.formula = formula;
		this.estimatedCache = reqdMemoryText;
		this.bytesReadPerSec = bytesReadPerSec;
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

	public String getEstimatedCache() {
		return estimatedCache;
	}

	public void setEstimatedCache(String estimatedCache) {
		this.estimatedCache = estimatedCache;
	}

	public long getBytesReadPerSec() {
		return bytesReadPerSec;
	}
	
}
