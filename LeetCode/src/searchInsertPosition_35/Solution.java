package searchInsertPosition_35;

import java.util.Arrays;

public class Solution {
	
	public int searchInsert(int[] nums, int target) 
    {
       int res=Arrays.binarySearch(nums, target);
        return res<0 ? -res-1:res;        
    }

}
