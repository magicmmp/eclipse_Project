package hehe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("bean-annotetion.xml");
		
		MyBean myBean = (MyBean) ctx.getBean("MyBean223");
		myBean.info();
	}
}
