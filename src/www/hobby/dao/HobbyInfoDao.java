package www.hobby.dao;

import www.hobby.po.HobbyInfo;

public interface HobbyInfoDao {
	public boolean  insertHobbyInfo(HobbyInfo hobbyInfo);
	
	public boolean updateHobbyInfo(HobbyInfo hobbyInfo);
	
	public boolean delHobbyInfo(int hobbyInfoId);
}