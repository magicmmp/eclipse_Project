package buildingH2O_1117;


class ReleaseHydrogen implements Runnable
{
	@Override
	public void run() 
	{
		System.out.print("H");
	}	
}

class ReleaseOxygen implements Runnable
{

	@Override
	public void run() 
	{
		System.out.print("O");
	}	
}




public class H2O 
{ 
	/**
	    *����˼·(��Ȼͨ���ˣ���Ҳ�����ǵ�Ч�Ļ���)
	    *���ź���ȷ��ÿ��ֻ��2��H�̻߳�1��O�߳̽���
	    *��synchronizedȷ��Ϊ�������
	    */
    private static java.util.concurrent.Semaphore semiH,semiO;
	private static int numH,numO;
    
    public H2O() 
    {
        semiH = new java.util.concurrent.Semaphore(2); // H�߳��ź���
        semiO = new java.util.concurrent.Semaphore(1); // O�߳��ź���      
        numH=0;
        numO=0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semiH.acquire(); // ��ֻ֤��2��H�߳̽���ִ��       	        
       synchronized (H2O.class)
        {
           releaseHydrogen.run();
        	numH++;
        	if(numH==2 && numO==1)
        	{
        		numH=0;
                numO=0;
                semiO.release();
                semiH.release(2);
        	}	
        }	  
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semiO.acquire();
        
        synchronized (H2O.class)
        {
           releaseOxygen.run(); 
            numO++;
        	if(numH==2)
        	{
        		numH=0;
                numO=0;
                semiO.release();
                semiH.release(2);
        	}		
        }	          
    }
}