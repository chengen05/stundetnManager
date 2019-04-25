package www.page.action;

import java.util.List;
/**
 * 
 * 用户信息分页显示数据
 */
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.Action;

import lombok.Data;
import www.basePo.dao.UserInfoDao;
import www.basePo.dao.UserRoleNodeDao;
import www.basePo.imple.UserInfoImple;
import www.basePo.imple.UserRoleNodeImple;
import www.basePo.po.UserInfo;

@Data
public class UserInfoJson {
	private JSONObject userinfoJson;
	private int rowoffset;
	private int pageSize;
	public String execute()
	{
		
		UserInfoDao userDo = new UserInfoImple();
		List<UserInfo> userPageCode = userDo.selectPageCode(pageSize, rowoffset);
		List<UserInfo> userAll = userDo.selectAll();
		JSONObject schoolinfo= new JSONObject(); 
		schoolinfo.put("total", userAll.size());
		schoolinfo.put("rows", listToJson(userPageCode));
		this.userinfoJson = schoolinfo;
		return Action.SUCCESS;
	}
	private JSONArray listToJson(List<UserInfo> userinfo)
	{	
		UserRoleNodeDao userRoleNode = new UserRoleNodeImple();
		
		JSONArray json = new JSONArray();
		for(UserInfo dep: userinfo)
		{
		
			JSONObject jo =new JSONObject();
			jo.put("id",dep.getUserId());
			jo.put("loginaccount", dep.getAccount());
			jo.put("password", dep.getPassword());
			jo.put("userName",dep.getName());
			jo.put("photo",dep.getPhoto());
			jo.put("sex", dep.getGender());
			jo.put("roleid", userRoleNode.selectById(dep.getUserRoleId()).getName());
			jo.put("rolenameid", dep.getUserRoleId());
			json.add(jo);
		}
		
		return json;
	}
}
