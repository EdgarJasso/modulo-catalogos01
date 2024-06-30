package com.portal.app.controller;

import static com.portal.app.util.Constants.BAD_REQUEST;
import static com.portal.app.util.Constants.CONFLICT;
import static com.portal.app.util.Constants.ERROR;
import static com.portal.app.util.Constants.OK;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.app.request.AppRequest;
import com.portal.app.request.GeneralRequest;
import com.portal.app.response.AppResponse;
import com.portal.app.response.GeneralResponse;
import com.portal.app.service.AppService;
import com.portal.app.service.GeneralService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class GeneralController 
{
	@Autowired	private GeneralService service;
	
	@PostMapping(value = "/getCatalogo")
	public GeneralResponse getCatalogo(@RequestBody GeneralRequest request)
	{
		return request.getData()!=null ?
		 new GeneralResponse(Parser.ENCODE(
			service.getCatalogo(Parser.DECODE(request)))) :  
			service.getCatalogo(request);
	}
	
	@PostMapping(value = "/getCatalogoDet")
	public GeneralResponse getCatalogoDet(@RequestBody GeneralRequest request)
	{
		return request.getData()!=null ?
		 new GeneralResponse(Parser.ENCODE(
			service.getCatalogoDet(Parser.DECODE(request)))) :  
			service.getCatalogoDet(request);
	}
	
	@PostMapping(value = "/saveCatalogoDet")
	public GeneralResponse saveCatalogoDet(@RequestBody GeneralRequest request)
	{
		return request.getData()!=null ?
		 new GeneralResponse(Parser.ENCODE(
			service.saveCatalogoDet(Parser.DECODE(request)))) :  
			service.saveCatalogoDet(request);
	}
	
	@PostMapping(value = "/updateEstatusCatalogoDet")
	public GeneralResponse updateEstatusCatalogoDet(@RequestBody GeneralRequest request)
	{
		return request.getData()!=null ?
		 new GeneralResponse(Parser.ENCODE(
			service.updateEstatusCatalogoDet(Parser.DECODE(request)))) :  
			service.updateEstatusCatalogoDet(request);
	}
	
	@PostMapping(value = "/updateCatalogoDet")
	public GeneralResponse updateCatalogoDet(@RequestBody GeneralRequest request)
	{
		return request.getData()!=null ?
		 new GeneralResponse(Parser.ENCODE(
			service.updateCatalogoDet(Parser.DECODE(request)))) :  
			service.updateCatalogoDet(request);
	}
}
