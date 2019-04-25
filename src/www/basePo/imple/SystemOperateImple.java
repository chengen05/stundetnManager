package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.SystemOperateDao;
import www.basePo.po.SystemOperate;
import www.basePo.po.UserRoleNode;
import www.conndb.ConnDB;

public class SystemOperateImple implements SystemOperateDao {

	@Override
	public boolean insertSystemOperate(SystemOperate systemOperate) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into href_url_info(href_name,href_value,menu,"
				+ "icon,sort,parent_node) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,systemOperate.getName());
			pstmt.setString(2, systemOperate.getLinkUrl());
			pstmt.setInt(3, systemOperate.getMenu());
			pstmt.setString(4,	systemOperate.getIcon());
			pstmt.setInt(5, systemOperate.getSystemSort());
			pstmt.setInt(6, systemOperate.getParentNode());
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
	public boolean updateSystemOperate(SystemOperate systemOperate) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update href_url_info set href_name=?,href_value=?,menu=?,"
				+ "icon=?,sort=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,systemOperate.getName());
			pstmt.setString(2, systemOperate.getLinkUrl());
			pstmt.setInt(3, systemOperate.getMenu());
			pstmt.setString(4,	systemOperate.getIcon());
			pstmt.setInt(5, systemOperate.getSystemSort());
			pstmt.setInt(6, systemOperate.getParentNode());
			pstmt.setInt(7, systemOperate.getSystemId());
	
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
	public boolean delSystemOperate(int systemOperateDaoId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from href_url_info where id = " + systemOperateDaoId;
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
	public SystemOperate selectSysOp(int systemOperateId) {
		SystemOperate sysOp = new SystemOperate();
		String sql = "select * from href_url_info where id = ?";
		Connection conn = ConnDB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, systemOperateId);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next())
			{
				sysOp.setSystemId(rs.getInt(1));
				sysOp.setName(rs.getString(2));
				sysOp.setLinkUrl(rs.getString(3));
				sysOp.setMenu(rs.getInt(4));
				sysOp.setIcon(rs.getString(5));
				sysOp.setSystemSort(rs.getInt(6));
				sysOp.setParentNode(rs.getInt(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sysOp;
	}

	/**
	 * 根据父节点选择出相应的id集合
	 */
	@Override
	public List<SystemOperate> selectSysByParentNode(int systemParentNode) {
		List<SystemOperate> listSys = new ArrayList<SystemOperate>();
		String sql = "select * from href_url_info where parent_node =?";
		Connection conn = ConnDB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, systemParentNode);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				SystemOperate sysOp = new SystemOperate();
				sysOp.setSystemId(rs.getInt(1));
				sysOp.setName(rs.getString(2));
				sysOp.setLinkUrl(rs.getString(3));
				sysOp.setMenu(rs.getInt(4));
				sysOp.setIcon(rs.getString(5));
				sysOp.setSystemSort(rs.getInt(6));
				sysOp.setParentNode(rs.getInt(7));
				listSys.add(sysOp);
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return listSys;
	}

	@Override
	public List<SystemOperate> selectAll() {
		List<SystemOperate> listSys = new ArrayList<SystemOperate>();
		String sql = "select * from href_url_info ";
		Connection conn = ConnDB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				SystemOperate sysOp = new SystemOperate();
				sysOp.setSystemId(rs.getInt(1));
				sysOp.setName(rs.getString(2));
				sysOp.setLinkUrl(rs.getString(3));
				sysOp.setMenu(rs.getInt(4));
				sysOp.setIcon(rs.getString(5));
				sysOp.setSystemSort(rs.getInt(6));
				sysOp.setParentNode(rs.getInt(7));
				listSys.add(sysOp);
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return listSys;
	}

	@Override
	public List<UserRoleNode> selectNodeAll() {
		List<UserRoleNode> listSys = new ArrayList<UserRoleNode>();
		String sql = "select * from href_url_info ";
		Connection conn = ConnDB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				UserRoleNode sysOp = new UserRoleNode();
				sysOp.setId(rs.getInt(1));
				sysOp.setPId(rs.getInt("parent_node"));
				sysOp.setName(rs.getString("href_name"));
				listSys.add(sysOp);
			}
		} catch (SQLException e) {
	
			e.printStackTrace();
		}
		return listSys;
	}




}
