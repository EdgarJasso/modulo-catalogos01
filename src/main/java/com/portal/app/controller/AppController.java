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
import com.portal.app.response.AppResponse;
import com.portal.app.service.AppService;
import com.portal.app.util.Parser;

@RestController
@RequestMapping(value="/service",produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
public class AppController 
{
	@Autowired	private AppService service;
	
	@PostMapping(value = "/testConexion")
	public AppResponse testConexion(@RequestBody AppRequest request)
	{
		return request.getData()!=null ?
		 new AppResponse(Parser.ENCODE(
			service.testConexion(Parser.DECODE(request)))) :  
			service.testConexion(request);
	}
	
	@PostMapping(value = "/template")
	public  ResponseEntity<AppResponse> template(@RequestBody AppRequest request)
	{
		AppResponse response =  service.template(Parser.DECODE(request));
		int status	= response.getStatus();
		response = new AppResponse(Parser.ENCODE(response));
		HttpStatus httpStatus = null;
		switch (status) 
		{
			case OK: 			httpStatus = HttpStatus.OK;						break;
			case BAD_REQUEST: 	httpStatus = HttpStatus.BAD_REQUEST;			break;
			case CONFLICT:		httpStatus = HttpStatus.CONFLICT;				break;
			case ERROR:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
			default:			httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;	break;
		}
		return new ResponseEntity<AppResponse>(response,httpStatus);
	}
}
