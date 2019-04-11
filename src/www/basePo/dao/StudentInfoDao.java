package www.basePo.dao;

import www.basePo.po.StudentInfo;

public interface StudentInfoDao {
	public boolean  insertStudentInfo(StudentInfo studentInfo);
	
	public boolean updateStudentInfo(StudentInfo studentInfo);
	
	public boolean delStudentInfo(int studentInfoId);
}
