package removeDuplicatesFromSortedArray_26;

public class Solution {
	
	public int removeDuplicates(int[] nums) 
    {
		if(nums.length<=1)
			return nums.length;
		int tails=1;
		for(int i=1;i<nums.length;i++)
		{
			if(nums[i-1]!=nums[i])
			{
				nums[tails++]=nums[i];
			}
		}
		return tails; 
    }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
