package all_Kinds_Of_Sort_Algorithm;

/**
 *快速排序 (quick sort) 的基本思想:
 *任取待排序元素序列中的某个元素（例如取第一个元素）作为基准，
 *按照该元素的关键字大小，将整个元素序列划分为左右两个子序列：
 *左侧子序列中所有元素的关键字都小于基准元素的关键字，
 *右侧子序列中所有元素的关键字都大于或等于基准元素的关键字，
 *基准元素则排在这两个子序列中间（这也是该元素最终应该安放的位置）。
 *然后分别对这两个子序列重复施行上述算法，直到所有的元素都排在相应位置为止。
 */

public class QuickSort 
{
	
	private  static int partition(int a[],  int start,  int end) 
	{
		int i = start;
		int j = end - 1;
		int pivot = a[i];
		while(i < j) 
		{
			while(i < j && a[j] >= pivot) 
				j--;
			a[i] = a[j];
			while(i < j && a[i] <= pivot) 
				i++;
			a[j] = a[i];
		}
		a[i] = pivot;
		return i;
	}
	
	private  static void quick_sort(int a[], int start, int end) 
	{
		if(start < end - 1) /* 至少两个元素 */
		{ 
			int pivot_pos = partition(a, start, end);
			quick_sort(a, start, pivot_pos);
			quick_sort(a, pivot_pos + 1, end);
		}
	}
		
	public static void sort(int[] a)
	{
		quick_sort(a, 0, a.length);
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
