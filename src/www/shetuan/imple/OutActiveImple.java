package www.shetuan.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.shetuan.dao.OutActiveDAO;
import www.shetuan.po.OutActive;

public class OutActiveImple implements OutActiveDAO {

	@Override
	public boolean inserOutaCtive(OutActive outactive) {
		boolean  judge = false;
		String sql ="insert into outclass_activity(activity_name,sponsor,description) values(?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,outactive.getActiveName());
			pstmt.setString(2, outactive.getActiveOrg());
			pstmt.setString(3, outactive.getOutactMemo());
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
	public boolean updataOutaCtive(OutActive outactive) {
		boolean judge = false;
		String sql = "update outclass_activity set activity_name =?,sponsor=?,"
				+ "description =?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,outactive.getActiveName());
			pstmt.setString(2, outactive.getActiveOrg());
			pstmt.setString(3, outactive.getOutactMemo());
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
	public boolean delOutaCtive(int outactiveid) {
		boolean judge =  false;
		String sql ="delete outclass_activity where id = " + outactiveid;
		PreparedStatement pstmt;
		try {
			pstmt = (PreparedStatement)ConnDB.conn.prepareStatement(sql);
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
