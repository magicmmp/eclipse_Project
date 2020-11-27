package hehe;

import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Main {

	public static void main(String[] args) {
		// 1. ���� Spring �� IOC ����
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		//2. �� IOC �����л�ȡ bean ��ʵ��
		Person person = (Person) ctx.getBean("person");
		
		//������������ȡ bean ��ʵ��: Ҫ����  IOC ������ֻ��һ����֮����ƥ��� bean, ���ж������׳��쳣. 
		//һ�������, �÷�������, ��Ϊһ�������, ��һ�� IOC ������һ�����Ͷ�Ӧ�� bean Ҳֻ��һ��. 
//		HelloWorld helloWorld1 = ctx.getBean(HelloWorld.class);
		
		//3. ʹ�� bean
		System.out.println(person);

	}

}
