package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.basePo.dao.MajorInfoDao;
import www.basePo.po.MajorInfo;
import www.conndb.ConnDB;

public class MajorInfoImple	implements MajorInfoDao {

	
	public boolean insertMajorInfo(MajorInfo majorInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into major_info(major_name,major_coding,training_level,"
				+ "school_system,pedagogical,leader_name,leader_description,training_target,"
				+ "total_points,establish_date"
				+ ",school_depart_id) values(?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,majorInfo.getMajorName());
			pstmt.setString(2, majorInfo.getMajorCode());
			pstmt.setString(3, majorInfo.getTrainLevel());
			pstmt.setInt(4, majorInfo.getEduSystem());
			pstmt.setInt(5, majorInfo.getTeacherMajor());
			pstmt.setString(6, majorInfo.getLeaderName());
			pstmt.setString(7, majorInfo.getLeaderDescription());
			pstmt.setString(8, majorInfo.getTrainTarget());
			pstmt.setInt(9, majorInfo.getTotalPoints());
			pstmt.setString(10,majorInfo.getEstablishDate());
			pstmt.setInt(11, majorInfo.getSchoolDepartId());
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

	
	public boolean updateMajorInfo(MajorInfo majorInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update major_info set major_name=?,major_coding=?,"
				+ "training_level =?,school_system=?,pedagogical=?,leader_name"
				+ ",leader_description=?,training_target=?,total_points=?,establish_date=?"
				+ "school_depart_id=? where id =?";
		try {
			PreparedStatement pstmt =conn.prepareStatement(sql);
			pstmt.setString(1,majorInfo.getMajorName());
			pstmt.setString(2, majorInfo.getMajorCode());
			pstmt.setString(3, majorInfo.getTrainLevel());
			pstmt.setInt(4, majorInfo.getEduSystem());
			pstmt.setInt(5, majorInfo.getTeacherMajor());
			pstmt.setString(6, majorInfo.getLeaderName());
			pstmt.setString(7, majorInfo.getLeaderDescription());
			pstmt.setString(8, majorInfo.getTrainTarget());
			pstmt.setInt(9, majorInfo.getTotalPoints());
			pstmt.setString(10,majorInfo.getEstablishDate());
			pstmt.setInt(11, majorInfo.getSchoolDepartId());
			pstmt.setInt(12, majorInfo.getMajorInfoId());
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

	
	public boolean delMajorInfo(int majorInfoId) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from major_info where id = " + majorInfoId;
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
