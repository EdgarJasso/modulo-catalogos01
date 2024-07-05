package com.portal.app.util;

public class Constants 
{
	private Constants(){}
	/*Roles*/
	public static final String APPLICATION					   = "APPLICATION";	
	
	/*Ambiente*/
	public static final String	LOCAL							= "local";
	public static final String	TEST							= "test";
	public static final String	PRODUCCION						= "prod";
	
	/*Estatus de proceso*/
	public static final int ERROR								= 500;
	public static final int OK									= 200;
	public static final int BAD_REQUEST							= 400;
	public static final int CONFLICT							= 409;
	public static final String FALTAN_PARAMETROS				= "Faltan parámetros de entrada";

	public static final int	LIST								= 1;
	

}
