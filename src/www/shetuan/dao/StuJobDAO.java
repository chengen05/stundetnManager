package www.shetuan.dao;

import www.shetuan.po.StuJob;

public interface StuJobDAO {
	public boolean inserstujob(StuJob stujob);
	
	public boolean updatastujob(StuJob stujob);

	public boolean delstujob(int stujobid);


}
