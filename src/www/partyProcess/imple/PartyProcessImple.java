package www.partyProcess.imple;

import java.sql.SQLException;
import com.mysql.jdbc.PreparedStatement;
import www.conndb.ConnDB;
import www.partyProcess.dao.PartyProcessDAO;
import www.partyProcess.po.PartyProcessInfo;

public class PartyProcessImple implements PartyProcessDAO {

	@Override
	public boolean inserPtyProceCode(PartyProcessInfo PtyProce) {
		boolean  judge = false;
		String sql ="insert into party_process_info(flow_name,sort) values(?,?)";
		
		try {
			PreparedStatement pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1, PtyProce.getFlowName());
			pstmt.setInt(2, PtyProce.getSort());
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
	public boolean updataPtyProceCode(PartyProcessInfo PtyProce) {
		boolean judge = false;
		String sql = "update party_process_info set flow_name =?,sort=?";
				
		try {
			PreparedStatement pstmt = (PreparedStatement)ConnDB.conn.prepareStatement(sql);
			pstmt.setString(1, PtyProce.getFlowName());
			pstmt.setInt(2, PtyProce.getSort());
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
	public boolean delPtyProceCode(int partyid) {
		boolean judge =  false;
		String sql ="delete party_process_info where id = " + partyid;
		PreparedStatement pstmt;
		try {
			pstmt =(PreparedStatement)ConnDB.conn.prepareStatement(sql);
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
