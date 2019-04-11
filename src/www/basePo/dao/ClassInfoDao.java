package www.basePo.dao;

import www.basePo.po.ClassInfo;

public interface ClassInfoDao {
	public boolean  insertClassInfo(ClassInfo classInfo);
	
	public boolean updateClassInfo(ClassInfo classInfo);
	
	public boolean delClassInfo(int classInfoId);
}
