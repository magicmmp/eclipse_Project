package lengthOfLastWord_58;

public class Solution {
	
	public int lengthOfLastWord(String s) 
	{
		int len=0;
		int idx=s.length()-1;
		//先忽略字符串末尾的空格
		while (idx>=0 && s.charAt(idx)==' ') 
		{
			idx--;
		}
		//计算最后一个单词的长度
		while (idx>=0 && s.charAt(idx)!=' ') 
		{
			len++;
			idx--;
		}		
		return len;        
    }
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string="Hello World";
		Solution solution=new Solution();
		System.out.println(solution.lengthOfLastWord(string));

	}

}
