package TestDBConnectionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class TestDBConnectionDemo {

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
		Statement stmt =conn.createStatement();
/*		String sql = "INSERT INTO user (id,uname,password) VALUES (5,'lixiang','admin')";
		int lens=stmt.executeUpdate(sql);
		System.out.println("影响的行数为："+lens);
*/
		String sql = "SELECT id,uname,password from user";
		ResultSet rs=stmt.executeQuery(sql);
		while(rs.next()){
			String id=rs.getString("id");
			String uname=rs.getString("uname");
			String password=rs.getString("password");
			System.out.println(id+","+uname+","+password);
		}
		//4.关闭数据库
		conn.close();

	}
}
