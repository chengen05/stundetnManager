package www.basePo.dao;

import www.basePo.po.Family;

public interface FamilyDao {
	public boolean  insertFamily(Family family);
	
	public boolean updateFamily(Family family);
	
	public boolean delFamily(int familyId);
}
