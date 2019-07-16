package addBinary_67;

public class Solution {	
	public String addBinary(String a, String b) 
	{
		StringBuilder sBuilder=new StringBuilder();
		int carry=0;
		int idx1=a.length()-1;
		int idx2=b.length()-1;
		while(idx1>=0 && idx2>=0)
		{
			carry=carry+a.charAt(idx1--)-'0';
			carry=carry+b.charAt(idx2--)-'0';
			sBuilder.append((char)(carry%2+'0'));
			carry=carry>>1;
		}
		
		while(idx1>=0)
		{
			carry=carry+a.charAt(idx1--)-'0';
			sBuilder.append((char)(carry%2+'0'));
			carry=carry>>1;
		}
		
		while(idx2>=0)
		{
			carry=carry+b.charAt(idx2--)-'0';
			sBuilder.append((char)(carry%2+'0'));
			carry=carry>>1;
		}
		if(carry==1)
		{
			sBuilder.append('1');
		}
		sBuilder.reverse();//反转一下结果
		return sBuilder.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String s1="11";
		String s2="1";
		System.out.println(s1+" + "+s2+" = "+solution.addBinary(s1, s2));
		s1="1010";
		s2="1011";
		System.out.println(s1+" + "+s2+" = "+solution.addBinary(s1, s2));
	}
}
