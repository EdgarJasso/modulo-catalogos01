package com.portal.app.dao;

import java.util.List;

import com.portal.app.dto.CodPostal;
import com.portal.app.dto.Estado;
import com.portal.app.dto.RsCPData;
import com.portal.app.request.CPRequest;

public interface CPDao{
	public boolean registroCP (CodPostal cp);
	public List<Estado> estadoList();
	public Long getCodigoPostalListCount(CPRequest request);
	public List<CodPostal> codigoPostalList(CPRequest request);
	public List<RsCPData> getCPData(CPRequest request);

}
