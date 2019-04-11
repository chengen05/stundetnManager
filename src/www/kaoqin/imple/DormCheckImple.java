package www.kaoqin.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.kaoqin.dao.DormCheckDao;
import www.kaoqin.po.DormCheck;

public class DormCheckImple implements DormCheckDao{

	@Override
	public boolean insertDormCheck(DormCheck dormCheck) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into dormitory_inspect_option(inspect_name,inspect_type,inspect_sort,"
				+ ") values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dormCheck.getCheckName());
			pstmt.setString(2, dormCheck.getCheckType());
			pstmt.setInt(3, dormCheck.getCheckSort());
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
	public boolean updateDormCheck(DormCheck dormCheck) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update dormitory_inspect_option set inspect_name =?,inspect_type=?,"
				+ "inspect_sort =? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dormCheck.getCheckName());
			pstmt.setString(2, dormCheck.getCheckType());
			pstmt.setInt(3, dormCheck.getCheckSort());
			pstmt.setInt(4, dormCheck.getDormcheckId());

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
	public boolean delDormCheck(int dormCheckId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from dormitory_inspect_option where id = " + dormCheckId;
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
