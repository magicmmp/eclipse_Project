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
		//�����һ��Ϊ��ָ��
		if(p==null || q==null)
			return p==q;
		//�����Ӧ�ڵ��ֵ����ȣ����ؼ�
		if(p.val!=q.val)
			return false;
		//�ٱȽ����������Ƿ����
		return isSameTree(p.left, q.left)&&isSameTree(p.right, q.right);        
    }
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
