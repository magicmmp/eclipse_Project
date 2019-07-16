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
	//������
	public List<List<Integer>> levelOrderBottom(TreeNode root) 
	{
		List<List<Integer>> resultList=new LinkedList<>();
		if(root==null)
			return resultList;
		//��ǰ���ʲ�Ľ��
		LinkedList<TreeNode> curLevelNodes  = new LinkedList<>();
		//��һ��Ľ��
		LinkedList<TreeNode> nextLevelNodes;
		curLevelNodes.add(root);
		while(curLevelNodes.size()>0)
		{
			nextLevelNodes = new LinkedList<>();
			//��ǰ�����ʱ����
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
			//׼��������һ����
			curLevelNodes=nextLevelNodes;
		}	
		return resultList;        
    }
}
