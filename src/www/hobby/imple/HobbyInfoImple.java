package www.hobby.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.hobby.dao.HobbyInfoDao;
import www.hobby.po.HobbyInfo;

public class HobbyInfoImple implements HobbyInfoDao{

	@Override
	public boolean insertHobbyInfo(HobbyInfo hobbyInfo) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into hobby(name,rankId,description)"
				+ "values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hobbyInfo.getHobbyName());
			pstmt.setInt(2, hobbyInfo.getRankId());
			pstmt.setString(3, hobbyInfo.getDescription());
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
	public boolean updateHobbyInfo(HobbyInfo hobbyInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update hobby set name =?,rankId=?,"
				+ "description =? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hobbyInfo.getHobbyName());
			pstmt.setInt(2, hobbyInfo.getRankId());
			pstmt.setString(3, hobbyInfo.getDescription());
			pstmt.setInt(4, hobbyInfo.getHobbyId());
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
	public boolean delHobbyInfo(int hobbyInfoId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from hobby where id = " + hobbyInfoId;
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

}
