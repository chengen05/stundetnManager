package www.kaoqin.dao;

import www.kaoqin.po.DormStu;

public interface DormStuDao {
	public boolean  insertDormStu(DormStu dormStu);
	
	public boolean updateDormStu(DormStu dormStu);
	
	public boolean delDormStu(int dormStuId);
}
