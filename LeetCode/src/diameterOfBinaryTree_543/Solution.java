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
	private int max=0;//���
	private int tmp;//��ʱֵ
	
	public int diameterOfBinaryTree(TreeNode root) 
	{
		helper(root);
		return max;		
    }
	//���شӵ�ǰ��㿪ʼ����Ҷ�ӽ����·��
	private int helper(TreeNode root) {
		if(root==null)
			return 0;
		int leftLength=helper(root.left);
		//�������������·��
		int rightLength=helper(root.right);
		tmp=leftLength+rightLength;
		if(tmp>max)
			max=tmp;//���½��max
		return Math.max(leftLength, rightLength)+1;
	}
}
