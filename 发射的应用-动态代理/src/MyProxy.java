import java.lang.reflect.Proxy;

public class MyProxy 
{
	//Java JDK只能针对接口做代理
	public static void main(String[] args) 
	{				
		/**
		 *  public static Object newProxyInstance(ClassLoader loader,
		 *        Class<?>[] interfaces,InvocationHandler h)
		 *  调用newProxyInstance方法就可以得到某一个对象的代理对象了
		  *  第一个参数ClassLoader：用来指明生成代理对象使用哪个类装载器
		  * 第二个参数interfaces：指明生成哪个对象的代理对象，通过接口指定
		  * 第三个参数InvocationHandler：指明这个代理对象要做什么事情
		 */
		UserImp ui = new UserImp();
		MyInvocationHandler uiHandler = new MyInvocationHandler(ui);
		//创建UserImp类实例ui的代理对象
		User user = (User) Proxy.newProxyInstance(ui.getClass().getClassLoader(), 
				ui.getClass().getInterfaces(), uiHandler);
		user.add();
		user.delete();
		
		System.out.println("-----------代理另一个对象：-----------------");
		
		StudentImp si = new StudentImp();		
		MyInvocationHandler studentHandler = new MyInvocationHandler(si);
		//创建StudentImp类实例si的代理对象
		Student student = (Student)Proxy.newProxyInstance(si.getClass().getClassLoader(), 
				si.getClass().getInterfaces(), studentHandler);
		student.login();
		student.submit();
	}
}
