package test;

import java.util.Locale;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Person implements ApplicationContextAware
{
	// 用成员变量保存它所在的ApplicationContext容器
	private ApplicationContext ctx;
	/* Spring容器会检测容器中所有的Bean，如果发现某个Bean实现了ApplicationContextAware接口，
	Spring容器会在创建该Bean之后，自动调用该方法，调用该方法时，
	会将容器本身作为参数传给该方法*/
	public void setApplicationContext(ApplicationContext ctx)
		throws BeansException
	{
		this.ctx = ctx;
	}
	public void sayHi(String name)
	{
		System.out.println(ctx.getMessage("hello", new String[]{name},
			Locale.getDefault(Locale.Category.FORMAT)));
	}
}