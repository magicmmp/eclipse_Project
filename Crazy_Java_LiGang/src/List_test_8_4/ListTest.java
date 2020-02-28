package List_test_8_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<String>();
		
		for(char i='A';i<'A'+10;i++)
		{
			String s="";
			for(char j=0;j<=i-'A';j++)
				s=s.concat(i+"");
			list.add(s);
		}
		//传入Lambda表达式，自定义  集合的排序方式
		list.sort((o1,o2)->(((String)o2).length()-((String)o1).length()));
			
		for(String string:list)
			System.out.println(string);
		Map<String, String> map=new HashMap<String, String>();
		map.merge(null, null, null);
	 

	}

}
