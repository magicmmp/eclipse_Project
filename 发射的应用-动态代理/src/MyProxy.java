import java.lang.reflect.Proxy;

public class MyProxy 
{
	//Java JDKֻ����Խӿ�������
	public static void main(String[] args) 
	{				
		/**
		 *  public static Object newProxyInstance(ClassLoader loader,
		 *        Class<?>[] interfaces,InvocationHandler h)
		 *  ����newProxyInstance�����Ϳ��Եõ�ĳһ������Ĵ��������
		  *  ��һ������ClassLoader������ָ�����ɴ������ʹ���ĸ���װ����
		  * �ڶ�������interfaces��ָ�������ĸ�����Ĵ������ͨ���ӿ�ָ��
		  * ����������InvocationHandler��ָ������������Ҫ��ʲô����
		 */
		UserImp ui = new UserImp();
		MyInvocationHandler uiHandler = new MyInvocationHandler(ui);
		//����UserImp��ʵ��ui�Ĵ������
		User user = (User) Proxy.newProxyInstance(ui.getClass().getClassLoader(), 
				ui.getClass().getInterfaces(), uiHandler);
		user.add();
		user.delete();
		
		System.out.println("-----------������һ������-----------------");
		
		StudentImp si = new StudentImp();		
		MyInvocationHandler studentHandler = new MyInvocationHandler(si);
		//����StudentImp��ʵ��si�Ĵ������
		Student student = (Student)Proxy.newProxyInstance(si.getClass().getClassLoader(), 
				si.getClass().getInterfaces(), studentHandler);
		student.login();
		student.submit();
	}
}
