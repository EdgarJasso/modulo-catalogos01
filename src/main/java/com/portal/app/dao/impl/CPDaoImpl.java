package com.portal.app.dao.impl;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.portal.app.dao.AppDao;
import com.portal.app.dao.CPDao;
import com.portal.app.dto.CodigoPostal;
import com.portal.app.request.AppRequest;
import com.portal.app.response.AppResponse;

@Repository
@Transactional(readOnly=true,rollbackFor = Exception.class)
public class CPDaoImpl implements CPDao{
	private static final Logger log = LoggerFactory.getLogger(CPDaoImpl.class);
	
	@Autowired	private SessionFactory session;

	@Override
	@Transactional(readOnly = false)
	public boolean registroCP(CodigoPostal cp) {
		boolean insert = true;
		try {
			session.getCurrentSession().save(cp);
		} catch (Exception e) {
			log.info("========================================================");
			log.info("cp info: "+new Gson().toJson(cp));
			log.info("error: "+e.getMessage());
			log.info("========================================================");
		}
		if(cp.getId_n().equals(null)) { insert = false;	}
		return insert;
	}
	
	

}
