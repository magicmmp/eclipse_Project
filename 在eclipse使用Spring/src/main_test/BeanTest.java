package main_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring_test.Person;

public class BeanTest {
	public static void main(String[] args) throws Exception
	{
		// ����Spring����
		var ctx = new ClassPathXmlApplicationContext("beans.xml");
		// ��ȡidΪperson��Bean
		var p = ctx.getBean("person", Person.class);
		// ����useAxe()����
		p.useAxe();
		ctx.close();
	}
}
