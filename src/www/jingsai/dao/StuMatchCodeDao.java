package www.jingsai.dao;

import www.jingsai.po.StuMatchCode;;

public interface StuMatchCodeDao {
	public boolean  insertStuMatchCode(StuMatchCode stuMatchCode);
	
	public boolean updateStuMatchCode(StuMatchCode stuMatchCode);
	
	public boolean delStuMatchCode(int stuMatchCodeId);
}
