package www.shetuan.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.shetuan.dao.StuJobDAO;
import www.shetuan.po.StuJob;

public class StuJobImple implements StuJobDAO {

	@Override
	public boolean inserstujob(StuJob stujob) {
		boolean  judge = false;
		String sql ="insert into stu_job(stu_id,job_id,start_time,"
				+ "last_time,status) values(?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,stujob.getStuId());
			pstmt.setInt(2,stujob.getJobId());
			pstmt.setString(3,stujob.getJobStart());
			pstmt.setString(4,stujob.getJobEnd());
			pstmt.setString(5,stujob.getJobStatus());
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
	public boolean updatastujob(StuJob stujob) {
		boolean judge = false;
		String sql = "update stu_job set stu_id =?,job_id=?,"
				+ "start_time =?,last_time=?,status=?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setInt(1,stujob.getStuId());
			pstmt.setInt(2,stujob.getJobId());
			pstmt.setString(3,stujob.getJobStart());
			pstmt.setString(4,stujob.getJobEnd());
			pstmt.setString(5,stujob.getJobStatus());
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
	public boolean delstujob(int stujobid) {
		boolean judge =  false;
		String sql ="delete stu_job where id = " + stujobid;
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
