package com.portal.app.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.portal.app.dao.CPDao;
import com.portal.app.dto.CodPostal;
import com.portal.app.service.SubJob;

@Component
public class SubJobImpl implements SubJob{

	private static final Logger log = LoggerFactory.getLogger(SubJobImpl.class);

	@Autowired
	private CPDao dao;
	
	@Override
	@Async("cpExecutor")
	public void regitrarSocio(CodPostal cp) {
		dao.registroCP(cp);
	}
}
