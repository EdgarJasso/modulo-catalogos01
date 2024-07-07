package com.portal.app.service.impl;

import static com.portal.app.util.Constants.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.portal.app.dao.CPDao;
import com.portal.app.dto.CodPostal;
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
	public Long loadCsv(String path) {
		Long out = 0L;
		try {
			out = job.loadCsvToSaveCP(path);
		} catch (Exception e) {
			log.error(e.getMessage());	
		}
		return out;
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
			Long total = request.getTotal();
			List<CodPostal> resulset = new ArrayList<CodPostal>();

			if(total==null) total=dao.getCodigoPostalListCount(request);
			if(total > 0) resulset = dao.codigoPostalList(request);

			response.setTotal(total);
			response.setCodigoPostal(resulset);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public CPResponse getCPData(CPRequest request) {
		log.info("getCPData");
		CPResponse response = new CPResponse();
		try {
			response.setCpData(dao.getCPData(request));
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public CPResponse codigoSaveOrUpdate(CPRequest request) {
		log.info("codigoSaveOrUpdate:"+new Gson().toJson(request));
		CPResponse response = new CPResponse();
		try {
			dao.codigoSaveOrUpdate(request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}

	@Override
	public CPResponse codigoDelete(CPRequest request) {
		log.info("codigoDelete:"+new Gson().toJson(request));
		CPResponse response = new CPResponse();
		try {
			dao.codigoDelete(request);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			response.setStatus(ERROR);
			response.setMessage(e.getMessage());
		}
		return response;
	}
	
	
}
