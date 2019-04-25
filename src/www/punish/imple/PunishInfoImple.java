package www.punish.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.punish.dao.PunishInfoDAO;
import www.punish.po.PunishInfo;

public class PunishInfoImple implements PunishInfoDAO{

	@Override
	public boolean inserPunishCode(PunishInfo Punish) {
		boolean  judge = false;
		String sql ="insert into punish_info(punish_name,punish_type,description) values(?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,Punish.getPunishName());
			pstmt.setString(2, Punish.getPunishType());
			pstmt.setString(3, Punish.getPunishMemo());
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
	public boolean updataPunishCode(PunishInfo Punish) {
		boolean judge = false;
		String sql = "update punish_info set punish_name =?,punish_type=?,description =?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,Punish.getPunishName());
			pstmt.setString(2, Punish.getPunishType());
			pstmt.setString(3, Punish.getPunishMemo());
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
	public boolean delPunishCode(int Punishid) {
		boolean judge =  false;
		String sql ="delete punish_info where id = " + Punishid;
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
