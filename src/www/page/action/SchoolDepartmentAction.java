package www.page.action;

import java.util.ArrayList;
import java.util.List;



import lombok.Data;
import www.basePo.dao.SchoolDepartmentDao;
import www.basePo.imple.SchoolDepartmentImple;
import www.basePo.po.SchoolDepartment;

@Data
public class SchoolDepartmentAction {
	/**
	 * 对学校部门表的添加、修改、删除
	 */
	private List<SchoolDepartment> schoolDepartments;
	private SchoolDepartment schooldepart;
	private int departId;
	private int pageSize;
	private int rowoffset;
	/**
	 * 页面显示数据
	 * @return
	 */
	public String show()
	{
		return "success";
	}
	public String showSchoolDepartInfo()
	{
		schoolDepartments = new ArrayList<SchoolDepartment>();
		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
		this.schoolDepartments=schoolDo.selectAll();
	
		return "success";
	}
	public String addSchoolDepart()
	{
		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
		boolean judge = schoolDo.insertSchoolDepart(this.schooldepart);
		
	
			return "success";
		
		
	}
	public String upSchoolDepart()
	{
		
		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
		boolean judge= schoolDo.updateSchoolDepart(schooldepart);
		return "success";
	}
	public String delSchoolDepart()
	{

		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
		boolean judge= schoolDo.delSchoolDepart(departId);
		return "success";
	}
}
