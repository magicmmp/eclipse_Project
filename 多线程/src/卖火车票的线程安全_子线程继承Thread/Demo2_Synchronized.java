package 卖火车票的线程安全_子线程继承Thread;
public class Demo2_Synchronized 
{
	/**
	 * 需求:铁路售票,一共100张,通过四个窗口卖完.
	 */
	public static void main(String[] args) 
	{
		TicketsSeller t1 = new TicketsSeller();
		TicketsSeller t2 = new TicketsSeller();
		TicketsSeller t3 = new TicketsSeller();
		TicketsSeller t4 = new TicketsSeller();
		
		t1.setName("窗口1");
		t2.setName("窗口2");
		t3.setName("窗口3");
		t4.setName("窗口4");
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}

}

class TicketsSeller extends Thread 
{   //static表示多个线程共享100张票
	private static int tickets = 100;
	public TicketsSeller() 
	{
		super();		
	}
	public TicketsSeller(String name) 
	{
		super(name);//传入线程名字
	}
	public void run() 
	{
		while(true) 
		{
			//同步要互斥执行的代码块
			synchronized(TicketsSeller.class) 
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
				System.out.println(getName() + "...这是第" + tickets-- + "号票");
			}
		}
	}
}
