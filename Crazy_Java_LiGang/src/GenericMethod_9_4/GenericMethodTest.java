package GenericMethod_9_4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenericMethodTest {
	//to��Ԫ��������fromԪ�صĸ������ͬ����
	public static <T> T test(Collection<T> from,Collection<? super T> to)
	{
		T lasT=null;
		for(T e:from)
		{
			lasT=e;
			to.add(e);
		}
		return lasT;//������󱻸��Ƶ�Ԫ��	
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Object>ao=new ArrayList<>();
		List<String>as=new ArrayList<>();
		//���÷��ͷ���
		test(as, ao);
	}
}
