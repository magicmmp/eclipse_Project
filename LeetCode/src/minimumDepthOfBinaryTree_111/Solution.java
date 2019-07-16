package minimumDepthOfBinaryTree_111;

import java.util.LinkedList;

import binaryTreeLevelOrderTraversal_107.TreeNode;

class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
public class Solution 
{
	public int minDepth(TreeNode root) 
	{
		if(root==null)
			return 0;
		int levelNum=0;
		//当前访问层的结点
		LinkedList<TreeNode> NodeList  = new LinkedList<>();
		NodeList.add(root);
		while(!NodeList.isEmpty())
		{
			levelNum++;//层数加1
			int len=NodeList.size();
			for(int i=0;i<len;i++)
			{
				TreeNode node=NodeList.remove();
				if(node.left==null && node.right==null)
					return levelNum;
				if(node.left!=null)
					NodeList.add(node.left);
				if(node.right!=null)
					NodeList.add(node.right);
			}		
		}			
		return levelNum;        
    }
}
