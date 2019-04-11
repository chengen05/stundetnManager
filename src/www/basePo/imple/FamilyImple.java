package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.basePo.dao.FamilyDao;
import www.basePo.po.Family;
import www.conndb.ConnDB;

public class FamilyImple implements FamilyDao {

	@Override
	public boolean insertFamily(Family family) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into family_member(family_name,relationship,birthday,"
				+ "avg_income,stu_id) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,family.getFamilyName());
			pstmt.setString(2, family.getFamilyRelation());
			pstmt.setString(3, family.getFamilyBirthday());
			pstmt.setString(4, family.getAvg_income());
			pstmt.setInt(5, family.getStuId());
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
	public boolean updateFamily(Family family) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update family_member set family_name=?,relationship=?,birthday=?,"
				+ "avg_income=?,stu_id=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,family.getFamilyName());
			pstmt.setString(2, family.getFamilyRelation());
			pstmt.setString(3, family.getFamilyBirthday());
			pstmt.setString(4, family.getAvg_income());
			pstmt.setInt(5, family.getStuId());
			pstmt.setInt(6, family.getFamilyId());
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
	public boolean delFamily(int familyId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from family_member where id = " + familyId;
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
