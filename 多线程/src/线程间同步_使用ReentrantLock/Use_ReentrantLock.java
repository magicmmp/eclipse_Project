package 线程间同步_使用ReentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Use_ReentrantLock {

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
	private ReentrantLock rLock=new ReentrantLock();
	private Condition c1=rLock.newCondition();//监视线程1
	private Condition c2=rLock.newCondition();//监视线程2
	private Condition c3=rLock.newCondition();//监视线程3
	
	public void print1() throws InterruptedException 
	{
		rLock.lock();
			if(flag!=1)
				c1.await();
			System.out.print("程");
			System.out.print("序");
			System.out.print("员");
			System.out.print("\r\n");
			flag=2;
			c2.signal();//叫醒线程2				
		rLock.unlock();		
	}
	
	public void print2() throws InterruptedException 
	{
		rLock.lock();
			if(flag!=2)
				c2.await();
			System.out.print("吃");
			System.out.print("饭");
			System.out.print("\r\n");
			flag=3;
			c3.signal();				
		rLock.unlock();				
	}
	
	public void print3() throws InterruptedException 
	{
		rLock.lock();
			if(flag!=3)
				c3.await();
			System.out.print("睡");
			System.out.print("觉");
			System.out.print("\r\n");
			flag=1;
			c1.signal();				
		rLock.unlock();				
	}
}




