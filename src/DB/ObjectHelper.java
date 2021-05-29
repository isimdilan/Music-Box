package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObjectHelper {
	private String username="root";
	private String password="123";
	private String url="jdbc:mysql://localhost:3306/music";
	private static String driver="com.mysql.cj.jdbc.Driver";
	
	static 
	{
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() 
	{
		Connection connection=null;
		try {
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/music", "root", "122503.Ahmet");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
		
	}

}
