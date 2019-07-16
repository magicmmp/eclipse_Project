package plusOne_66;

public class Solution {
	
public int[] plusOne(int[] digits) 
{
	int idx=digits.length-1;
	if(digits[idx]<9)
	{
		++digits[idx];
	}
	else 
	{
		do 
		{
			digits[idx--]=0;
		} 
		while (idx>=0 && digits[idx]==9);
		
		if(digits[0]!=0)
		{
			++digits[idx];
		}
		else 
		{
			digits=new int[digits.length+1];
			digits[0]=1;
		}
	}	
	return digits;     
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		int[]digits = solution.plusOne(new int[]{9,9,9});
		for (int i : digits) 
		{
			System.out.print(i+" ");
		}
		
		
				

	}

}
