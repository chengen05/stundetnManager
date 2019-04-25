package www.shetuan.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.shetuan.dao.StuOutClassDAO;
import www.shetuan.po.StuOutClass;

public class StuOutClassImple implements StuOutClassDAO {

	@Override
	public boolean inseroutclass(StuOutClass outclass) {
		boolean  judge = false;
		String sql ="insert into stu_outclass_code(activity_id,stu_id,take_part_date,"
				+ "auditing_status) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1, outclass.getStuOutClassId());
	//		pstmt.setInt(2, outclass.getStuId());
			pstmt.setString(3, outclass.getTakePartDate());
			pstmt.setString(4, outclass.getAuditingStats());
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
	public boolean updataoutclass(StuOutClass outclass) {
		boolean judge = false;
		String sql = "update stu_outclass_code set activity_id =?,stu_id=?,"
				+ "take_part_date =?,auditing_status=?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
	//		pstmt.setInt(1, outclass.getActivityId());
	//		pstmt.setInt(2, outclass.getStuId());
			pstmt.setString(3, outclass.getTakePartDate());
			pstmt.setString(4, outclass.getAuditingStats());
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
	public boolean deloutclass(int outclassid) {
		boolean judge =  false;
		String sql ="delete stu_outclass_code where id = " + outclassid;
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
