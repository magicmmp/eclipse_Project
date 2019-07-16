package symmetricTree_101;

import java.util.LinkedList;


  class TreeNode 
  {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }


public class Solution {
	
	public boolean isSymmetric(TreeNode root) 
	{
		if(root==null)
			return true;
		//list当做先进先出的队列使用
		LinkedList<TreeNode> list=new LinkedList<>();
		list.add(root.left);//添加在列表后面
		list.add(root.right);
		TreeNode left;
		TreeNode right;
		while (list.size()>1) 
		{
			left=list.removeFirst();
			right=list.removeFirst();
			if(left==null && right==null)
				continue;
			if (left==null || right==null) 
				return false;
			if(left.val!=right.val)
				return false;
			list.add(left.left);
			list.add(right.right);
			list.add(left.right);
			list.add(right.left);	
		}		
		return true;        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> list=new LinkedList<Integer>();
		for(int i=0;i<10;i++)
			list.add(i);
		while(list.size()>0)
		{
			int i=list.pop();
			System.out.println(i);
		}
	}

}
