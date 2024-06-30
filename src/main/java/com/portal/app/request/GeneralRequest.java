package com.portal.app.request;

public class GeneralRequest extends Request
{
	private static final long serialVersionUID = 1L;
	
	private long catIdN;
	private long catDIdN;
	private String catDCveStr;
	private String catDescStr;
	private String catEstStr;
	
	public long getCatIdN() {
		return catIdN;
	}
	public void setCatIdN(long catIdN) {
		this.catIdN = catIdN;
	}
	public long getCatDIdN() {
		return catDIdN;
	}
	public void setCatDIdN(long catDIdN) {
		this.catDIdN = catDIdN;
	}
	public String getCatDCveStr() {
		return catDCveStr;
	}
	public void setCatDCveStr(String catDCveStr) {
		this.catDCveStr = catDCveStr;
	}
	public String getCatDescStr() {
		return catDescStr;
	}
	public void setCatDescStr(String catDescStr) {
		this.catDescStr = catDescStr;
	}
	public String getCatEstStr() {
		return catEstStr;
	}
	public void setCatEstStr(String catEstStr) {
		this.catEstStr = catEstStr;
	}
	
	
	
}
