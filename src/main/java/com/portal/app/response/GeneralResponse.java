package com.portal.app.response;

import static com.portal.app.util.Constants.OK;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;

@JsonInclude(Include.NON_NULL)
public class GeneralResponse extends Response 
{
	private static final long serialVersionUID = 1L;
	public GeneralResponse() { this.setStatus(OK);}
	public GeneralResponse(String data){super(data); }
	
	private List<Catalogo> catalogo ; 
	private List<CatalogoDet> catalogoDet ;
	
	public List<Catalogo> getCatalogo() {
		return catalogo;
	}
	public void setCatalogo(List<Catalogo> catalogo) {
		this.catalogo = catalogo;
	}
	public List<CatalogoDet> getCatalogoDet() {
		return catalogoDet;
	}
	public void setCatalogoDet(List<CatalogoDet> catalogoDet) {
		this.catalogoDet = catalogoDet;
	} 

	
}
