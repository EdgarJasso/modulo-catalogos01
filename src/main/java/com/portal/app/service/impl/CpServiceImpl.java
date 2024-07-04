package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.CPDao;
import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;
import com.portal.app.service.CPService;
import com.portal.app.service.Job;


@Service
public class CpServiceImpl implements CPService 
{
	private static final Logger log = LoggerFactory.getLogger(CpServiceImpl.class);
	
	@Autowired private Job job;
	@Autowired private CPDao dao;

	@Override
	public void loadCsv(String path) {
		try {
			job.loadCsvToSaveCP(path);
		} catch (Exception e) {
			log.error(e.getMessage());	
		}
	}

	@Override
	public CPResponse estadoList() {
		log.info("estadoList");
		CPResponse response = new CPResponse();
		try {
			response.setEstado(dao.estadoList());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public CPResponse codigoPostalList(CPRequest request) {
		log.info("codigoPostalList:"+ new Gson().toJson(request));
		CPResponse response = new CPResponse();
		try {
			response.setCodigoPostal(dao.codigoPostalList(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	
}
