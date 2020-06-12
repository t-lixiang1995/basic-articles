package TestDBConnectionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class TestPreparedStatementDemo {

	private static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final  String DB_URL = "jdbc:mysql://127.0.0.1:3306/lixiang";  
	private static  final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) throws Exception {
	
		String id="MR'li";
		String uname="lixiang";
		String password="123";
		//1.加载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.连接数据库
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		//3.进行数据库的数据操作
		String sql = "INSERT INTO user (id,uname,password) VALUES (?,?,?)";
		PreparedStatement stmt =conn.prepareStatement(sql);
		stmt.setString(1, id);
		stmt.setString(2, uname);
		stmt.setString(3, password);
		int lens=stmt.executeUpdate();
		System.out.println("影响的行数为："+lens);
		//4.关闭数据库
		conn.close();
	}
}
