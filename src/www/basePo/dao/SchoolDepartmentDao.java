package www.basePo.dao;

import java.util.List;

import www.basePo.po.SchoolDepartment;;
/**
 * ��ѧУְ�����ŵĳ��󷽷�
 * @author chen gen
 *
 */
public interface SchoolDepartmentDao {
	public boolean  insertSchoolDepart(SchoolDepartment schoolDepart);
	
	public boolean updateSchoolDepart(SchoolDepartment schoolDepart);
	
	public boolean delSchoolDepart(int schoolDepartId);
	
	public List<SchoolDepartment> selectAll();
}
