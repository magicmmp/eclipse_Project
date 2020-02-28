package Generic_9_1;

import java.util.ArrayList;
import java.util.List;

import abstract_class_test.Shape;

class Apple<T extends Number>
{
	//static T info;//错误
	T  age;  //正确
	
	void getAge(List<? extends Shape> list ) {};
	
	public static void main(String[] args)
	{
		//正确，Integer不是Number的子类
		Apple<Integer> ai=new Apple();
		//错误，String不是Number的子类
		//Apple<String> as=new Apple();
	}
}


public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list=new ArrayList<>();
		

	}

}
