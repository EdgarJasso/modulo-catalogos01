package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import javax.websocket.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.AppDao;
import com.portal.app.dao.GeneralDao;
import com.portal.app.request.AppRequest;
import com.portal.app.request.GeneralRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.GeneralResponse;
import com.portal.app.service.AppService;
import com.portal.app.service.GeneralService;

@Service
public class GeneralServiceImpl implements GeneralService 
{
	private static final Logger log = LoggerFactory.getLogger(GeneralServiceImpl.class);
	
	@Autowired private GeneralDao dao;

	@Override
	public GeneralResponse catalogoList(GeneralRequest request) {
		log.info("catalogoList:"+new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
		try {
			response.setCatalogo(dao.catalogoList(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public GeneralResponse catalogoByIdList(GeneralRequest request) {
		log.info("catalogoByIdList:"+new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
		try {
			response.setCatalogoDet(dao.catalogoListByID(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public GeneralResponse catalogoSave(GeneralRequest request) {
		log.info("catalogoSave:"+new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
		try {
			dao.catalogoSave(request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public GeneralResponse catalogoUpdate(GeneralRequest request) {
		log.info("catalogoUpdate:"+new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
		try {
			dao.catalogoUpdate(request);
			response.setCatalogoDet(dao.catalogoListByID(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public GeneralResponse catalogoUpdateEstatus(GeneralRequest request) {
		log.info("catalogoUpdateEstatus:"+new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
		try {
			dao.catalogoUpdate(request);
			response.setCatalogoDet(dao.catalogoListByID(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	
	
}
