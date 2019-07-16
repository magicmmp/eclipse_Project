package binaryTreeLevelOrderTraversal_107;

import java.util.LinkedList;
import java.util.List;

class TreeNode 
{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}

public class Solution {
	//迭代版
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
	{
		List<List<Integer>> resultList=new LinkedList<>();
		if(root==null)
			return resultList;
		//当前访问层的结点
		LinkedList<TreeNode> curLevelNodes  = new LinkedList<>();
		//下一层的结点
		LinkedList<TreeNode> nextLevelNodes;
		curLevelNodes.add(root);
		while(curLevelNodes.size()>0)
		{
			nextLevelNodes = new LinkedList<>();
			//当前层的临时数据
			LinkedList<Integer> levelData=new LinkedList<>();
			while(curLevelNodes.size()>0)
			{
				TreeNode node=curLevelNodes.removeFirst();
				levelData.add(node.val);
				if(node.left!=null)
					nextLevelNodes.add(node.left);
				if(node.right!=null)
					nextLevelNodes.add(node.right);
			}
			resultList.add(0, levelData);
			//准备访问下一层结点
			curLevelNodes=nextLevelNodes;
		}	
		return resultList;        
    }
}
