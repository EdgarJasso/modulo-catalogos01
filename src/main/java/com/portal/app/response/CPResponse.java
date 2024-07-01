package com.portal.app.response;

import static com.portal.app.util.Constants.OK;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class CPResponse extends Response 
{
	private static final long serialVersionUID = 1L;
	public CPResponse() { this.setStatus(OK);}
	public CPResponse(String data){super(data); }
	
	
}
