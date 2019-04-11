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
	
	public String showSchoolDepartInfo()
	{
		schoolDepartments = new ArrayList<SchoolDepartment>();
		SchoolDepartmentDao schoolDo = new SchoolDepartmentImple();
		this.schoolDepartments=schoolDo.selectAll();
	
		return "success";
	}
}
