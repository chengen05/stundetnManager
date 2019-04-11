package www.kaoqin.dao;

import www.kaoqin.po.DormCheckSocre;

public interface DormCheckSocreDao {
	public boolean  insertDormCheckSocre(DormCheckSocre dormCheckSocre);
	
	public boolean updateDormCheckSocre(DormCheckSocre dormCheckSocre);
	
	public boolean delDormCheckSocre(int dormCheckSocreId);
}
