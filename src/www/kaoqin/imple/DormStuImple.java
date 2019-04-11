package www.kaoqin.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.kaoqin.dao.DormStuDao;
import www.kaoqin.po.DormStu;

public class DormStuImple implements DormStuDao{

	@Override
	public boolean insertDormStu(DormStu dormStu) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into stu_dormitory(stu_id,dormitory_id,status,"
				+ "update_time) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dormStu.getStuId().getUserStuId());
			pstmt.setInt(2, dormStu.getDormId().getDormId());
			pstmt.setInt(3,dormStu.getDormState());
			pstmt.setString(4, dormStu.getAdjustDate());
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
	public boolean updateDormStu(DormStu dormStu) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update stu_dormitory set stu_id =?,dormitory_id=?,"
				+ "status =?,update_time=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dormStu.getStuId().getUserStuId());
			pstmt.setInt(2, dormStu.getDormId().getDormId());
			pstmt.setInt(3,dormStu.getDormState());
			pstmt.setString(4, dormStu.getAdjustDate());
			pstmt.setInt(5, dormStu.getDormStuId());
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
	public boolean delDormStu(int dormStuId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from stu_dormitory where id = " + dormStuId;
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
