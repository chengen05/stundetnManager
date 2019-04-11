package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.RolePowerDao;
import www.basePo.dao.UserRoleDao;
import www.basePo.po.RolePower;
import www.conndb.ConnDB;

public class RolePowerImple implements RolePowerDao{

	@Override
	public boolean insertRolePower(RolePower rolePower) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into role_root_code(role_id,href_url_id)"
				+ " values(?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,rolePower.getRoleInfoId().getUseRoleId());
			pstmt.setInt(2, rolePower.getHrefUrlId());
			int value =pstmt.executeUpdate();
			if(value >0)
			{
				judge = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return judge;
	}

	@Override
	public boolean updateRolePower(RolePower rolePower) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update role_root_code set role_id =?,href_url_id=?"
				+ " where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,rolePower.getRoleInfoId().getUseRoleId());
			pstmt.setInt(2, rolePower.getHrefUrlId());
			pstmt.setInt(3, rolePower.getRolePowerId());
			
			int value = pstmt.executeUpdate();
			if(value > 0)
			{
				judge = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return judge;
	}

	@Override
	public boolean delRolePower(int rolePowerId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from role_root_code where id = " + rolePowerId;
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(sql);
			int value =	pstmt.executeUpdate();
			if(value > 0)
			{
				judge =true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		return judge;
	}

	@Override
	public List<RolePower> selectList(int roleId) {
		List<RolePower> roleList = new ArrayList<RolePower>();
		Connection conn = ConnDB.getConnection();
		String sql = "select * from role_root_code where role_id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, roleId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				RolePower role = new RolePower();
				UserRoleDao userRole = new UserRoleImple();
				role.setRolePowerId(rs.getInt(1));
				role.setRoleInfoId(userRole.selectUserRole(rs.getInt(2)));
				role.setHrefUrlId(rs.getInt(3));
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return roleList;
	}


}
