package GenericMethod_9_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethodTest {
	//to的元素类型是from元素的父类或相同类型
	public static <T> T test(Collection<T> from,Collection<? super T> to)
	{
		T lasT=null;
		for(T e:from)
		{
			lasT=e;
			to.add(e);
		}
		return lasT;//返回最后被复制的元素	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object>ao=new ArrayList<>();
		List<String>as=new ArrayList<>();
		//调用泛型方法
		test(as, ao);
	}
}
