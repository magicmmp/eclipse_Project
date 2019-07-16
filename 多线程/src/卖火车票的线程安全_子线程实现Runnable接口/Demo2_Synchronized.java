package 卖火车票的线程安全_子线程实现Runnable接口;

public class Demo2_Synchronized 
{
	/**
	 * 需求:铁路售票,一共100张,通过四个窗口卖完.
	 */
	public static void main(String[] args) 
	{
		Ticket t=new Ticket();
		Thread t1=new Thread(t,"窗口1");
		Thread t2=new Thread(t,"窗口2");
		Thread t3=new Thread(t,"窗口3");
		Thread t4=new Thread(t,"窗口4");
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}

class Ticket implements Runnable 
{   //将同一个线程对象传入多个线程的Thread参数时，依然是多个线程共享100张票
	//不用static也可以
	private  int tickets = 100;
	public void run() 
	{
		while(true) 
		{
			//同步要互斥执行的代码块
			synchronized(Ticket.class) 
			{
				if(tickets <= 0) 
					break;
				try 
				{
					Thread.sleep(10);
				} 
				catch (InterruptedException e) 
				{					
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + "...这是第" + tickets-- + "号票");
			}
		}
	}
}
