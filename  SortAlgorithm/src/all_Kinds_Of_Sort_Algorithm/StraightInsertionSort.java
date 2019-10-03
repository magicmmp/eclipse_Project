package all_Kinds_Of_Sort_Algorithm;

/**
 * 直接插入排序 (Straight Insertion Sort) 的基本思想是：
 * 
 * 把数组 a[n] 中待排序的 n 个元素看成为一个有序表和一个无序表，
 * 开始时有序表中只包含一个元素 a[0]，无序表中包含有 n-1 个元素a[1] a[n-1]，
 * 排序过程中每次从无序表中取出第一个元素，把它插入到有序表中的适当位置，
 * 使之成为新的有序表，这样经过 n-1 次插入后，无序表就变为空表，有序表中就包含了全部 n 个元素，
 * 至此排序完毕。在有序表中寻找插入位置是采用从后向前的顺序查找的方法。
 */

public class StraightInsertionSort {
	
	public static void sort(int[] a)
	{
		int tmp;
		int i, j;
		for (i =  1; i < a.length; i++) 
		{
			tmp = a[i];
			for (j = i - 1; j >= 0 && tmp < a[j]; j--) 
			{
				a[j + 1] = a[j];
			}
			a[j + 1] = tmp;
		}
	}

	public static void main(String[] args) 
	{
		int a[]= {5,4,9,8,7,6,0,1,3,2};
		sort(a);
		for (int j = 0; j < a.length; j++) 
		{
			System.out.print(a[j]+" ");
		}
		System.out.println("\n");

	}

}
