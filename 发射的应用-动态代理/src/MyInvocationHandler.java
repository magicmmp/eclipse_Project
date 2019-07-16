import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//ʵ��InvocationHandler�ӿ�
//�����Handler���Ǹ������������϶���Ĺ���
//���磺Ȩ��У��&��־��¼ ���������޸ı�������ķ���
public class MyInvocationHandler implements InvocationHandler 
{
	//����target
	private Object target;
	//�Զ����вι��캯�����ڴ��뱻�������
	public MyInvocationHandler(Object target) 
	{
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable 
	{
		System.out.println("�����ܣ�Ȩ��У��");
		Object obj = method.invoke(target, args);
		System.out.println("�����ܣ���־��¼");
		return obj;
	}	
}
