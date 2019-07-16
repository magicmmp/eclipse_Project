import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//实现InvocationHandler接口
//这里的Handler总是给被代理对象加上额外的功能
//例如：权限校验&日志记录 ，而不用修改被代理类的方法
public class MyInvocationHandler implements InvocationHandler 
{
	//定义target
	private Object target;
	//自定义有参构造函数用于传入被代理对象
	public MyInvocationHandler(Object target) 
	{
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable 
	{
		System.out.println("代理功能：权限校验");
		Object obj = method.invoke(target, args);
		System.out.println("代理功能：日志记录");
		return obj;
	}	
}
