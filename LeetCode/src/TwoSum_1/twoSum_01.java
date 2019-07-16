package TwoSum_1;
import java.util.Arrays;
import java.util.HashMap;

public class twoSum_01 {
	
 int[] twoSum (int[] nums, int target) 
 {
	 
	 int len=nums.length;
	 HashMap<Integer,Integer> map=new HashMap<>();
	 for(int i=0;i<len;i++)
	 {
		 Integer idx = map.get(target-nums[i]);
		 if(idx != null)
		 {
			 return new int[] {idx,i};
		 }
		 map.put(nums[i], i);
	 }
	 	return null;
}
	
	public static void main(String[] args) {
		twoSum_01 tSum_01=new twoSum_01();
		int[] arr=new int[] {3,2, 7, 11, 15};
		int target=9;
		System.out.println(Arrays.toString(tSum_01.twoSum(arr, target)));

	}

	
}
