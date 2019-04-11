package www.basePo.dao;

import java.util.List;

import www.basePo.po.RolePower;

public interface RolePowerDao {
	public boolean  insertRolePower(RolePower rolePower);
	
	public boolean updateRolePower(RolePower rolePower);
	
	public boolean delRolePower(int rolePowerId);
	
	public List<RolePower> selectList(int roleId);
	
	
}
