package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.Catalogo;
import com.portal.app.dto.CatalogoDet;
import com.portal.app.request.GeneralRequest;

public interface GeneralDao{
	
	List<Catalogo> catalogoList(GeneralRequest request);
	
	List<CatalogoDet> catalogoListByID(GeneralRequest request);
	void catalogoSave (GeneralRequest request);
	void catalogoUpdate(GeneralRequest request);
	void catalogoUpdateEstatus(GeneralRequest request);

}
