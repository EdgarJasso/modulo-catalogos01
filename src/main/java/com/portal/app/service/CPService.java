package com.portal.app.service;

import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;

public interface CPService{
	void loadCsv( String path);
	
	CPResponse estadoList();
	CPResponse codigoPostalList(CPRequest request);

}
