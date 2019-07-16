package balancedBinaryTree_110;

class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution 
{	
	public boolean isBalanced(TreeNode root) 
	{
		return TreeHeight(root)!=-1;       
    }
	
	private int TreeHeight(TreeNode root)
	{
		if(root==null)
			return 0;
		int leftHeight=TreeHeight(root.left);
		if(leftHeight==-1)
			return -1;
		int rightHeight=TreeHeight(root.right);
		if(rightHeight==-1)
			return -1;
		if(Math.abs(leftHeight-rightHeight)>1)
			return -1;
		return 1+Math.max(leftHeight, rightHeight);
	}	
}
