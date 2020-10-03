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


//�ѳɹ�������eclipse��ʹ��mybatis��ܡ�2020-10-1

public class NewsManager {

	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String sourceXmlString="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(sourceXmlString);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//insertTest(sqlSession,1,10);//���������¼
		for(int i=200;i<250;i++)
			selectTest(sqlSession, i);
		
		for(int i=1;i<0;i++)
			updateTest(sqlSession, i,"�����µı���"+i,"�����µ�����"+i);
		
		for(int i=50;i<0;i++)
			deleteTest(sqlSession,i);
		
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	public static void selectTest(SqlSession sqlSession,int id)
	{
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		News news =newsMapper.getNews(id);
		System.out.println("��ѯ�õ��ļ�¼Ϊ��"+news);	
	}
	
	public static void insertTest(SqlSession sqlSession,int startId,int nLine)
	{
		News news =new News();
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		for(int i=startId;i<startId+nLine;i++)
		{
			news.setId(i);
			news.setTitle("����"+i);
			news.setContent("����"+i);
			newsMapper.saveNews(news);
		}

		System.out.println("������"+nLine+"����¼��");

	}
	
	public static void updateTest(SqlSession sqlSession,int id,String title,String content)
	{
		News news =new News();
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		
		news.setId(id);
		news.setTitle(title);
		news.setContent(content);
		int n=newsMapper.updateNews(news);
		
		System.out.println("�����˵�"+id+"����¼��");
		
	}

	public static void deleteTest(SqlSession sqlSession,int id)
	{
		
		NewsMapper newsMapper=sqlSession.getMapper(NewsMapper.class);
		
		
		int n=newsMapper.deleteNews(id);
		
		System.out.println("ɾ���˵�"+id+"����¼��");
		
	}

}
