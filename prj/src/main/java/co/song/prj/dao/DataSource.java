package co.song.prj.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataSource {
	private static DataSource dataSource = new DataSource(); //바깥에서 생성 못하기 막아버리기~<싱글턴 클래스>
	private Connection conn;									//싱글턴 클래스 -> 자신의 인스턴스 생성
	private String driver;
	private String url;
	private String user;
	private String password;
	
	private DataSource() {										//생성자를 외부에서 생성하지 못하게 만든다.
		//생성자도 private로 만듭니다.
	}
	
	public static DataSource getInstance() {				//외부에서는 instance를 생성하여 사용할 수 있게 만든다.
		return dataSource;									
																
	}
	public Connection getConnection() {
		configure();
		try {
			Class.forName(driver);
			conn =DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException| SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	private void configure() {
		Properties properties = new Properties();
		String resource =getClass().getResource("/db.properties").getPath();
		try {
			properties.load(new FileReader(resource)); 
			driver =properties.getProperty("driver"); //properties 파일에서 들고 옵니다
			url= properties.getProperty("url");
			user=properties.getProperty("user");
			password=properties.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
