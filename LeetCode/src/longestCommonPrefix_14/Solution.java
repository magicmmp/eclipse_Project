package longestCommonPrefix_14;

public class Solution {
	
	public String longestCommonPrefix(String[] strs) 
	{
        if (strs.length == 0) 
            return "";
        int minStrLen=Integer.MAX_VALUE;
		for(String s:strs)
			if(s.length()<minStrLen)
				minStrLen=s.length();
		int res=0;
		for(int i=0;i<minStrLen;i++)
		{
			for(int j=1;j<strs.length;j++)
			{
				if(strs[0].charAt(i)!=strs[j].charAt(i))
					return strs[0].substring(0, i);
			}
			res++;
		}
		return strs[0].substring(0, res);
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}

}
