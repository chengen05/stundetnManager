package www.technology.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.technology.dao.TechnologyInfoDAO;
import www.technology.po.TechnologyInfo;

public class TechnologyInfoImple implements TechnologyInfoDAO  {

	@Override
	public boolean insertechnology(TechnologyInfo technology) {
		boolean  judge = false;
		String sql ="insert into technology_research_type(type,grade,desription) values(?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,technology.getTechnologyType());
			pstmt.setString(2, technology.getGrade());
			pstmt.setString(3, technology.getDescription());
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
	public boolean updatatechnology(TechnologyInfo technology) {
		boolean judge = false;
		String sql = "update technology_research_type set type =?,grade=?,"
				+ "desription =?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,technology.getTechnologyType());
			pstmt.setString(2, technology.getGrade());
			pstmt.setString(3, technology.getDescription());
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
	public boolean deltechnology(int technologyid) {
		boolean judge =  false;
		String sql ="delete user_info where id = " + technologyid;
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
