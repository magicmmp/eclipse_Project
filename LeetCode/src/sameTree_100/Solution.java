package sameTree_100;

class TreeNode 
{
	  int val;
	  TreeNode left;
	  TreeNode right;
	  TreeNode(int x) 
	  { 
		  val = x; 
	   }
}

public class Solution {
	
	public boolean isSameTree(TreeNode p, TreeNode q) 
	{
		//如果有一个为空指针
		if(p==null || q==null)
			return p==q;
		//如果对应节点的值不相等，返回假
		if(p.val!=q.val)
			return false;
		//再比较左右子树是否相等
		return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);        
    }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
