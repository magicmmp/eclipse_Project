package Generic_9_1;

import java.util.ArrayList;
import java.util.List;

import abstract_class_test.Shape;

class Apple<T extends Number>
{
	//static T info;//����
	T  age;  //��ȷ
	
	void getAge(List<? extends Shape> list ) {};
	
	public static void main(String[] args)
	{
		//��ȷ��Integer����Number������
		Apple<Integer> ai=new Apple();
		//����String����Number������
		//Apple<String> as=new Apple();
	}
}


public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		

	}

}
