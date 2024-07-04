package com.portal.app.service;

import com.portal.app.request.GeneralRequest;
import com.portal.app.response.GeneralResponse;

public interface GeneralService{
	
	GeneralResponse catalogoList 			(GeneralRequest request);
	
	GeneralResponse catalogoByIdList 		(GeneralRequest request);
	GeneralResponse catalogoSave 			(GeneralRequest request);
	GeneralResponse catalogoUpdate			(GeneralRequest request);
	GeneralResponse catalogoUpdateEstatus 	(GeneralRequest request);
	
}
