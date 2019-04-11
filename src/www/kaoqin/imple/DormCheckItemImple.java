package www.kaoqin.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.kaoqin.dao.DormCheckItemDao;
import www.kaoqin.po.DormCheckItem;

public class DormCheckItemImple implements DormCheckItemDao{

	@Override
	public boolean insertDormCheckItem(DormCheckItem dormCheckItem) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into dormitory_inspect_item(dor_inspect_id,"
				+ "inspect_score,inspect_sort,"
				+ ") values(?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dormCheckItem.getCheckItemId());
			pstmt.setInt(2, dormCheckItem.getCheckScore());
			pstmt.setInt(3, dormCheckItem.getCheckSort());                                    
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
	public boolean updateDormCheckItem(DormCheckItem dormCheckItem) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update dormitory_inspect_item set dor_inspect_id =?,inspect_score=?,"
				+ "inspect_sort =? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,dormCheckItem.getCheckOder());
			pstmt.setInt(2, dormCheckItem.getCheckScore());
			pstmt.setInt(3, dormCheckItem.getCheckSort());
			pstmt.setInt(4, dormCheckItem.getCheckItemId());
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
	public boolean delDormCheckItem(int dormCheckItemId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from dormitory_inspect_item where id = " + dormCheckItemId;
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
