package co.yedam.sportscomu.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource();
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() { }
	
	public static DataSource getInstance() {
		return dataSource;
	}
	
	public Connection getConnection() {
		config();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void config() {
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		
		try {
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url = properties.getProperty("url");
			user = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}
