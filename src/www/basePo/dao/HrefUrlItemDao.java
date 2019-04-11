package www.basePo.dao;

import java.util.List;

import www.basePo.po.SystemOperate;

public interface HrefUrlItemDao {
	public List<SystemOperate> selectHrefList(int parentnode,int roleId);
}
