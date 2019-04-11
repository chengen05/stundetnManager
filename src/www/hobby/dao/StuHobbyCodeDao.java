package www.hobby.dao;

import www.hobby.po.StuHobbyCode;

public interface StuHobbyCodeDao {
	public boolean  insertStuHobbyCode(StuHobbyCode stuHobbyCode);
	
	public boolean updateStuHobbyCode(StuHobbyCode stuHobbyCode);
	
	public boolean delStuHobbyCode(int stuHobbyCodeId);
}
