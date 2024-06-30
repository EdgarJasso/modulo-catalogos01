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
	public GeneralResponse getCatalogo(GeneralRequest request) {
		log.info("getCatalogo" + new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
			try {
				
				response.setCatalogo(dao.getCatalogos(request));
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	@Override
	public GeneralResponse getCatalogoDet(GeneralRequest request) {
		log.info("getCatalogoDet" + new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
			try {
				
				response.setCatalogoDet(dao.getCatalogosDet(request));
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	@Override
	public GeneralResponse saveCatalogoDet(GeneralRequest request) {
		log.info("saveCatalogoDet" + new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
			try {
				long catIdN = request.getCatIdN();
				String catDescString =  request.getCatDescStr();
				String catDCveStr = request.getCatDCveStr();
				
				if(catIdN > 0 && catDescString != null && catDCveStr != null) {
					response.setMessage(dao.saveCatalogoDet(request));
				}else {
					response.setMessage(FALTAN_PARAMETROS);
				}
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	@Override
	public GeneralResponse updateCatalogoDet(GeneralRequest request) {
		log.info("updateCatalogoDet" + new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
			try {
				long catIdN = request.getCatIdN();
				long catDIdN = request.getCatDIdN();
				String catDescString =  request.getCatDescStr();
				String catDCveStr = request.getCatDCveStr();
				
				if(catIdN > 0 && catDIdN > 0 && catDescString != null && catDCveStr != null) {
					response.setMessage(dao.updateCatalogoDet(request));
				}else {
					response.setMessage(FALTAN_PARAMETROS);
				}
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}

	@Override
	public GeneralResponse updateEstatusCatalogoDet(GeneralRequest request) {
		log.info("updateEstatusCatalogoDet" + new Gson().toJson(request));
		GeneralResponse response = new GeneralResponse();
			try {
				long catDIdN = request.getCatDIdN();
				
				if(catDIdN > 0) {
					response.setMessage(dao.updateEstatusCatalogoDet(request));
				}else {
					response.setMessage(FALTAN_PARAMETROS);
				}
				
			} catch (Exception e) {
				log.error(e.getMessage(), e);
				response.setStatus(ERROR);
				response.setMessage(e.getMessage());
			}
		return response;
	}
	
	
}
