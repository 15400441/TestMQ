package deploy.fixin.utils;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {
	private static SqlSessionFactory factory;
	
	private MyBatisUtils(){};
	
	static{
		try(Reader reader=Resources.getResourceAsReader("mybatis-config.xml")){
			
			factory=new SqlSessionFactoryBuilder().build(reader);
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return factory;
	}
	
	
	public static SqlSession getSqlSession(){
		long startTime=System.nanoTime();
		SqlSession s= factory.openSession();
		long endTime=System.nanoTime();
		System.out.println("get sqlSession consuming time:"+(endTime-startTime)/1000000);
		return s;
	}

}
