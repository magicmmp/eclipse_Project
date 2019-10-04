package all_Kinds_Of_Sort_Algorithm;

/**
  *选择排序 (Selection sort) 的基本思想是：
  *每一趟在后面 n-i(i=1, 2, …, n-2) 个元素中选取最小的元
  *素作为有序序列的第 i 个元素。
 */

public class SelectSort 
{
	
	public static void sort(int[] a) 
	{
		int minIndex;
		int tmp;
		int i,j;
		for(i=0;i<a.length-1;i++)  //1、i是每趟选择的开始位置
		{
			minIndex=i;
			for(j=i+1;j<a.length;j++)
			{
				if(a[j]<a[minIndex]) //2、找出从a[i]到最后一个元素之间的最小的元素
					minIndex=j;
			}
			if(minIndex!=i) //3、将每趟选出的最小值放在前面
			{
				tmp=a[i];
				a[i]=a[minIndex];
				a[minIndex]=tmp;
			}
		}
	}
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int a[]= {5,4,9,8,7,6,0,1,3,2};
		sort(a);
		for (int j = 0; j < a.length; j++) 
		{
			System.out.print(a[j]+" ");
		}
		System.out.println("\n");

	}

}
