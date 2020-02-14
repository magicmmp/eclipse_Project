
interface Eatable
{
	void taste();
}

interface Addable
{
	int add(int a,int b);
}

public class LambdaTest {

	//���ø÷�����ҪEatable����
	public void eat(Eatable e)
	{
		e.taste();
	}
	
	public void testAdd(Addable add)
	{
		int a=5,b=3;
		//Ҫ�ر�ע�����  ���ε�Lambda���ʽ�����ʹ�õ�?
		System.out.println("5��3�ĺ��ǣ�"+add.add(a, b));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LambdaTest lambdaTest=new LambdaTest();
		lambdaTest.eat(()->System.out.println("ƻ����óԣ�"));
		//��Lambda���ʽʵ����һ��Addable�ӿڵ������ڲ��࣬����������
		lambdaTest.testAdd( (a,b)->a+b);
	}
}
