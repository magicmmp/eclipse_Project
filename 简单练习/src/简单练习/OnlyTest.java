package ����ϰ;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//import java.text.SimpleDateFormat;

class Parent implements Runnable
{
	int i;
	public void f()
	{
		System.out.println("���Ǹ��� Parent");
		System.out.println("i="+i);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	//�ɱ��������������
	public void test(int ...arr)
	{
		System.out.println("������"+arr.length+"��Ԫ�أ�");
		for(int i : arr)
		{
			System.out.println(i);
		}
	}
}

class Child extends Parent
{
	int j;
	public void f()
	{
		System.out.println("�������� Child");
		System.out.println("i="+i+" ,j="+j);
	}
	
	
}




public class OnlyTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p=new Parent();
		p.i=1;
		Parent c=new Child();
		c.i=2;
		
	
		p.f();
		c.f();
		
		System.out.println("c.getClass() ="+c.getClass());
		
		p.test(1,2,3,4,5);
		p.test(new int[]{1,2});
		
		
		
		System.out.println();
	
		

	}

}
