package com.portal.app.service.impl;

import org.springframework.stereotype.Service;

import com.portal.app.service.QueryBuilder;

@Service
public class QueryBuilderImpl implements QueryBuilder {

    @Override
    public String countGetCodigoPostalList() {
        StringBuilder query = new StringBuilder();
            query.append("SELECT PKG_PORTAL_CAT01.GET_CP_VIEW_COUNT( ");
                query.append(" :codigo ");
                query.append(" ,:estado ");
                query.append(" ,:mnpio ");
            query.append(") FROM DUAL");    
        return query.toString();
    }

}