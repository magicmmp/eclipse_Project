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


//�ѳɹ�������eclipse��ʹ��mybatis��ܡ�2020-10-13

public class MainTest {

	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String sourceXmlString="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(sourceXmlString);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//insertTest(sqlSession,10,1);//���������¼
		//insertByProcedureTest(sqlSession,10);//���ô洢���̲��������¼
		findPersonByIdTest(sqlSession,1);
		findAddressByIdTest(sqlSession, 2);
		
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	public static void findPersonByIdTest(SqlSession sqlSession,int personId)
	{
		
		PersonMapper personMapper=sqlSession.getMapper(PersonMapper.class);
		Person person=personMapper.findPersonById(personId);

		System.out.println("��ѯ����¼��"+person);
		
	}
	
	public static void findAddressByIdTest(SqlSession sqlSession,int addressId)
	{
		
		AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
		Address findAddressById=addressMapper.findAddressById(addressId);

		System.out.println("��ѯ����¼��"+findAddressById);
		
	}
	
	

}
