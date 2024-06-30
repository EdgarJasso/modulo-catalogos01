package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;
import com.portal.app.request.GeneralRequest;

public interface GeneralDao{
	
	public List<Catalogo> getCatalogos(GeneralRequest request);
	public String saveCatalogo (GeneralRequest request);
	public String updateCatalogo (GeneralRequest request);
	
	public List<CatalogoDet> getCatalogosDet(GeneralRequest request);
	public String saveCatalogoDet (GeneralRequest request);
	public String updateEstatusCatalogoDet(GeneralRequest request);
	public String updateCatalogoDet (GeneralRequest request);
}
