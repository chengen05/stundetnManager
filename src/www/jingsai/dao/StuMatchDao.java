package www.jingsai.dao;

import www.jingsai.po.StuMatch;

public interface StuMatchDao {
public boolean  insertStuMatch(StuMatch stuMatch);
	
	public boolean updatestuMatch(StuMatch stuMatch);
	
	public boolean delStuMatch(int stuMatchId);
}
