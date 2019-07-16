package pascalsTriangle2_119;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public List<Integer> getRow(int rowIndex) 
	{
		//行数从0算起
		List<Integer> list=new ArrayList<>();
		for(int i=0;i<=rowIndex;i++)
		{
			list.add(1);//在末尾增加元素1
			for(int j=i-1;j>0;j--)
			{
				list.set(j, list.get(j)+list.get(j-1));
			}
		}		
		return list;
    }
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution=new Solution();
		System.out.println(solution.getRow(3).toString());
	}

}
