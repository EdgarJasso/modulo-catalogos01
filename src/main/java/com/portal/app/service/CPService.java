package com.portal.app.service;

import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;

public interface CPService{
	CPResponse loadCsv( CPRequest request);
	
}
