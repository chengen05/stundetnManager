package www.kaoqin.dao;

import www.kaoqin.po.DormCheck;

public interface DormCheckDao {
	public boolean  insertDormCheck(DormCheck dormCheck);
	
	public boolean updateDormCheck(DormCheck dormCheck);
	
	public boolean delDormCheck(int dormCheckId);
}
