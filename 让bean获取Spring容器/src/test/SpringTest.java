package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest
{
	public static void main(String[] args) throws Exception
	{
		var ctx = new ClassPathXmlApplicationContext("beans.xml");
		var p = ctx.getBean("person", Person.class);
		p.sayHi("ËïÎò¿Õ");
	}
}
