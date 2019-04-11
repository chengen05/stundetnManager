package www.jingsai.imple;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.jingsai.dao.StuMatchCodeDao;
import www.jingsai.po.StuMatchCode;

public class StuMatchCodeImple implements StuMatchCodeDao{

	@Override
	public boolean insertStuMatchCode(StuMatchCode stuMatchCode) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into stu_match_code(stu_id,match_id,guide_teacher,"
				+ "time,certificate,description) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,stuMatchCode.getStuId());
			pstmt.setInt(2, stuMatchCode.getMatchId());
			pstmt.setString(3, stuMatchCode.getGuideTeacher());
			pstmt.setString(4, stuMatchCode.getMatchDate());
			pstmt.setString(5, stuMatchCode.getMatchDiploma());
			pstmt.setString(6, stuMatchCode.getMatchMemo());
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
	public boolean updateStuMatchCode(StuMatchCode stuMatchCode) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update stu_match_code set  stu_id=?,match_id=?,"
				+ "guide_teacher =?,time=?,certificate=? , description "
				+ "= ? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,stuMatchCode.getStuId());
			pstmt.setInt(2, stuMatchCode.getMatchId());
			pstmt.setString(3, stuMatchCode.getGuideTeacher());
			pstmt.setString(4, stuMatchCode.getMatchDate());
			pstmt.setString(5, stuMatchCode.getMatchDiploma());
			pstmt.setString(6, stuMatchCode.getMatchMemo());
			pstmt.setString(7, stuMatchCode.getMatchMemo());
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
	public boolean delStuMatchCode(int stuMatchCodeId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from stu_match_code where id = " + stuMatchCodeId;
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
