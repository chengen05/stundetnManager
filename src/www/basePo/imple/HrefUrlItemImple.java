package www.basePo.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import www.basePo.dao.HrefUrlItemDao;
import www.basePo.po.SystemOperate;
import www.conndb.ConnDB;


/**
 * 查询出子项
 * @author chen gen
 *
 */
public class HrefUrlItemImple implements HrefUrlItemDao{

	
	public List<SystemOperate> selectHrefList(int parentnode,int roleId) {
		List<SystemOperate> listItem = new ArrayList<SystemOperate>();
		String sql = "select * from href_url_info where parent_node= ? and id in (select menu_id from role_root_code where role_id =? )";
		Connection conn = ConnDB.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, parentnode);
			pstmt.setInt(2, roleId);
			ResultSet rs =pstmt.executeQuery();
			while(rs.next())
			{
				SystemOperate sys = new SystemOperate();
				sys.setSystemId(rs.getInt(1));
				sys.setLinkName(rs.getString(2));
				sys.setLinkUrl(rs.getString(3));
				sys.setMenu(rs.getInt(4));
				sys.setIcon(rs.getString(5));
				sys.setSystemSort(rs.getInt(6));
				sys.setParentNode(rs.getInt(7));
				listItem.add(sys);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listItem;
	}

}
