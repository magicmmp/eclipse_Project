package ReverseInteger_7;

public class Solution {
		
	 public int reverse(int x) 
	 {
		 long result=0;
		 
		 for(;x!=0;x=x/10)
		 {
			 result=result*10+x%10;
		 }
		 return result > Integer.MAX_VALUE||result<Integer.MIN_VALUE ?  0 : (int)result;   
	 }

	public static void main(String[] args) {
		Solution solution=new Solution();
		System.out.println(solution.reverse(123));
		System.out.println(solution.reverse(-123));
		System.out.println(solution.reverse(120));
		System.out.println(solution.reverse(100));
		System.out.println(solution.reverse(1000000003));
	}
}
