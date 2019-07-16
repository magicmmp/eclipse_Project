package 多线程实现方式2_实现Runnable接口;

public class Demo2_Runnable 
{
	public static void main(String[] args) 
	{	//4,创建自定义类对象
		MyRunnable mr = new MyRunnable();
		Thread t = new Thread(mr);//5,将其当作参数传递给Thread的构造函数
		t.start();//6,开启线程
		
		for(int i = 0; i < 3000; i++) 
		{
			System.out.println("bb");
		}
	}
}

//1,自定义类实现Runnable接口
class MyRunnable implements Runnable 
{							
	@Override
	//2,重写run方法
	//3,将要执行的代码,写在run方法中
	public void run() 
	{	
		for(int i = 0; i < 3000; i++) 
		{	
			System.out.println("aaaaaaaaaaaaaaa");
		}
	}	
}