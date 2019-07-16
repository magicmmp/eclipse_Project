package 线程组;

public class ThreadGroupTest 
{
	public static void main(String[] args) 
	{
		//线程组使用示例 
		ThreadGroup tGroup=new ThreadGroup("线程组A");//创建一个线程组
		Thread t1=new Thread(tGroup,new MyRunnable(),"线程1");//将指定线程加入指定线程组
		Thread t2=new Thread(tGroup,new MyRunnable(),"线程2");
		//tGroup.setDaemon(true); 设置线程组的线程为守护线程
		System.out.println(tGroup.getName());//获取线程组名称
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
