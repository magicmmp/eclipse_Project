package printInOrder_1114_MultiThread;


class Foo 
{
    
    private int flag=1;//����ִ��˳��ı�־

    public Foo() {}

    public void first(Runnable printFirst) throws InterruptedException {
        
        synchronized (this) //�߳�ͬ���ؼ���
		{
			while(flag!=1)
				this.wait();  //����������͵ȴ�
        
        // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            
            flag=2;
			this.notifyAll();	//֪ͨ�����߳�ִ��			
		}			
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (this) 
		{
			while(flag!=2)
				this.wait();
        
        // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            flag=3;
			this.notifyAll();				
		}			
    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (this) 
		{
			while(flag!=3)
				this.wait();
        
        // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
            flag=1;
			this.notifyAll();				
		}			
    }
}