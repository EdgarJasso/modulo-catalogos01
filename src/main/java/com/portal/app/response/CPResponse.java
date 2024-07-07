package com.portal.app.response;

import static com.portal.app.util.Constants.OK;

import java.util.List;

import com.portal.app.dto.CodPostal;
import com.portal.app.dto.Estado;
import com.portal.app.dto.RsCPData;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CPResponse extends Response 
{
	private static final long serialVersionUID = 1L;

	private List<Estado> estado;
	private Long total;
	private List<CodPostal> codigoPostal;
	private List<RsCPData> cpData;

	public List<Estado> getEstado() {
		return estado;
	}
	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public List<CodPostal> getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(List<CodPostal> codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public List<RsCPData> getCpData() {
		return cpData;
	}
	public void setCpData(List<RsCPData> cpData) {
		this.cpData = cpData;
	}
	public CPResponse() { this.setStatus(OK);}
	public CPResponse(String data){super(data); }
	


	
}
