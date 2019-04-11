package www.kaoqin.dao;

import www.kaoqin.po.DormCheckItem;;

public interface DormCheckItemDao {
	public boolean  insertDormCheckItem(DormCheckItem dormCheckItem);
	
	public boolean updateDormCheckItem(DormCheckItem dormCheckItem);
	
	public boolean delDormCheckItem(int dormCheckItemId);
}
