package www.jingsai.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.jingsai.dao.StuMatchDao;
import www.jingsai.po.StuMatch;

public class StuMatchImple implements StuMatchDao{

	@Override
	public boolean insertStuMatch(StuMatch stuMatch) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into match_info(match_name,grade,description)"
				+ " values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,stuMatch.getMatchName());
			pstmt.setString(2,stuMatch.getMatchGrade());
			pstmt.setString(3,stuMatch.getMatchMemo());
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
	public boolean updatestuMatch(StuMatch stuMatch) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update match_info set match_name =?,grade=?,"
				+ "description =? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stuMatch.getMatchName());
			pstmt.setString(2, stuMatch.getMatchGrade());
			pstmt.setString(3, stuMatch.getMatchMemo());
			pstmt.setInt(4, stuMatch.getStumatchId());
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
	public boolean delStuMatch(int stuMatchId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from match_info where id = " + stuMatchId;
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
