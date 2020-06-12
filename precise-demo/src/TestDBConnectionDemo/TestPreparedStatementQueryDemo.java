package TestDBConnectionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestPreparedStatementQueryDemo {

	private static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final  String DB_URL = "jdbc:mysql://127.0.0.1:3306/lixiang";  
	private static  final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) throws Exception {
		
		//1.加载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.连接数据库
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		//3.进行数据库的数据操作
		String sql = "SELECT id,uname,password from user";
		PreparedStatement stmt =conn.prepareStatement(sql);
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			String id=rs.getString(1);
			String uname=rs.getString(2);
			String password=rs.getString(3);
			System.out.println(id+","+uname+","+password);
		}
		//4.关闭数据库
		conn.close();
				
	}
}
