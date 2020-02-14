
interface Eatable
{
	void taste();
}

interface Addable
{
	int add(int a,int b);
}

public class LambdaTest {

	//调用该方法需要Eatable对象
	public void eat(Eatable e)
	{
		e.taste();
	}
	
	public void testAdd(Addable add)
	{
		int a=5,b=3;
		//要特别注意理解  带参的Lambda表达式是如何使用的?
		System.out.println("5和3的和是："+add.add(a, b));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaTest lambdaTest=new LambdaTest();
		lambdaTest.eat(()->System.out.println("苹果真好吃！"));
		//此Lambda表达式实现了一个Addable接口的匿名内部类，并产生对象
		lambdaTest.testAdd( (a,b)->a+b);
	}
}
