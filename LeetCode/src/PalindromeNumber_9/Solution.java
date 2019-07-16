package PalindromeNumber_9;

public class Solution {
	
	public boolean isPalindrome(int x) 
	{
		String string=Integer.toString(x);
		StringBuilder sb1=new StringBuilder(string);
		StringBuilder sb2=new StringBuilder(string);
		sb2.reverse();
		return sb1.toString().equals(sb2.toString());
        
    }
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x=121;
	
		String string=""+x;
		StringBuilder sb1=new StringBuilder(string);
		StringBuilder sb2=new StringBuilder(string);
		sb2.reverse();
		
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		System.out.println(sb1.toString().equals(sb2.toString()));
		

	}

}
