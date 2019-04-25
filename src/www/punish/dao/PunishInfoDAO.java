package www.punish.dao;

import www.punish.po.PunishInfo;

public interface PunishInfoDAO {
	public boolean inserPunishCode(PunishInfo Punish);
	
	public boolean updataPunishCode(PunishInfo Punish);
	
	public boolean delPunishCode(int Punishid);
	

}
