package com.portal.app.request;

public class CPRequest extends Request
{
	private static final long serialVersionUID = 1L;
	
	private String csvPath;
	private String codigoPStr;
	private String estadoStr;
	private String mnpioStr;
	
	public String getCsvPath() {
		return csvPath;
	}
	public void setCsvPath(String csvPath) {
		this.csvPath = csvPath;
	}
	public String getCodigoPStr() {
		return codigoPStr;
	}
	public void setCodigoPStr(String codigoPStr) {
		this.codigoPStr = codigoPStr;
	}
	public String getEstadoStr() {
		return estadoStr;
	}
	public void setEstadoStr(String estadoStr) {
		this.estadoStr = estadoStr;
	}
	public String getMnpioStr() {
		return mnpioStr;
	}
	public void setMnpioStr(String mnpioStr) {
		this.mnpioStr = mnpioStr;
	}

	
	
	
	
}
