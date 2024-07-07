package com.portal.app.service;

import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;

public interface CPService{
	Long loadCsv( String path);
	
	CPResponse estadoList();
	CPResponse codigoPostalList(CPRequest request);
	CPResponse getCPData(CPRequest request);

	CPResponse codigoSaveOrUpdate(CPRequest request);
	CPResponse codigoDelete(CPRequest request);
}
