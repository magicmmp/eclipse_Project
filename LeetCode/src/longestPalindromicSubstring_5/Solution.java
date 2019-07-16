package longestPalindromicSubstring_5;

public class Solution {

	/**
	 * ��̬�滮�ⷨ
	 * ��һ����ά����isPalindrome����Ϊ����¼����¼������Ľ�����Ա��ظ��ļ��㡣
	 * ��Ҳ�Ƕ�̬�滮�ľ������ڡ����������������㷨���Ӷ�Ҳ��O(n^2)
	 */
	public String longestPalindrome(String s) 
	{
		if(s==null || s.length()==0)
			return "";
		int len=s.length();
		int startIndex=0;//s�����Ӵ�����ʼ�±�
		int maxLen=1;//�����Ӵ�����󳤶�
		//��ά�����¼��������
		//isPalindrome[i][j]Ϊtrue��ʾ�ַ���i��j���Ӵ��ǻ����Ӵ�
		boolean [][]isPalindrome=new boolean[len][len];
		//��ʼ������¼���ⳤ��Ϊ1��2���Ӵ����
		for(int i=0;i<len;i++)
		{
			isPalindrome[i][i]=true;
			if(i<len-1 && s.charAt(i)==s.charAt(i+1))
			{
				isPalindrome[i][i+1]=true;
				startIndex=i;
				maxLen=2;
			}
		}
		//L���Ӵ�����
		for(int L=3;L<=len;L++)
		{
			//i��ö���Ӵ�����ʼ��
			for(int i=0;i<len-L+1;i++)
			{
				int endIndex=i+L-1;//ö���Ӵ��յ�
				if(s.charAt(i)==s.charAt(endIndex) 
					&& isPalindrome[i+1][endIndex-1])
				{
					isPalindrome[i][endIndex]=true;
					startIndex=i;
					maxLen=L;
				}
			}
		}
				
		return s.substring(startIndex, startIndex+maxLen);
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
