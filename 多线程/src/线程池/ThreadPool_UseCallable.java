package 线程池;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool_UseCallable 
{
	public static void main(String[] args) throws InterruptedException, ExecutionException 
	{
		//创建线程池，可以放2条线程
		ExecutorService pool=Executors.newFixedThreadPool(2);
		//创建Callable子类对象
		MyCallable mc1=new MyCallable(100);
		MyCallable mc2=new MyCallable(200);
		//返回的Future对象用来获取计算结果
		Future<Integer> f1=pool.submit(mc1);
		Future<Integer> f2=pool.submit(mc2);
		//获取计算结果
		Integer sum1=f1.get();
		Integer sum2=f2.get();
		
		System.out.println(sum1);
		System.out.println(sum2);
		//关掉线程池，不接受新任务
		pool.shutdown();
	}
}

class MyCallable implements Callable<Integer>
{
	private int num;
	public  MyCallable(int num) 
	{
		this.num=num;
	}	
	@Override
	public Integer call() throws Exception {
		//求和线程
		int sum=0;
		for (int i = 1; i < num; i++) {
			sum=sum+i;
		}
		return sum;
	}
}


















