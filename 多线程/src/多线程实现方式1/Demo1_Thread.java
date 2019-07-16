package 多线程实现方式1;

public class Demo1_Thread 
{	
	public static void main(String[] args) 
	{
		//4,创建自定义类的对象
		MyThread mt = new MyThread();
		mt.start();	//5,开启线程		
		for(int i = 0; i < 3000; i++) 
		{
			System.out.println("主线程运行----------------------------");
		}
	}
}

class MyThread extends Thread //1,定义类继承Thread
{	
	public void run() 
	{	//2,重写run方法
		for(int i = 0; i < 3000; i++) 
		{	//3,将要执行的代码,写在run方法中
			System.out.println("子线程运行Aaaaaa");
		}
	}
}
