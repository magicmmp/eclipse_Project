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
		
		//insertTest(sqlSession,10,1);//插入多条记录
		//insertByProcedureTest(sqlSession,10);//利用存储过程插入多条记录
		for(int i=1;i<41;i++)
			selectTest(sqlSession, i);
		
		for(int i=1;i<0;i++)
			updateTest(sqlSession, i,"被更新的标题"+i,"被更新的内容"+i);
		
		for(int i=10;i<0;i++)
			deleteTest(sqlSession,i);
		
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	public static void selectTest(SqlSession sqlSession,int id)
	{
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		News news =newsMapper.getNews(id);
		System.out.println("查询得到的记录为："+news);	
	}
	
	public static void insertTest(SqlSession sqlSession,int startId,int nLine)
	{
		News news =new News();
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		for(int i=startId;i<startId+nLine;i++)
		{
			news.setId(i);
			news.setTitle("标题"+i);
			news.setContent("内容"+i);
			newsMapper.saveNews(news);
		}

		System.out.println("插入了"+nLine+"条记录。");

	}
	
	public static void insertByProcedureTest(SqlSession sqlSession,int nLine)
	{
		News news =new News();
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		for(int i=0;i<nLine;i++)
		{
			news.setId(888888);
			news.setTitle("标题_利用存储过程插入"+i);
			news.setContent("内容_利用存储过程插入"+i);
			newsMapper.saveNewsByProcedure(news);
			System.out.println("新插入的记录id为："+news.getId());
		}
	}
	
	public static void updateTest(SqlSession sqlSession,int id,String title,String content)
	{
		News news =new News();
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		int n=newsMapper.updateNews(news);
		
		System.out.println("更新了第"+id+"条记录。");
		
	}

	public static void deleteTest(SqlSession sqlSession,int id)
	{
		
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		
		
		int n=newsMapper.deleteNews(id);
		
		System.out.println("删除了第"+id+"条记录。");
		
	}

}
