package co.yedam.teamcook.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;



public class DataSource {
	private static DataSource dataSource = new DataSource(); //1)자기자신 인스턴스 생성
	private Connection conn;
	private String driver;
	private String url;
	private String user;
	private String pass;
	
private DataSource( ) {}//생성자... 2) 외부에서 생성하지 못하도록 자기 생성자를 private로만듦
	
	public static DataSource getInstance() { //	3)외부에서 사용 할 때는 인스턴스를 불러서 사용하도록 만들어줌
		return dataSource;
	}
	
	public Connection getConnection() { //	5) 겟커넥션을 사용해서 연결을 하면 된다...
		
		configure(); //외부properties 파일 읽어오기..
		
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, user, pass);
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
			return conn;
	}
	
	private void configure() { 
		//외부의 리소스 파일을 읽어올거임. 	4)외부 리소스 파일 읽어와서 값 담고 
		Properties properties = new Properties();
		String resource = getClass().getResource("/db.properties").getPath();
		
		try {
			
			properties.load(new FileReader(resource));
			driver = properties.getProperty("driver");
			url=properties.getProperty("url");
			user=properties.getProperty("user");
			pass=properties.getProperty("pass");
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
