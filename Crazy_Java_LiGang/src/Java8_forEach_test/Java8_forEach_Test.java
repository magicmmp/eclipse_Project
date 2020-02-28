package Java8_forEach_test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Java8_forEach_Test {

	public static void main(String[] args) {
		
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");

		Iterator iterator=items.iterator();
		while(iterator.hasNext())
		{
			String  book=(String)iterator.next();
			System.out.println(book);
			//删除上次iterator.next()返回的元素
			if(book.equals("B"))
				iterator.remove();
		}
		System.out.println(items);
	}
}
