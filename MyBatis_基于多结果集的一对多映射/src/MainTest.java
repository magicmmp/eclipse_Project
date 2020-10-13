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


//已成功测试在eclipse里使用mybatis框架。2020-10-13

public class MainTest {

	private static SqlSessionFactory sqlSessionFactory;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String sourceXmlString="mybatis-config.xml";
		InputStream inputStream=Resources.getResourceAsStream(sourceXmlString);
		sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		//insertTest(sqlSession,10,1);//插入多条记录
		//insertByProcedureTest(sqlSession,10);//利用存储过程插入多条记录
		findPersonByIdTest(sqlSession,1);
		findAddressByIdTest(sqlSession, 2);
		
		
		
		sqlSession.commit();
		sqlSession.close();
	}
	
	
	
	public static void findPersonByIdTest(SqlSession sqlSession,int personId)
	{
		
		PersonMapper personMapper=sqlSession.getMapper(PersonMapper.class);
		Person person=personMapper.findPersonById(personId);

		System.out.println("查询到记录："+person);
		
	}
	
	public static void findAddressByIdTest(SqlSession sqlSession,int addressId)
	{
		
		AddressMapper addressMapper=sqlSession.getMapper(AddressMapper.class);
		Address findAddressById=addressMapper.findAddressById(addressId);

		System.out.println("查询到记录："+findAddressById);
		
	}
	
	

}
