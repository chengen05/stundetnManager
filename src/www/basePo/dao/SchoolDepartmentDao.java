package www.basePo.dao;

import java.util.List;

import www.basePo.po.SchoolDepartment;;
/**
 * 对学校职工部门的抽象方法
 * @author chen gen
 *
 */
public interface SchoolDepartmentDao {
	public boolean  insertSchoolDepart(SchoolDepartment schoolDepart);
	
	public boolean updateSchoolDepart(SchoolDepartment schoolDepart);
	
	public boolean delSchoolDepart(int schoolDepartId);
	
	public List<SchoolDepartment> selectAll();
}
