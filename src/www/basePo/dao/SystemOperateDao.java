package www.basePo.dao;


import java.util.List;

import www.basePo.po.SystemOperate;
import www.basePo.po.UserRoleNode;

public interface SystemOperateDao {
	public boolean  insertSystemOperate(SystemOperate systemOperate);
	
	public boolean updateSystemOperate(SystemOperate systemOperate);
	
	public boolean delSystemOperate(int systemOperateDaoId);
	
	public SystemOperate selectSysOp(int systemOperateDaoId);

	public List<SystemOperate> selectSysByParentNode(int systemParentNode);
	
	public List<SystemOperate> selectAll();
	
	public List<UserRoleNode> selectNodeAll();
}
