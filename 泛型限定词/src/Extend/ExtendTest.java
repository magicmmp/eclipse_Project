package Extend;

import java.util.ArrayList;

import Person_Bean.Person;
import Worker_Bean.Worker;

public class ExtendTest {

	public static void main(String[] args) {

		ArrayList<Person> list1=new ArrayList<>();
		list1.add(new Person(80, "张三丰"));
		list1.add(new Person(20, "王重阳"));
		
		//Person是Worker的父类
		ArrayList<Worker> list2=new ArrayList<>();
		list2.add(new Worker(20, "李莫愁", 5000));
		// 这是<? extends E>，list1可以添加list2
		list1.addAll(list2);
		
		
	}

}
