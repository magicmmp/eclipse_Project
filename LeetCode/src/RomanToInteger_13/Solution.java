package RomanToInteger_13;

import java.util.HashMap;

/**
	 * 字符          		   数值
		I             1
		V             5
		X             10
		L             50
		C             100
		D             500
		M             1000
	 *
	 */
public class Solution 
{
	public int romanToInt(String s) 
	{
		HashMap<Character,Integer> map=new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int len=s.length();
		int sum=map.get(s.charAt(len-1));
		for(int i=len-2;i>=0;i--)
		{
			if(map.get(s.charAt(i))<map.get(s.charAt(i+1)))
				sum=sum-map.get(s.charAt(i));
			else 
				sum=sum+map.get(s.charAt(i));
		}
        return sum;
    }
	public static void main(String[] args) 
	{
		Solution solution=new Solution();
		String s="MCMXCIV";
		System.out.println(s+" = "+solution.romanToInt(s));
	}
}
