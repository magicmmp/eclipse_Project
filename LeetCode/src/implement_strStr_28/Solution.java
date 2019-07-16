package implement_strStr_28;

public class Solution {
	public int strStr(String haystack, String needle) 
	{
		int strLen1=haystack.length();
		int strLen2=needle.length();
		if(strLen2==0)
			return 0;
		int i=0,j;
		while(i<= strLen1-strLen2)
		{
			j=0;
			while(true)
			{
				if(haystack.charAt(i+j)!=needle.charAt(j))
					break;
				j++;
				if(j==strLen2)
					return i;
			}
			i++;
		}		
		return -1;	        
	}

	public static void main(String[] args) 
	{
		Solution solution=new Solution();
		String s1="hello";
		String s2="ll";
		System.out.println("子字符串 "+s2+" 在 "+s1+" 的起始位置= "+solution.strStr(s1, s2));
	}
}
