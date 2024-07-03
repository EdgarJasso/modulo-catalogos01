package com.portal.app.response;


import static com.portal.app.util.Constants.OK;

import java.util.List;

import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;

public class GeneralResponse extends Response 
{
	private static final long serialVersionUID = 1L;

	private List<Catalogo> catalogo ; 
	private List<CatalogoDet> catalogoDet ;

	
	public GeneralResponse() { this.setStatus(OK);}
	public GeneralResponse(String data){super(data); }
	
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
