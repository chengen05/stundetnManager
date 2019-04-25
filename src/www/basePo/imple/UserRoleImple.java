package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.UserRoleDao;
import www.basePo.po.UserRole;
import www.conndb.ConnDB;

public class UserRoleImple implements UserRoleDao{

	@Override
	public boolean insertUserRole(UserRole userRole) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into role_info(role_name,role_range,description)"
				+ " values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userRole.getRoleName());
			pstmt.setInt(2, userRole.getStuRang());
			pstmt.setString(3, userRole.getRoleExplain());
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
	public boolean updateUserRole(UserRole userRole) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update role_info set role_name=?,role_range=?"
				+ ",description=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userRole.getRoleName());
			pstmt.setInt(2, userRole.getStuRang());
			pstmt.setString(3, userRole.getRoleExplain());
			pstmt.setInt(4, userRole.getUseRoleId());
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
	public boolean delUserRole(int userRoleId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from role_info where id = " + userRoleId;
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
	public UserRole selectUserRole(int userRoleId) {
		UserRole user = new UserRole();
		Connection conn = ConnDB.getConnection();
		String sql = "select * from role_info where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userRoleId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				user.setUseRoleId(userRoleId);
				user.setRoleName(rs.getString(2));
				user.setStuRang(rs.getInt(3));
				user.setRoleExplain(rs.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List<UserRole> selectAll() {
		List<UserRole> userlist= new ArrayList<UserRole>();
		Connection conn = ConnDB.getConnection();
		String sql = "select * from role_info ";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				UserRole user = new UserRole();
				user.setUseRoleId(rs.getInt(1));
				user.setRoleName(rs.getString(2));
				user.setStuRang(rs.getInt(3));
				user.setRoleExplain(rs.getString(4));
				userlist.add(user);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return userlist;
	}


}
