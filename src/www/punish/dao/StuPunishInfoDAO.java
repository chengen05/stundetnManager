package www.punish.dao;

import www.punish.po.StuPunishInfo;

public interface StuPunishInfoDAO {
	public boolean inserStuPunish(StuPunishInfo StuPunish);
	
	public boolean updataStuPunish(StuPunishInfo StuPunish);

	public boolean delStuPunish(int StuPunishid);


}
