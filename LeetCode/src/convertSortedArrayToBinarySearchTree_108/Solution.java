package convertSortedArrayToBinarySearchTree_108;

class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution 
{
	public TreeNode sortedArrayToBST(int[] nums) 
	{
		if(nums==null || nums.length==0)
			return null;
		
		return findRootFromArray(nums, 0, nums.length-1);
    }

	private TreeNode findRootFromArray(int[] nums,int left,int right)
	{
		if(left>right)
			return null;
		int mid=(left+right)>>>1;
		TreeNode root=new TreeNode(nums[mid]);
		root.left=findRootFromArray(nums, left, mid-1);
		root.right=findRootFromArray(nums, mid+1, right);		
		return root;
	}
}
