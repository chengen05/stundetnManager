package www.kaoqin.dao;

import www.kaoqin.po.DormInfo;

public interface DormInfoDao {
	public boolean  insertDormInfo(DormInfo dormInfo);
	
	public boolean updateDormInfo(DormInfo dormInfo);
	
	public boolean delDormInfo(int dormInfoId);
}
