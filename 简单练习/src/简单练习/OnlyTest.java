package 简单练习;


class Parent implements Runnable
{
	int i;
	public void f()
	{
		System.out.println("我是父类 Parent");
		System.out.println("i="+i);
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}

class Child extends Parent
{
	int j;
	public void f()
	{
		System.out.println("我是子类 Child");
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
	
		

	}

}
