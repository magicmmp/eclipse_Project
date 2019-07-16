package longestPalindromicSubstring_5;

public class Solution {

	/**
	 * 动态规划解法
	 * 用一个二维数组isPalindrome来作为备忘录，记录子问题的结果，以便重复的计算。
	 * 这也是动态规划的精髓所在。不过这种做法的算法复杂度也是O(n^2)
	 */
	public String longestPalindrome(String s) 
	{
		if(s==null || s.length()==0)
			return "";
		int len=s.length();
		int startIndex=0;//s回文子串的起始下标
		int maxLen=1;//回文子串的最大长度
		//二维数组记录子问题结果
		//isPalindrome[i][j]为true表示字符串i到j的子串是回文子串
		boolean [][]isPalindrome=new boolean[len][len];
		//初始化，记录任意长度为1和2的子串结果
		for(int i=0;i<len;i++)
		{
			isPalindrome[i][i]=true;
			if(i<len-1 && s.charAt(i)==s.charAt(i+1))
			{
				isPalindrome[i][i+1]=true;
				startIndex=i;
				maxLen=2;
			}
		}
		//L是子串长度
		for(int L=3;L<=len;L++)
		{
			//i是枚举子串的起始点
			for(int i=0;i<len-L+1;i++)
			{
				int endIndex=i+L-1;//枚举子串终点
				if(s.charAt(i)==s.charAt(endIndex) 
					&& isPalindrome[i+1][endIndex-1])
				{
					isPalindrome[i][endIndex]=true;
					startIndex=i;
					maxLen=L;
				}
			}
		}
				
		return s.substring(startIndex, startIndex+maxLen);
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
