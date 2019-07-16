package longestSubstringWithoutRepeatingCharacters_3;

public class Solution 
{	
	public int lengthOfLongestSubstring(String s) 
	{
		int len;
		if(s==null || (len=s.length())==0)
			return 0;		
		int startIndex=0;//���Ӵ���ʼ����
		int maxLen=0;//���
		int tmpLen;
		//��¼ÿ���ַ����³��ֵ�����λ�ã���1��ʼ
		//�����ʼ��Ϊ0
		int[] charPosition=new int[128];
		for(int i=0;i<len;i++)
		{
			char c=s.charAt(i);
			//�����ظ��ַ������¼�¼���Ӵ���ʼλ��
			if(charPosition[c]>startIndex)
				startIndex=charPosition[c];
			//��ǰ�Ӵ��ĳ���
			tmpLen=i-startIndex+1;
			if(tmpLen>maxLen)
				maxLen=tmpLen;	
			//����ÿ�������ַ���λ��
			charPosition[c]=i+1;	
		}	
		return maxLen;        
    }

	public static void main(String[] args) 
	{
		String string;
		int len;
		Solution solution=new Solution();
		string="abcabcbb";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" �Ĳ��ظ��Ӵ���󳤶�= "+len);
		
		string="bbbbb";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" �Ĳ��ظ��Ӵ���󳤶�= "+len);
		
		string="pwwkew";
		len=solution.lengthOfLongestSubstring(string);
		System.out.println(string+" �Ĳ��ظ��Ӵ���󳤶�= "+len);	
	}
}
