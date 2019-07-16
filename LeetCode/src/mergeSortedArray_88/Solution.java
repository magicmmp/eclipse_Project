package mergeSortedArray_88;

import java.util.Arrays;

public class Solution {
	//从后往前比较
	public void merge(int[] nums1, int m, int[] nums2, int n) 
	{
		int p=m+n-1;
		n--;
		m--;
		while(m>=0 && n>=0)
		{
			if(nums1[m]>nums2[n])
				nums1[p--]=nums1[m--];
			else
				nums1[p--]=nums2[n--];
		}
		while(n>=0)
			nums1[p--]=nums2[n--];       
    }

	public static void main(String[] args) {
		//测试
		Solution solution = new Solution();
        int[] nums1 = new int[10];
        for (int i = 0; i < 5; ++i) 
        {
            nums1[i] = 2 * i;
        }
        int[] nums2 = new int[5];
        for (int i = 0; i < 5; ++i) 
        {
            nums2[i] = 2 * i + 1;
        }
        solution.merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));
        
	}
}
