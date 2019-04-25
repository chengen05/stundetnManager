package www.zhuxuejin.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.zhuxuejin.dao.StuGrantDAO;
import www.zhuxuejin.po.StuGrant;

public class StuGrantImple implements StuGrantDAO {

	@Override
	public boolean inserstugrant(StuGrant stugrant) {
		boolean  judge = false;
		String sql ="insert into user_info(login_name,login_password,user_name,"
				+ "user_sex,photo,role_id) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,stugrant.getGrantName());
			pstmt.setInt(2, stugrant.getGranMoney());
			pstmt.setString(3, stugrant.getGrantDate());
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
	public boolean updatastugrant(StuGrant stugrant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delstugrant(int stugrantid) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
