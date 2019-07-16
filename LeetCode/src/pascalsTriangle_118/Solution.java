package pascalsTriangle_118;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
	public List<List<Integer>> generate(int numRows) 
	{
		if(numRows==0)
			return Collections.emptyList();
		List<List<Integer>> list=new ArrayList<>();
		for(int i=0;i<numRows;i++)
		{
			List<Integer> curRow=new ArrayList<>();
			for(int j=0;j<=i;j++)
			{
				if(j==0||j==i)
					curRow.add(1);
				else 
				{
					List<Integer> upLow=list.get(i-1);
					curRow.add(upLow.get(j-1)+upLow.get(j));
				}
			}
			list.add(curRow);
		}
		return list;        
    }
}
