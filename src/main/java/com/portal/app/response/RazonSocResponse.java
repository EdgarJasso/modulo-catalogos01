package com.portal.app.response;


import static com.portal.app.util.Constants.OK;
import java.util.List;
import com.portal.app.dto.GetRSView;


public class RazonSocResponse extends Response 
{
	private static final long serialVersionUID = 1L;

	private List<GetRSView> rsView;
	
	public List<GetRSView> getRsView() {
		return rsView;
	}
	public void setRsView(List<GetRSView> rsView) {
		this.rsView = rsView;
	}
	public RazonSocResponse() { this.setStatus(OK);}
	public RazonSocResponse(String data){super(data); }
	
}
