package www.partyProcess.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.partyProcess.dao.StuPartyProcessDAO;
import www.partyProcess.po.StuPartyProcessCode;

public class StuPartyProcessImple implements StuPartyProcessDAO {

	@Override
	public boolean inserStuPtyProce(StuPartyProcessCode StuPtyProce) {
		boolean  judge = false;
		String sql ="insert into stu_party_process(party_id,stu_id,time,"
				+ "document_name,teacher,description) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = (PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1, StuPtyProce.getStuPartyId());
			pstmt.setInt(2, StuPtyProce.getPartyProcessInfoId());
			pstmt.setInt(3,StuPtyProce.getStuId());
			pstmt.setString(4,StuPtyProce.getTime());
			pstmt.setString(5,StuPtyProce.getTeacher());
			pstmt.setString(6,StuPtyProce.getDescripiton());
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
	public boolean updataStuPtyProce(StuPartyProcessCode StuPtyProce) {
		boolean judge = false;
		String sql = "update stu_party_process set party_id =?,stu_id=?,"
				+ "time =?,document_name=?,teacher=?,description=?";
		try {
			PreparedStatement pstmt = (PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1, StuPtyProce.getStuPartyId());
			pstmt.setInt(2, StuPtyProce.getPartyProcessInfoId());
			pstmt.setInt(3,StuPtyProce.getStuId());
			pstmt.setString(4,StuPtyProce.getTime());
			pstmt.setString(5,StuPtyProce.getTeacher());
			pstmt.setString(6,StuPtyProce.getDescripiton());
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
	public boolean delStuPtyProce(int stuPartyid) {
		boolean judge =  false;
		String sql ="delete stu_party_process where id = " + stuPartyid;
		PreparedStatement pstmt;
		try {
			pstmt =(PreparedStatement) ConnDB.conn.prepareStatement(sql);
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
