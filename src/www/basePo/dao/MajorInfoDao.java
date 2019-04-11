package www.basePo.dao;

import www.basePo.po.MajorInfo;;

public interface MajorInfoDao {
	public boolean  insertMajorInfo(MajorInfo majorInfo);
	
	public boolean updateMajorInfo(MajorInfo majorInfo);
	
	public boolean delMajorInfo(int majorInfoId);
}
