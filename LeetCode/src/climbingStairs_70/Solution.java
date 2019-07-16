package climbingStairs_70;

public class Solution {
//爬n级楼梯的结果f(n)=f(n-1)+f(n-2)
//只需要保存前两个计算结果
	public int climbStairs(int n) 
	{
		int n1=1;//前一个计算结果
		int n2=2;//结果
		int tmp;
		if(n>2)
		{
			while (n>2) 
			{
				tmp=n2;
				n2=n1+n2;
				n1=tmp;	
				n--;
			}			
			return n2;			
		}
		else if (n==2) 
		{
			return 2;
		}
		else
		{
			return 1;
		}
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		for (int i = 1; i < 6; i++) {
			System.out.println("爬 "+i+" 级楼梯有 "+solution.climbStairs(i)+" 种方法");
		}

	}

}
