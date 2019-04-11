package www.hobby.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.hobby.dao.StuHobbyCodeDao;
import www.hobby.po.StuHobbyCode;

public class StuHobbyCodeImple implements StuHobbyCodeDao{

	@Override
	public boolean insertStuHobbyCode(StuHobbyCode stuHobbyCode) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into stu_hobby(stu_id,hobby_id) values(?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,stuHobbyCode.getStuId());
			pstmt.setInt(2, stuHobbyCode.getHobbyId());
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
	public boolean updateStuHobbyCode(StuHobbyCode stuHobbyCode) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update stu_hobby set stu_id =?,hobby_id=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,stuHobbyCode.getStuId());
			pstmt.setInt(2, stuHobbyCode.getHobbyId());
			pstmt.setInt(3, stuHobbyCode.getStuHobbyId());
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
	public boolean delStuHobbyCode(int stuHobbyCodeId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from  stu_hobby where id = " + stuHobbyCodeId;
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
