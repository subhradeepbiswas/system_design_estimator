package com.techsol.systemdesignestimator.model;

public class Traffic {
	private long writeReqs;
	private long readReqs;
	private String writeReqFormula;
	private String readReqFormula;
	private String freq;
	
	public Traffic(long readReqs, long writeReqs, String readReqFormula, String writeReqFormula, String freq) {
		this.readReqs = readReqs;
		this.writeReqs = writeReqs;
		this.readReqFormula = readReqFormula;
		this.writeReqFormula = writeReqFormula;
		this.freq = freq;
	}
	
	public long getWriteReqs() {
		return writeReqs;
	}
	public void setWriteReqs(long writeReqs) {
		this.writeReqs = writeReqs;
	}
	public long getReadReqs() {
		return readReqs;
	}
	public void setReadReqs(long readReqs) {
		this.readReqs = readReqs;
	}
	public String getWriteReqFormula() {
		return writeReqFormula;
	}
	public void setWriteReqFormula(String writeReqFormula) {
		this.writeReqFormula = writeReqFormula;
	}
	public String getReadReqFormula() {
		return readReqFormula;
	}
	public void setReadReqFormula(String readReqFormula) {
		this.readReqFormula = readReqFormula;
	}
	public String getFreq() {
		return freq;
	}
	public void setFreq(String freq) {
		this.freq = freq;
	}
	
	
}
