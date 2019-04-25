package www.page.action;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import www.basePo.po.SystemOperate;

public class MenuTree {
	/*
	 * ÊµÏÖÊ÷
	 */
	 
	  public List<SystemOperate> menuCommon; 
	  public List<Object> list = new ArrayList<Object>(); 
	 
	  public JSONArray menuList(List<SystemOperate> menu){  
		  JSONArray jsonlist = new JSONArray(); 
	    this.menuCommon = menu; 
	    for (SystemOperate x : menu) {   
	    	
	      if(x.getParentNode()==0){ 
	    	JSONObject jo =new JSONObject();
	        jo.put("id", x.getSystemId()); 
	        jo.put("name", x.getName());  
	        if(menuChild(x.getSystemId()).size()==0)
	        {
	        	jo.put("children", null); 
	        }
	        else {
	        jo.put("children", menuChild(x.getSystemId())); 
	        }
	    
	        jsonlist.add(jo); 
	      } 
	    }   
	    return jsonlist; 
	  } 
	   
	  public JSONArray menuChild(int id){ 
		  JSONArray jsonlistchild = new JSONArray();
	    for(SystemOperate a:menuCommon){ 
	    JSONObject jochild =new JSONObject();
	      if(a.getParentNode()== id){ 
	        jochild.put("id", a.getSystemId()); 
	        jochild.put("name", a.getName()); 
	        if(menuChild(a.getSystemId()).size()==0)
	        {
	        	jochild.put("children", null);
	        }
	        else {
	        jochild.put("children", menuChild(a.getSystemId()));
	        }
	        jsonlistchild.add(jochild); 
	      } 
	    } 
	    return jsonlistchild; 
	  } 
}
