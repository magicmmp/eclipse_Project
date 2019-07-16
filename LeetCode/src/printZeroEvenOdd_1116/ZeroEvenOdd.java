package printZeroEvenOdd_1116;

class IntConsumer
{
	void accept(Integer x)
	{
		System.out.print(x);
	}	
}

public class ZeroEvenOdd 
{	
	private int n;
	//isZero=true打印0的线程运行，isZero=false打印奇数或偶数的线程运行
	boolean isZero=true;
	//记录要打印0的次数
	private int zeroPrintTimes;
	//记录要打印偶数的次数
	private int evenPrintTimes;
	//记录要打印奇数的次数
	private int oddPrintTimes;
	private int x=1;
    
    
    public ZeroEvenOdd(int n) 
    {
        this.n = n;      
        zeroPrintTimes=n;      
        evenPrintTimes=n/2;
        oddPrintTimes=evenPrintTimes+(n&0x1);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException 
    {   	
    	while(zeroPrintTimes-->0)
    	{
    		synchronized (this) 
    		{
    			if(!isZero )
    				this.wait();
	    		printNumber.accept(0);
	    		isZero=false;
	    		this.notifyAll();				
    		}
    	}        
    }

    public void even(IntConsumer printNumber) throws InterruptedException 
    {
    	while(evenPrintTimes-->0)
    	{
    		synchronized (this) 
    		{
    			while(isZero || (x&0x1)!=0 )
    				this.wait();
	    		printNumber.accept(x++);
	    		isZero=true;
	    		this.notifyAll();					
    		}
    	}        
    }

    public void odd(IntConsumer printNumber) throws InterruptedException 
    {
    	while(oddPrintTimes-->0)
    	{
    		synchronized (this) 
    		{
    			while(isZero || (x&0x1)==0 )
    				this.wait();
	    		printNumber.accept(x++);
	    		isZero=true;
	    		this.notifyAll();				
    		}
    	}
    }

	public static void main(String[] args) 
	{
		//测试一下
		ZeroEvenOdd printer=new ZeroEvenOdd(5);
		IntConsumer iConsumer=new IntConsumer();
		new Thread()
		{
			public void run() 
			{				
				try 
				{
					printer.zero(iConsumer);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			};
		}.start();
		
		new Thread()
		{
			public void run() 
			{				
				try 
				{
					printer.even(iConsumer);
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			};
		}.start();
		
		new Thread()
		{
			public void run() 
			{
				
				try 
				{
					printer.odd(iConsumer);
				} catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			};
		}.start();
	}

}
