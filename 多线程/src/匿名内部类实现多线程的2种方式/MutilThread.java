package 匿名内部类实现多线程的2种方式;

public class MutilThread {

	public static void main(String[] args) {
		
		//方法1：继承Thread类产生子线程
		new Thread() 
		{	
			public void run() 
			{	//2,重写run方法
				for(int i = 0; i < 3000; i++) 
				{	//3,将要执行的代码,写在run方法中
					System.out.println("匿名内部类1：通过继承Thread类创建子线程");
				}
			}
		}.start();
		
		//方法2：通过实现Runnable接口
		new Thread(new Runnable()
		{	
			public void run() 
			{	//2,重写run方法
				for(int i = 0; i < 3000; i++) 
				{	//3,将要执行的代码,写在run方法中
					System.out.println("匿名内部类2：通过实现Runnable接口创建子线程");
				}
			}
		}).start(); 
		
		
		
		

		
		
	}

}
