package maximumSubarray_53;

public class Solution {	
	public int maxSubArray(int[] nums) 
	{
		int maxSum=nums[0];
		int tmp=nums[0];//记录当前索引为结尾的子序和
		for(int i=1;i<nums.length;i++)
		{
			tmp=nums[i]+ (tmp>0?tmp:0);
			if(tmp>maxSum)
				maxSum=tmp;
		}		
		return maxSum;  
    }	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		int[]nums= {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(solution.maxSubArray(nums));
	}
}
