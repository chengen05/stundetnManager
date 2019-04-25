package www.page.action;

import java.util.List;



import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.opensymphony.xwork2.Action;

import lombok.Data;
import www.basePo.dao.SchoolDepartmentDao;
import www.basePo.imple.SchoolDepartmentImple;
import www.basePo.po.SchoolDepartment;

/**
 * 学院部门json数据封装
 * @author chen gen
 *
 */

@Data
public class SchoolDepartJson {
	//	private JSONArray schoolJson;
		private JSONObject schoolJson;
		private int rowoffset;
		private int pageSize;
		public String execute()
		{
			
			SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
			List<SchoolDepartment> depart = schoolDo.selectfind(pageSize, rowoffset);
			List<SchoolDepartment> departAll = schoolDo.selectAll();
			JSONObject schoolinfo= new JSONObject(); 
			schoolinfo.put("total", departAll.size());
			schoolinfo.put("rows", listToJson(depart));
			this.schoolJson = schoolinfo;
			return Action.SUCCESS;
		}
		private JSONArray listToJson(List<SchoolDepartment> depart)
		{
			JSONArray json = new JSONArray();
			for(SchoolDepartment dep: depart)
			{
			
				JSONObject jo =new JSONObject();
				jo.put("id",dep.getSchoolDepartId());
				jo.put("name", dep.getDepartmentName());
				jo.put("departtype", dep.getDepartmentType());
				jo.put("linkMan",dep.getDepartmentLinkman());
				jo.put("office",dep.getOfficeAddress());
				jo.put("phoneNum", dep.getPhoneNumber());
				json.add(jo);
			}
			
			return json;
		}
}
