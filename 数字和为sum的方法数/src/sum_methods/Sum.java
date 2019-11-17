package sum_methods;

import java.util.Scanner;

//牛客网题目--简单动态规划

public class Sum {

	
	//优化的算法，把存放中间结果的二维数组改为一维数组
		public static long fun_1(int array[],int targetSum)
		{
	        //可能的组合可能很多，结果用long数组保存
			long[] dp=new long[targetSum+1];
			dp[0]=1;
			
			//每次增加一个元素，从后往前更新结果
			for(int i=0;i<array.length;i++)
			{
				for(int j=targetSum;j>0;j--)
				{
					if(array[i]<=j)
						dp[j]=dp[j]+dp[j-array[i]];
				}
			}	
			return dp[targetSum];
		}
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int sum=in.nextInt();
		int array[]=new int[n];
		
		for(int i=0;i<array.length;i++)
			array[i]=in.nextInt();
				
		System.out.println(fun_1(array, sum));
		in.close();
	}

}
