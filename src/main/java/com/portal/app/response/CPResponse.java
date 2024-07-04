package com.portal.app.response;

import static com.portal.app.util.Constants.OK;

import java.util.List;

import com.portal.app.dto.CodigoPostal;
import com.portal.app.dto.Estado;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CPResponse extends Response 
{
	private static final long serialVersionUID = 1L;

	private List<Estado> estado;
	private List<CodigoPostal> codigoPostal;

	public List<Estado> getEstado() {
		return estado;
	}
	public void setEstado(List<Estado> estado) {
		this.estado = estado;
	}
	
	public List<CodigoPostal> getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(List<CodigoPostal> codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public CPResponse() { this.setStatus(OK);}
	public CPResponse(String data){super(data); }
	


	
}
