package www.basePo.dao;

import java.util.List;

import www.basePo.po.UserRole;

public interface UserRoleDao {
	public boolean  insertUserRole(UserRole userRole);
	
	public boolean updateUserRole(UserRole userRole);
	
	public boolean delUserRole(int userRoleId);
	
	public UserRole selectUserRole(int userRoleId);
	
	public List<UserRole> selectAll();
}
