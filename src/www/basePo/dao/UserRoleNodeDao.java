package www.basePo.dao;

import java.util.List;

import www.basePo.po.UserRoleNode;

public interface UserRoleNodeDao {
	public List<UserRoleNode> selectAll();
	public UserRoleNode selectById(int id);
}
