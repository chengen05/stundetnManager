package www.zhuxuejin.dao;

import www.zhuxuejin.po.StuGrant;

public interface StuGrantDAO {
	public boolean inserstugrant(StuGrant stugrant);
	
	public boolean updatastugrant(StuGrant stugrant);

	public boolean delstugrant(int stugrantid);

}
