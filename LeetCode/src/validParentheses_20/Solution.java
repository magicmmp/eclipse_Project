package validParentheses_20;

public class Solution {	
	public boolean isValid(String s) {
		//用数组模拟栈的行为
		char stack[]=new char[s.length()+1];
		char Str[]=s.toCharArray();
		int idx=1;
		for (char c : Str) 
		{
			//遇到左边的括号存入
			if(c=='['||c=='('||c=='{') 
			{
				stack[idx++]=c;
			}
			//遇到右边的括号弹出并且比较
			else if(c==']' && stack[--idx]!='[')
				return false;
			else if(c==')' && stack[--idx]!='(')
				return false;
			else if(c=='}' && stack[--idx]!='{')
				return false;
		}
		return idx==1;
    }
	public static void main(String[] args) {
		Solution solution=new Solution();
		String string="()";
		System.out.println(string+" : "+solution.isValid(string));
		string="()[]{}";
		System.out.println(string+" : "+solution.isValid(string));
		string="(]";
		System.out.println(string+" : "+solution.isValid(string));
		string="{[]}";
		System.out.println(string+" : "+solution.isValid(string));
		
		try 
		{
			System.out.println(2/0);
		} 
		catch (Exception e) 
		{
			System.out.println("发生异常了");
			//执行return之前会检查是否有finally，有就执行再return。
			return;
		}
		finally 
		{
			System.out.println("执行finally释放资源");
		}
		
		
		
		
		
		
		
	}
}
