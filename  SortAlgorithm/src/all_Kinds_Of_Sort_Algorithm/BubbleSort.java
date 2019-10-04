package all_Kinds_Of_Sort_Algorithm;



/**
 * 冒泡排序 (Bubble Sort) 的基本方法是：
 * 设待排序元素序列的元素个数为 n，从后向前两两比较相邻元素的值，
 * 如果发生逆序（即前一个比后一个大），则交换它们，直到序列比较完。
 * 我们称它为一趟冒泡，结果是最小的元素交换到待排序序列的第一个位置，其他元素也都向排序的最终位置移动。
 * 下一趟冒泡时前一趟确定的最小元素不参加比较，待排序序列减少一个元素，
 * 一趟冒泡的结果又把序列中最小的元素交换到待排序序列的第一个位置。
 * 这样最多做 n-1 趟冒泡就能把所有元素排好序。
 */
public class BubbleSort 
{
	

	/**
	 * @param a[]待排序数组
	 */
	public static void sort(int[] a)
	{
		int tmp;
		boolean exchange;
		for(int i=0;i<a.length-1;i++)
		{
			exchange=false;
			for(int j=a.length-1;j>i;j--)
			{
				if(a[j-1]>a[j])
				{
					tmp=a[j];
					a[j]=a[j-1];
					a[j-1]=tmp;
					exchange=true;
				}
			}
			if(!exchange) //已经是有序序列
				return;
		}
	}
	

	public static void main(String[] args) {
		int a[]= {5,4,9,8,7,6,0,1,3,2};
		sort(a);
		for (int j = 0; j < a.length; j++) 
		{
			System.out.print(a[j]+" ");
		}
		System.out.println("\n");

	}

}
