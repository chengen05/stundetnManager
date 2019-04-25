package www.technology.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.technology.dao.StuTechnologyDAO;
import www.technology.po.StuTechnologyCode;

public class StuTechnologyImple implements StuTechnologyDAO {

	@Override
	public boolean inserstutechnology(StuTechnologyCode stutechnology) {
		boolean  judge = false;
		String sql ="insert into stu_technology_type(stu_id,techology_id,guide_teacher,"
				+ "time,desciption) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,stutechnology.getStuId());
			pstmt.setInt(2, stutechnology.getTechnologyInfoId());
			pstmt.setString(3, stutechnology.getGuideTeacher());
			pstmt.setString(4, stutechnology.getTime());
			pstmt.setString(5, stutechnology.getDescription());
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
	public boolean updatastutechnology(StuTechnologyCode stutechnology) {
		boolean judge = false;
		String sql = "update stu_technology_type set stu_id =?,techology_id=?,"
				+ "guide_teacher =?,time=?,desciption=?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,stutechnology.getStuId());
			pstmt.setInt(2, stutechnology.getTechnologyInfoId());
			pstmt.setString(3, stutechnology.getGuideTeacher());
			pstmt.setString(4, stutechnology.getTime());
			pstmt.setString(5, stutechnology.getDescription());
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
	public boolean delstutechnology(int stutechnologyid) {
		boolean judge =  false;
		String sql ="delete stu_technology_type where id = " + stutechnologyid;
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
