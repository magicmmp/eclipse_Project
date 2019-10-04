package all_Kinds_Of_Sort_Algorithm;

/**
 * 简单插入排序在查找插入位置时，若改进为折半查找，就是折半插入排序 (Binary Insertion Sort)。
 *
 */


public class BinaryInsertionSort 
{
	
	public static void sort(int[] a)
	{
		int tmp;
		int i, j, left, right, mid;
		for (i = 1; i < a.length; i++) 
		{
			tmp = a[i];
			left = 0;
			right = i - 1;
			while (left <= right)
			{
				mid = (left + right) / 2;
				if (tmp < a[mid]) 
				{
					right = mid - 1;
				} 
				else 
				{
					left = mid + 1;
				}
			}
			for (j = i - 1;j >= left; j--) 
			{
				a[j + 1] = a[j];
			}
			a[left] = tmp;
		}
	}
	

	public static void main(String[] args) 
	{
		int a[]= {5,4,9,22,8,7,6,0,1,3,2};
		sort(a);
		for (int j = 0; j < a.length; j++) 
		{
			System.out.print(a[j]+" ");
		}
		System.out.println("\n");

	}

}
