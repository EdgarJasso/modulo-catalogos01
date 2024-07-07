package com.portal.app.request;

import java.util.Date;

import javax.persistence.Column;

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

	private String	cpKeyStr;
	private String  cpCodigoStr;
	private String  cpCveEstadoStr;
	private String  cpCveMnpioStr;
	private String  cpIdAsentaCpconsStr;
	private String  cpCveCiudadStr;
	private String  cpAsentaStr;
	private String  cpMnpioStr;
	private String  cpCiudadStr;
	
	
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
	public String getCpKeyStr() {
		return cpKeyStr;
	}
	public void setCpKeyStr(String cpKeyStr) {
		this.cpKeyStr = cpKeyStr;
	}
	public String getCpCodigoStr() {
		return cpCodigoStr;
	}
	public void setCpCodigoStr(String cpCodigoStr) {
		this.cpCodigoStr = cpCodigoStr;
	}
	public String getCpCveEstadoStr() {
		return cpCveEstadoStr;
	}
	public void setCpCveEstadoStr(String cpCveEstadoStr) {
		this.cpCveEstadoStr = cpCveEstadoStr;
	}
	public String getCpCveMnpioStr() {
		return cpCveMnpioStr;
	}
	public void setCpCveMnpioStr(String cpCveMnpioStr) {
		this.cpCveMnpioStr = cpCveMnpioStr;
	}
	public String getCpIdAsentaCpconsStr() {
		return cpIdAsentaCpconsStr;
	}
	public void setCpIdAsentaCpconsStr(String cpIdAsentaCpconsStr) {
		this.cpIdAsentaCpconsStr = cpIdAsentaCpconsStr;
	}
	public String getCpCveCiudadStr() {
		return cpCveCiudadStr;
	}
	public void setCpCveCiudadStr(String cpCveCiudadStr) {
		this.cpCveCiudadStr = cpCveCiudadStr;
	}
	public String getCpAsentaStr() {
		return cpAsentaStr;
	}
	public void setCpAsentaStr(String cpAsentaStr) {
		this.cpAsentaStr = cpAsentaStr;
	}
	public String getCpMnpioStr() {
		return cpMnpioStr;
	}
	public void setCpMnpioStr(String cpMnpioStr) {
		this.cpMnpioStr = cpMnpioStr;
	}
	public String getCpCiudadStr() {
		return cpCiudadStr;
	}
	public void setCpCiudadStr(String cpCiudadStr) {
		this.cpCiudadStr = cpCiudadStr;
	}

	
	
	
	
	
}
