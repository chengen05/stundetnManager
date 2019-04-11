package www.kaoqin.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.kaoqin.dao.DormInfoDao;
import www.kaoqin.po.DormInfo;

public class DormInfoImple implements DormInfoDao{

	@Override
	public boolean insertDormInfo(DormInfo dormInfo) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into dormitory_info(dormitory_name,room_num)"
				+ " values(?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dormInfo.getBuildName());
			pstmt.setString(2, dormInfo.getRootNum());
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
	public boolean updateDormInfo(DormInfo dormInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update dormitory_info set dormitory_name =?,room_num=?,"
				+ " where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dormInfo.getBuildName());
			pstmt.setString(2, dormInfo.getRootNum());
			pstmt.setInt(3, dormInfo.getDormId());
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
	public boolean delDormInfo(int dormInfoId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from dormitory_info where id = " + dormInfoId;
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
