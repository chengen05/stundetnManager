package www.page.action;

import java.util.Map;


import com.opensymphony.xwork2.ActionSupport;

public class Exit extends ActionSupport{
	private Map<String, Object> session;
	public String exitdo()
	{
		
		session.remove("userinfo");
	     
		return "success";
	}
}
