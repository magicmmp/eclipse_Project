package �����̳߳ز������;
import java.util.concurrent.*;
import java.util.*;

//�̳�RecursiveTask��ʵ��"�ɷֽ�"������
class CalTask extends RecursiveTask<Integer>
{
	// ÿ����С����ֻ���ֻ�ۼ�20����
	private static final int THRESHOLD = 20;
	private int arr[];
	private int start;
	private int end;
	// �ۼӴ�start��end������Ԫ��
	public CalTask(int[] arr , int start, int end)
	{
		this.arr = arr;
		this.start = start;
		this.end = end;
	}
	@Override
	protected Integer compute()
	{
		int sum = 0;
		// ��end��start֮��Ĳ�С��THRESHOLDʱ����ʼ����ʵ���ۼ�
		if(end - start < THRESHOLD)
		{
			for (int i = start ; i < end ; i++ )
			{
				sum += arr[i];
			}
			return sum;
		}
		else
		{
			// �����end��start֮��Ĳ����THRESHOLDʱ����Ҫ�ۼӵ�������20��ʱ
			// ��������ֽ������С����
			int middle = (start + end) / 2;
			CalTask left = new CalTask(arr , start, middle);
			CalTask right = new CalTask(arr , middle, end);
			// ����ִ��������С����
			left.fork();
			right.fork();
			// ��������С�����ۼӵĽ���ϲ�����
			return left.join() + right.join();    // ��
		}
	}
}


public class Sum {

	public static void main(String[] args)
			throws Exception
		{
			int[] arr = new int[100];
			Random rand = new Random();
			int total = 0;
			// ��ʼ��100������Ԫ��
			for (int i = 0 , len = arr.length; i < len ; i++ )
			{
				int tmp = rand.nextInt(20);
				// ������Ԫ�ظ�ֵ����������Ԫ�ص�ֵ��ӵ�sum�ܺ��С�
				total += (arr[i] = tmp);
			}
			System.out.println("����Ԫ�صĺͣ�"+total);
			// ����һ��ͨ�ó�
			ForkJoinPool pool = ForkJoinPool.commonPool();
			// �ύ�ɷֽ��CalTask����
			Future<Integer> future = pool.submit(new CalTask(arr , 0 , arr.length));
			System.out.println("�̳߳ز��м��������Ԫ�صĺͣ�"+future.get());
			// �ر��̳߳�
			pool.shutdown();
		}

}
