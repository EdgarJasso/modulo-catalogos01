package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.RazonSocDao;
import com.portal.app.request.RazonSocRequest;
import com.portal.app.response.RazonSocResponse;
import com.portal.app.service.RazonSocService;

@Service
public class RazonSocServiceImpl implements RazonSocService 
{
	private static final Logger log = LoggerFactory.getLogger(RazonSocServiceImpl.class);
	
	@Autowired private RazonSocDao dao;

	@Override
	public RazonSocResponse razonSocView(RazonSocRequest request) {
		log.info("razonSocView:"+ new Gson().toJson(request));
		RazonSocResponse response = new RazonSocResponse();	
		try {
			response.setRsView(dao.getRSView(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
	return response;
	}

	@Override
	public RazonSocResponse razonSocSave(RazonSocRequest request) {
	log.info("razonSocSave:"+ new Gson().toJson(request));
	RazonSocResponse response = new RazonSocResponse();	
		try {
			dao.razonSocSave(request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
	return response;
	}

	@Override
	public RazonSocResponse razonSocUpdate(RazonSocRequest request) {
		log.info("razonSocUpdate:"+ new Gson().toJson(request));
		RazonSocResponse response = new RazonSocResponse();	
			try {
				dao.razonSocUpdate(request);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	@Override
	public RazonSocResponse razonSocUpdateEstatus(RazonSocRequest request) {
		log.info("razonSocUpdateEstatus:"+ new Gson().toJson(request));
		RazonSocResponse response = new RazonSocResponse();	
			try {
				dao.razonSocUpdteEstatus(request);
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	

	

	
	
}
