package TestDBConnectionDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Arrays;

public class TestAddBatchDemo {

	private static final  String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private static final  String DB_URL = "jdbc:mysql://127.0.0.1:3306/lixiang";  
	private static  final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static void main(String[] args) throws Exception {
		
		//1.加载驱动程序
		Class.forName(JDBC_DRIVER);
		//2.连接数据库
		Connection conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
		Statement stmt =conn.createStatement();
		//3.执行数据库操作
		conn.setAutoCommit(false);
		try{
		stmt.addBatch("INSERT INTO user (id,uname,password) VALUES ('1','lixiang','admin')");
		stmt.addBatch("INSERT INTO user (id,uname,password) VALUES ('2','lixiang','123')");
		stmt.addBatch("INSERT INTO user (id,uname,password) VALUES ('3','lixiang','测试'666')");
		stmt.addBatch("INSERT INTO user (id,uname,password) VALUES ('4','lixiang','789')");
		stmt.addBatch("INSERT INTO user (id,uname,password) VALUES ('5','lixiang','qwa')");
		
		int result []=stmt.executeBatch();
		System.out.println(Arrays.toString(result));
		conn.commit();
		}catch(Exception e){
			e.printStackTrace();
			conn.rollback();
		}
		//4.关闭数据库
		conn.close();
	}
}
