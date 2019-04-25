package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.UserRoleNodeDao;
import www.basePo.po.UserRoleNode;
import www.conndb.ConnDB;

public class UserRoleNodeImple implements UserRoleNodeDao{

	@Override
	public List<UserRoleNode> selectAll() {
		List<UserRoleNode> listcode = new ArrayList<UserRoleNode>();
		Connection conn = ConnDB.getConnection();
		String sql ="select * from role_info";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				UserRoleNode userRole = new UserRoleNode();
				userRole.setId(rs.getInt(1));
				userRole.setName(rs.getString(2));
				listcode.add(userRole);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listcode;
	
	}
	public UserRoleNode selectById(int id)
	{
		UserRoleNode userRole = new UserRoleNode();
		Connection conn = ConnDB.getConnection();
		String sql ="select * from role_info where id =?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				userRole.setId(rs.getInt(1));
				userRole.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userRole;
	}
}
