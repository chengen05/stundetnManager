package www.shetuan.imple;

import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import www.conndb.ConnDB;
import www.shetuan.dao.InstituteJobDAO;
import www.shetuan.po.InstituteJob;

public class InstituteJobImple implements InstituteJobDAO {

	@Override
	public boolean inserInstitJob(InstituteJob InstitJob) {
		boolean  judge = false;
		String sql ="insert into institute_job_info(job_name,sort_value,depart) values(?,?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,InstitJob.getJobName());
			pstmt.setInt(2,InstitJob.getSortValue());
			pstmt.setInt(3,InstitJob.getDepart());
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
	public boolean updataInstitJob(InstituteJob InstitJob) {
		boolean judge = false;
		String sql = "update institute_job_info set job_name =?,sort_value=?,"
				+ "depart =?";
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1,InstitJob.getJobName());
			pstmt.setInt(2,InstitJob.getSortValue());
			pstmt.setInt(3,InstitJob.getDepart());
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
	public boolean delInstitJob(int InstitJobid) {
		boolean judge =  false;
		String sql ="delete institute_job_info where id = " + InstitJobid;
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
