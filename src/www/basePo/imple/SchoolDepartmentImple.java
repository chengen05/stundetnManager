package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.SchoolDepartmentDao;
import www.basePo.po.SchoolDepartment;
import www.conndb.ConnDB;

public class SchoolDepartmentImple implements SchoolDepartmentDao{

	@Override
	public boolean insertSchoolDepart(SchoolDepartment schoolDepart) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into school_department(depart_name,depart_type,depart_sort,depart_linkman"
				+ ",work_address,linkman_tel) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,schoolDepart.getDepartmentName());
			pstmt.setInt(2, schoolDepart.getDepartmentType());
			pstmt.setInt(3, schoolDepart.getDepartmentSort());
			pstmt.setString(4, schoolDepart.getDepartmentLinkman());
			pstmt.setString(5, schoolDepart.getOfficeAddress());
			pstmt.setString(6, schoolDepart.getPhoneNumber());
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


	public boolean updateSchoolDepart(SchoolDepartment schoolDepart) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update school_department set  depart_type=?,"
				+ "depart_linkman=?,work_address=?,linkman_tel=? where id =?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, schoolDepart.getDepartmentType());
		
			pstmt.setString(2, schoolDepart.getDepartmentLinkman());
			pstmt.setString(3, schoolDepart.getOfficeAddress());
			pstmt.setString(4, schoolDepart.getPhoneNumber());
			pstmt.setInt(5, schoolDepart.getSchoolDepartId());
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
	public boolean delSchoolDepart(int schoolDepartId) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from school_department where id = " + schoolDepartId;
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


	@Override
	public List<SchoolDepartment> selectAll() {
		List<SchoolDepartment> listAll = new ArrayList<SchoolDepartment>();
		Connection conn = ConnDB.getConnection();
		String sql = "select * from school_department";
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				SchoolDepartment schoolDepartment = new SchoolDepartment();
				schoolDepartment.setSchoolDepartId(rs.getInt(1));
				schoolDepartment.setDepartmentName(rs.getString(2));
				schoolDepartment.setDepartmentType(rs.getInt(3));
				schoolDepartment.setDepartmentSort(rs.getInt(4));
				schoolDepartment.setDepartmentLinkman(rs.getString(5));
				schoolDepartment.setOfficeAddress(rs.getString(6));
				schoolDepartment.setPhoneNumber(rs.getString(7));
				listAll.add(schoolDepartment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAll;
	}
	//分页查询数据 pageSize:每页数量 offset:当前页
	public List<SchoolDepartment> selectfind(int pageSize,int offset) {
		List<SchoolDepartment> listAll = new ArrayList<SchoolDepartment>();
		Connection conn = ConnDB.getConnection();
		String sql = "select * from school_department limit ?,?";
		try {
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setInt(1,offset);
			pstmt.setInt(2, pageSize);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				SchoolDepartment schoolDepartment = new SchoolDepartment();
				schoolDepartment.setSchoolDepartId(rs.getInt(1));
				schoolDepartment.setDepartmentName(rs.getString(2));
				schoolDepartment.setDepartmentType(rs.getInt(3));
				schoolDepartment.setDepartmentSort(rs.getInt(4));
				schoolDepartment.setDepartmentLinkman(rs.getString(5));
				schoolDepartment.setOfficeAddress(rs.getString(6));
				schoolDepartment.setPhoneNumber(rs.getString(7));
				listAll.add(schoolDepartment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listAll;
	}
}
