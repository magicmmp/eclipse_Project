package 线程间同步_3个或以上的线程同步;

public class While_Wait_NotifyAll 
{	
	public static void main(String[] args) 
	{
		// 轮流打印 "程序员"、"吃饭"、"睡觉"
		final Printer printer=new Printer();
		new Thread()
		{
			public void run() 
			{
				while(true)
					try {
						printer.print1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			};
		}.start();
		
		new Thread()
		{
			public void run() 
			{
				while(true)
					try {
						printer.print2();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			};
		}.start();
		
		new Thread()
		{
			public void run() 
			{
				while(true)
					try {
						printer.print3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			};
		}.start();
	}
}

class Printer
{
	private int flag=1;//控制执行顺序的标志
	
	public void print1() throws InterruptedException 
	{
		synchronized (this) 
		{
			while(flag!=1)
				this.wait();
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag=2;
			this.notifyAll();				
		}			
	}
	
	public void print2() throws InterruptedException 
	{
		synchronized (this) 
		{
			while(flag!=2)
				this.wait();
			System.out.print("吃");
			System.out.print("饭");
			System.out.print("\r\n");
			flag=3;
			this.notifyAll();				
		}			
	}
	
	public void print3() throws InterruptedException 
	{
		synchronized (this) 
		{
			while(flag!=3)
				this.wait();
			System.out.print("睡");
			System.out.print("觉");
			System.out.print("\r\n");
			flag=1;
			this.notifyAll();				
		}			
	}
}






