package sqrt_x_69;

public class Solution {
	
	public int mySqrt(int x) 
	{
		//采用牛顿迭代法求平方根
		long n=x;
		while(n*n>x)
		{
			n=(n+x/n)>>1;
		}
		return (int)n;      
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		int x=20;
		System.out.println(solution.mySqrt(x));

	}

}
