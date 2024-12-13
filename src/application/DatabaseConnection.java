package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	 private String url = "jdbc:mysql://localhost:3306/your_database_name";
	    private String username = "your_username";
	    private String password = "your_password";
	    
	    public Connection getConnection() throws SQLException {
	        return DriverManager.getConnection(url, username, password);
	    }
}
