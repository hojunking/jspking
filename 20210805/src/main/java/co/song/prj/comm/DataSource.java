package co.song.prj.comm;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DataSource {
	
	private static SqlSessionFactory sqlSessionFactory;
	
	private DataSource( ) {}
	
	public static SqlSessionFactory getInstance() {
		try {
		String resource = "config/mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return sqlSessionFactory;
	}
}
