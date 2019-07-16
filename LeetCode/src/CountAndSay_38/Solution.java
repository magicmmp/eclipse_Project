package CountAndSay_38;

public class Solution {
	
public String countAndSay(int n) 
	{
		String string="1";
		for(int i=1;i<n;i++)
		{
			string=nextNum(string);
		}
		return string;        
    }
    //由当前报数计算下一个报数
	String nextNum(String str)
	{
		char[] charStr=str.toCharArray();
		int len=charStr.length;
		StringBuilder sb=new StringBuilder();
		int times=1;
		for(int i=1;i<len;i++)
		{
			if(charStr[i]==charStr[i-1])
				times++;
			else 
			{
				sb.append(times).append(charStr[i-1]);
				times=1;//发现新的字符
			}
		}
		//补上最后一个数字的计数
		sb.append(times).append(charStr[len-1]);
		str=sb.toString();
		return str;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		for(int i=1;i<6;i++)
			System.out.println(solution.countAndSay(i));
	}
}
