package com.portal.app.service;

import com.portal.app.request.AppRequest;
import com.portal.app.request.GeneralRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.GeneralResponse;

public interface GeneralService{
	
	GeneralResponse getCatalogo (GeneralRequest request);
	GeneralResponse getCatalogoDet (GeneralRequest request);
	GeneralResponse saveCatalogoDet (GeneralRequest request);
	GeneralResponse updateEstatusCatalogoDet(GeneralRequest request);
	GeneralResponse updateCatalogoDet (GeneralRequest request);
	
}
