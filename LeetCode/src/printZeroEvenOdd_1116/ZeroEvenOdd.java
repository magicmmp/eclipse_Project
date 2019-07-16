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
	//isZero=true��ӡ0���߳����У�isZero=false��ӡ������ż�����߳�����
	boolean isZero=true;
	//��¼Ҫ��ӡ0�Ĵ���
	private int zeroPrintTimes;
	//��¼Ҫ��ӡż���Ĵ���
	private int evenPrintTimes;
	//��¼Ҫ��ӡ�����Ĵ���
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
		//����һ��
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
