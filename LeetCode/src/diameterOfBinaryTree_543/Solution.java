package diameterOfBinaryTree_543;


class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution 
{
	private int max=0;//结果
	private int tmp;//临时值
	
	public int diameterOfBinaryTree(TreeNode root) 
	{
		helper(root);
		return max;		
    }
	//返回从当前结点开始，到叶子结点大最长路径
	private int helper(TreeNode root) {
		if(root==null)
			return 0;
		int leftLength=helper(root.left);
		//计算右子树的最长路径
		int rightLength=helper(root.right);
		tmp=leftLength+rightLength;
		if(tmp>max)
			max=tmp;//更新结果max
		return Math.max(leftLength, rightLength)+1;
	}
}
