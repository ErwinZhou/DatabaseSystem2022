package PLDataBase;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;

public class Main {
	private static String url="jdbc:mysql://localhost:3306/premierleague?useUnicode=true&characterEncoding=utf8";
	private static String user="root";
	private static String password="53468896Aa@";
	public static void main(String[] args) {
		startFrame startjf=new startFrame();
		
		
//		try {
//			//加载驱动
//			Class.forName("com.mysql.jdbc.Driver");
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		Connection conn=null;
//		Statement stat=null;
//		ResultSet rs=null;
//		//获取连接
//		try {
//				conn = DriverManager.getConnection(url, user, password);
//				String sql="SELECT * from club";
//				stat=conn.createStatement();
//				rs=stat.executeQuery(sql);
//				while(rs.next()){
//					String sn=rs.getString("name");
//					String sc=rs.getString("coach");
//					String sr=rs.getString("rank");
//					String sa=rs.getString("area");
//					String sp=rs.getString("points");
//					String sh=rs.getString("home_stadium");
//					
//					club cl=new club(sn,sc,Integer.parseInt(sr),sa,Integer.parseInt(sp),sh);
//					System.out.println(cl);
//				}
//			
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}finally{//以防在conn close之前出现异常无法关闭
//			
//			
//			//关闭conn
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//关闭stat
//			try {
//				stat.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//关闭rs
//			try {
//				rs.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//		
//		
//		
//		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
