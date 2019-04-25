package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.UserInfoDao;
import www.basePo.po.UserInfo;
import www.conndb.ConnDB;

public class UserInfoImple implements UserInfoDao {

	/**
	 * 对用户信息表的数据插入，修改，用对象封装的方式，传入值
	 */
	public boolean insertUserCode(UserInfo userInfo) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into user_info(login_name,login_password,user_name,"
				+ "user_sex,photo,role_id) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,userInfo.getAccount());
			pstmt.setString(2, userInfo.getPassword());
			pstmt.setString(3, userInfo.getName());
			pstmt.setString(4, userInfo.getGender());
			pstmt.setString(5, userInfo.getPhoto());
			pstmt.setInt(6, userInfo.getUserRoleId());
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

	public boolean updateUserCode(UserInfo userInfo) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update user_info set login_password =?,user_name=?,"
				+ "user_sex =?,photo=?,role_id=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userInfo.getPassword());
			pstmt.setString(2, userInfo.getName());
			pstmt.setString(3, userInfo.getGender());
			pstmt.setString(4, userInfo.getPhoto());
			pstmt.setInt(5, userInfo.getUserRoleId());
			pstmt.setInt(6, userInfo.getUserId());
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

	
	public boolean delUserCode(int userId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from user_info where id = " + userId;
		PreparedStatement pstmt;
		try {
			pstmt =  conn.prepareStatement(sql);
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
	public UserInfo selectUser(UserInfo userInfo) {
		Connection conn = ConnDB.getConnection();
		UserInfo userinfo = new UserInfo();
		String sql ="select * from user_info where login_name=? and login_password=?";
		PreparedStatement pstmt;
		try {
			pstmt =  conn.prepareStatement(sql);
			pstmt.setString(1,userInfo.getAccount());
			pstmt.setString(2, userInfo.getPassword());
			ResultSet rs =	pstmt.executeQuery();
			if(rs.next())
			{
				userinfo.setUserId(rs.getInt(1));
				userinfo.setAccount(rs.getString(2));
				userinfo.setPassword(rs.getString(3));
				userinfo.setName(rs.getString(4));
				userinfo.setGender(rs.getString(5));
				userinfo.setPhoto(rs.getString(6));
				userinfo.setUserRoleId(rs.getInt(7));
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userinfo;
	}

	@Override
	public List<UserInfo> selectAll() {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		Connection conn = ConnDB.getConnection();
		String sql ="select * from user_info";
		PreparedStatement pstmt;
		try {
			pstmt =  conn.prepareStatement(sql);
			ResultSet rs =	pstmt.executeQuery();
			while(rs.next())
			{
				UserInfo userinfo = new UserInfo();
				userinfo.setUserId(rs.getInt(1));
				userinfo.setAccount(rs.getString(2));
				userinfo.setPassword(rs.getString(3));
				userinfo.setName(rs.getString(4));
				userinfo.setGender(rs.getString(5));
				userinfo.setPhoto(rs.getString(6));
				userinfo.setUserRoleId(rs.getInt(7));
				
				userList.add(userinfo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userList;
	}
	/**
	 * 用于excel导入数据时，因为是数组所以这里有个遍历数组插入数据
	 */
	public void insertUserInfo(ArrayList<ArrayList<String>> arrayInsert)
	{
		Connection conn = ConnDB.getConnection();
		String sql ="insert into user_info(login_name,login_password,user_name,"
				+ "user_sex,role_id) values(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			conn.setAutoCommit(false);//设置自动提交为false
			for(int x = 0;x < arrayInsert.size();x++ ) {
				ArrayList<String> rowCode = arrayInsert.get(x);
				pstmt.setString(1,rowCode.get(0));
				pstmt.setString(2, rowCode.get(1));
				pstmt.setString(3, rowCode.get(2));
				pstmt.setString(4, rowCode.get(3));
				pstmt.setInt(5, Integer.parseInt(rowCode.get(4)));
				pstmt.addBatch();
				}
			try {
				pstmt.executeBatch();
			}catch (Exception e)
			{
				conn.rollback();
			}
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

	@Override
	public List<UserInfo> selectPageCode(int pageSize, int rowoffset) {
		List<UserInfo> userList = new ArrayList<UserInfo>();
		Connection conn = ConnDB.getConnection();
		String sql ="select * from user_info limit ?,?";
		PreparedStatement pstmt;
		try {
			pstmt =  conn.prepareStatement(sql);
			pstmt.setInt(1,rowoffset);
			pstmt.setInt(2, pageSize);
			ResultSet rs =	pstmt.executeQuery();
			while(rs.next())
			{
				UserInfo userinfo = new UserInfo();
				userinfo.setUserId(rs.getInt(1));
				userinfo.setAccount(rs.getString(2));
				userinfo.setPassword(rs.getString(3));
				userinfo.setName(rs.getString(4));
				userinfo.setGender(rs.getString(5));
				userinfo.setPhoto(rs.getString(6));
				userinfo.setUserRoleId(rs.getInt(7));
				
				userList.add(userinfo);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return userList;
	}
}
