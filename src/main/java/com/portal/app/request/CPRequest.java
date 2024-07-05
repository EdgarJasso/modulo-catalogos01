package com.portal.app.request;

import com.portal.app.domain.Pager;

public class CPRequest extends Request
{
	private static final long serialVersionUID = 1L;
	
	private Pager 	pager;
	private Long 	total;
	private String csvPath;
	private String codigoPStr;
	private String estadoStr;
	private String mnpioStr;
	
	
	public Pager getPager() {
		return pager;
	}
	public void setPager(Pager pager) {
		this.pager = pager;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
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
