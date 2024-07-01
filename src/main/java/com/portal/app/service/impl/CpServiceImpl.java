package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;
import com.portal.app.service.CPService;
import com.portal.app.service.Job;
import com.portal.app.util.Contador;


@Service
public class CpServiceImpl implements CPService 
{
	private static final Logger log = LoggerFactory.getLogger(CpServiceImpl.class);
	
	@Autowired private Job job;

	@Override
	public CPResponse loadCsv(CPRequest request) {
		CPResponse response = new CPResponse();
		try {
			job.loadCsvToSaveCP(request);
			response.setMessage("Procesando, espere un momento");
		} catch (Exception e) {
			log.error(e.getMessage());	
		}
		return response;
	}
	
	
}
