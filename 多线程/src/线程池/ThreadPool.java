package 线程池;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		//创建线程池，可以放2条线程
		ExecutorService pool=Executors.newFixedThreadPool(2);
		//创建runnable子类对象
		MyRunnable mr1=new MyRunnable();
		MyRunnable mr2=new MyRunnable();
		pool.submit(mr1);//提交任务
		pool.submit(mr2);
		//关掉线程池，不接受新任务
		pool.shutdown();
	}
}

class MyRunnable implements Runnable
{
	@Override
	public void run() 
	{
		for(int i=0;i<100;i++)
			System.out.println(Thread.currentThread().getName()+"..."+i);		
	}
}