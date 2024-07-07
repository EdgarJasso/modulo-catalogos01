package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.GetRSView;
import com.portal.app.request.RazonSocRequest;

public interface RazonSocDao{
	
	List<GetRSView> getRSView(RazonSocRequest request);
	void razonSocSave 			(RazonSocRequest request);
	void razonSocUpdate 		(RazonSocRequest request);
	void razonSocUpdteEstatus 	(RazonSocRequest request);
	
	
}
