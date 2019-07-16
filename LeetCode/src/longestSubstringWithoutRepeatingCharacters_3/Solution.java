package longestSubstringWithoutRepeatingCharacters_3;

public class Solution 
{	
	public int lengthOfLongestSubstring(String s) 
	{
		int len;
		if(s==null || (len=s.length())==0)
			return 0;		
		int startIndex=0;//新子串起始索引
		int maxLen=0;//结果
		int tmpLen;
		//记录每个字符最新出现的索引位置，从1开始
		//数组初始化为0
		int[] charPosition=new int[128];
		for(int i=0;i<len;i++)
		{
			char c=s.charAt(i);
			//发现重复字符则重新记录新子串起始位置
			if(charPosition[c]>startIndex)
				startIndex=charPosition[c];
			//当前子串的长度
			tmpLen=i-startIndex+1;
			if(tmpLen>maxLen)
				maxLen=tmpLen;	
			//更新每个出现字符的位置
			charPosition[c]=i+1;	
		}	
		return maxLen;        
    }

	public static void main(String[] args) 
	{
		String string;
		int len;
		Solution solution=new Solution();
		string="abcabcbb";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" 的不重复子串最大长度= "+len);
		
		string="bbbbb";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" 的不重复子串最大长度= "+len);
		
		string="pwwkew";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" 的不重复子串最大长度= "+len);	
	}
}
