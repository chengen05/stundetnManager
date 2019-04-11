package www.kaoqin.imple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import www.conndb.ConnDB;
import www.kaoqin.dao.DormCheckSocreDao;
import www.kaoqin.po.DormCheckSocre;

public class DormCheckSocreImple implements DormCheckSocreDao{

	@Override
	public boolean insertDormCheckSocre(DormCheckSocre dormCheckSocre) {
		boolean  judge = false;
		Connection conn = ConnDB.getConnection();
		String sql ="insert into dormitory_inspect_score(dor_inspect_id,score"
				+ ",inspect_name,inspect_date) values(?,?,?,?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dormCheckSocre.getDormCheckId().getDormcheckId());
			pstmt.setInt(2, dormCheckSocre.getCheckSocre());
			pstmt.setString(3, dormCheckSocre.getCheckName());
			pstmt.setString(4, dormCheckSocre.getCheckDate());
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
	public boolean updateDormCheckSocre(DormCheckSocre dormCheckSocre) {
		boolean judge = false;
		Connection conn = ConnDB.getConnection();
		String sql = "update dormitory_inspect_score set dor_inspect_id =?,"
				+ "score=?,inspect_name =?,inspect_date=? where id = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dormCheckSocre.getDormCheckId().getDormcheckId());
			pstmt.setInt(2, dormCheckSocre.getCheckSocre());
			pstmt.setString(3, dormCheckSocre.getCheckName());
			pstmt.setString(4, dormCheckSocre.getCheckDate());
			pstmt.setInt(5, dormCheckSocre.getCheckSocreId());
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
	public boolean delDormCheckSocre(int dormCheckSocreId) {
		boolean judge =  false;
		Connection conn = ConnDB.getConnection();
		String sql ="delete from dormitory_inspect_score where id = " 
		+ dormCheckSocreId;
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
