package www.punish.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.punish.dao.StuPunishInfoDAO;
import www.punish.po.StuPunishInfo;

public class StuPunishInfoImple implements StuPunishInfoDAO{

	@Override
	public boolean inserStuPunish(StuPunishInfo StuPunish) {
		boolean  judge = false;
		String sql ="insert into stu_punish_code(punish_id,stu_id,time,"
				+ "cancel_time,description) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,StuPunish.getPunishInfoId());
			pstmt.setInt(2,StuPunish.getStuId());
			pstmt.setString(3,StuPunish.getPunishDate());
			pstmt.setString(4, StuPunish.getCancelTime());
			pstmt.setString(5, StuPunish.getDescription());
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
	public boolean updataStuPunish(StuPunishInfo StuPunish) {
		boolean judge = false;
		String sql = "update stu_punish_code set punish_id =?,stu_id=?,"
				+ "time =?,cancel_time=?,description=?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,StuPunish.getPunishInfoId());
			pstmt.setInt(2,StuPunish.getStuId());
			pstmt.setString(3,StuPunish.getPunishDate());
			pstmt.setString(4, StuPunish.getCancelTime());
			pstmt.setString(5, StuPunish.getDescription());
			int value =pstmt.executeUpdate();
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
	public boolean delStuPunish(int StuPunishid) {
		boolean judge =  false;
		String sql ="delete stu_punish_code where id = " + StuPunishid;
		PreparedStatement pstmt;
		try {
			pstmt =(PreparedStatement) ConnDB.conn.prepareStatement(sql);
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
