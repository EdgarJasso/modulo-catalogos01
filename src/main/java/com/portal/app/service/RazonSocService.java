package com.portal.app.service;

import com.portal.app.request.RazonSocRequest;
import com.portal.app.response.RazonSocResponse;

public interface RazonSocService{
	
	RazonSocResponse razonSocView				(RazonSocRequest request);
	RazonSocResponse razonSocSave 			(RazonSocRequest request);
	RazonSocResponse razonSocUpdate			(RazonSocRequest request);
	RazonSocResponse razonSocUpdateEstatus 	(RazonSocRequest request);
	
}
