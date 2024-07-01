package com.portal.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.request.CPRequest;
import com.portal.app.response.CPResponse;
import com.portal.app.service.CPService;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class CPController 
{
	@Autowired	private CPService service;
	
	@PostMapping(value = "/loadCsv")
	public CPResponse loadCsv(@RequestBody CPRequest request)
	{
		return service.loadCsv(request);
	}
	
	
}
