package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.basePo.dao.ClassInfoDao;
import www.basePo.po.ClassInfo;
import www.conndb.ConnDB;

public class ClassInfoImple implements ClassInfoDao{

	@Override
	public boolean insertClassInfo(ClassInfo classInfo) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into class_info(class_name,class_number,head_teacher_id,"
				+ "major_id) values(?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,classInfo.getClassName());
			pstmt.setString(2, classInfo.getMeetRoom());
			pstmt.setInt(3, classInfo.getHeadMasterId());
			pstmt.setInt(4, classInfo.getMajorId());
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
	public boolean updateClassInfo(ClassInfo classInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update class_info set class_name =?,class_number=?,"
				+ "head_teacher_id =?,major_id=? id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,classInfo.getClassName());
			pstmt.setString(2, classInfo.getMeetRoom());
			pstmt.setInt(3, classInfo.getHeadMasterId());
			pstmt.setInt(4, classInfo.getMajorId());
			pstmt.setInt(5, classInfo.getClassInfoId());
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
	public boolean delClassInfo(int classInfoId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from class_info where id = " + classInfoId;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
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
