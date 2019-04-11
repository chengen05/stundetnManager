package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.basePo.dao.StudentInfoDao;
import www.basePo.po.StudentInfo;
import www.conndb.ConnDB;

public class StudentInfoImple implements StudentInfoDao{

	@Override
	public boolean insertStudentInfo(StudentInfo studentInfo) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into stu_info(user_stu_id,birthday,study_date,"
				+ "stu_tel,qq_num,email,wechart,nation,id_card,candidate_state,height"
				+ ",wight,person_description,political_status,native_place,home_address"
				+ ",home_difficult,difficult_type,class_id)"
				+ " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,studentInfo.getUserStuId());
			pstmt.setString(2,studentInfo.getStuBirthday());
			pstmt.setString(3, studentInfo.getEntranceDate());
			pstmt.setString(4, studentInfo.getStuPhone());
			pstmt.setString(5,studentInfo.getStuQQ());
			pstmt.setString(6, studentInfo.getStuEmail());
			pstmt.setString(7, studentInfo.getStuWechat());
			pstmt.setString(8, studentInfo.getStuNation());
			pstmt.setString(9, studentInfo.getStuIdCard());
			pstmt.setString(10, studentInfo.getStudyStatus());
			pstmt.setInt(11, studentInfo.getStuHeight());
			pstmt.setInt(12, studentInfo.getStuWeight());
			pstmt.setString(13, studentInfo.getPersonDescription());
			pstmt.setString(14, studentInfo.getPoliticalStatus());
			pstmt.setString(15, studentInfo.getNativePlace());
			pstmt.setString(16, studentInfo.getStuAddress());
			pstmt.setInt(17, studentInfo.getStuDifficult());
			pstmt.setString(18, studentInfo.getStuDifficultType());
			pstmt.setInt(19, studentInfo.getStuClassId());
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
	public boolean updateStudentInfo(StudentInfo studentInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update stu_info set user_stu_id =?,birthday=?,"
				+ "study_date =?,tu_tel =?,qq_num =?,email=?,wechart=?,nation=?,id_card=?,candidate_state=?,height=?"
				+ ",wight=?,person_description=?,political_status=?,native_place=?,home_address=?,"
				+ "home_difficult=?,difficult_type=?,class_id=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,studentInfo.getUserStuId());
			pstmt.setString(2,studentInfo.getStuBirthday());
			pstmt.setString(3, studentInfo.getEntranceDate());
			pstmt.setString(4, studentInfo.getStuPhone());
			pstmt.setString(5,studentInfo.getStuQQ());
			pstmt.setString(6, studentInfo.getStuEmail());
			pstmt.setString(7, studentInfo.getStuWechat());
			pstmt.setString(8, studentInfo.getStuNation());
			pstmt.setString(9, studentInfo.getStuIdCard());
			pstmt.setString(10, studentInfo.getStudyStatus());
			pstmt.setInt(11, studentInfo.getStuHeight());
			pstmt.setInt(12, studentInfo.getStuWeight());
			pstmt.setString(13, studentInfo.getPersonDescription());
			pstmt.setString(14, studentInfo.getPoliticalStatus());
			pstmt.setString(15, studentInfo.getNativePlace());
			pstmt.setString(16, studentInfo.getStuAddress());
			pstmt.setInt(17, studentInfo.getStuDifficult());
			pstmt.setString(18, studentInfo.getStuDifficultType());
			pstmt.setInt(19, studentInfo.getStuClassId());
			pstmt.setInt(20, studentInfo.getStudentInfoid());
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
	public boolean delStudentInfo(int studentInfoId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from stu_info where id = " + studentInfoId;
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
