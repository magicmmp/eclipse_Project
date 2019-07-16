package ZigZagConversion_6;

public class Solution {
	
	public String convert(String s, int numRows) 
	{
		if(numRows<2)
			return s;
		int strLen=s.length();
		char[] strChar=s.toCharArray();
		StringBuilder[] sBuilders=new StringBuilder[numRows];
		for(int i=0;i<numRows;i++)
			sBuilders[i]=new StringBuilder();
		
		int idx=0;
		while(idx<strLen)
		{
			for(int i=0;i<numRows && idx<strLen;i++)
				sBuilders[i].append(strChar[idx++]);
			for(int i=numRows-2;i>=1 && idx<strLen;i--)
				sBuilders[i].append(strChar[idx++]);
		}
		
		for(int i=1;i<numRows;i++)
			sBuilders[0].append(sBuilders[i]);
				
		return sBuilders[0].toString();       
    }
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));// PAHNAPLSIIGYIR
        System.out.println(solution.convert("ABCD", 4));
	}

}
