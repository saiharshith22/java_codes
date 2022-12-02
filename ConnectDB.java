package studentjdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//import com.mysql.jdbc.Driver;

public class ConnectDB {
	static Connection connection;
	public static Connection createConnection() {
		
		try {
			
//			Driver driver = new Driver();
//			DriverManager.registerDriver(driver);
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/employee";
			String username="root";
			String password="devibalu@99";
			connection = DriverManager.getConnection(url, username, password);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
		
	}
}
