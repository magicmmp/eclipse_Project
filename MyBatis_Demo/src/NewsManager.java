import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.annotation.Resource;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.scripting.xmltags.VarDeclSqlNode;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import mapper.*;


//已成功测试在eclipse里使用mybatis框架。2020-10-1

public class NewsManager {

	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String sourceXmlString="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(sourceXmlString);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		selectTest(sqlSession);
	}
	
	
	public static void selectTest(SqlSession sqlSession)
	{
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		News news =newsMapper.getNews(1);
		System.out.println("查询得到的记录为："+news);
		sqlSession.commit();
		sqlSession.close();
		
	}

}
