package www.conndb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
	public class ConnDB{
		 
		public static Connection conn=null;
		//�������ݿ����ӵķ���
		public static Connection getConnection()  {
			  try {
					Class.forName("com.mysql.jdbc.Driver");
				    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentm", "root", "root");
					return conn;
				} catch (ClassNotFoundException e) {
					  e.printStackTrace();
				}catch(SQLException e) {
					  e.printStackTrace();
				}
			  return null;		
		}
		
		//�ر����ݿ����ӵķ���
	   public static void closeConn() {
		   if(conn!=null) {
			   try {
				   conn.close();
			   }catch(SQLException e) {
				   e.printStackTrace();
			   }
		   }
	   }
	   
}
