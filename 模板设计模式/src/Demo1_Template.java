//定义一个测试时间的模板类
abstract class GetTime 
{
	//用final来固定测试时间的算法，不让子类修改
	public final long getTime() 
	{
		long start = System.currentTimeMillis();				//记录开始时间
		code();
		long end = System.currentTimeMillis();					//记录结束时间
		
		return end - start;
	}
	
	//具体待测试的方法在子类按需要定义
	public abstract void code();	
}

//定义一个具体子类
class Demo extends GetTime 
{
	@Override
	//重写需要测试时间的方法
	public void code() 
	{
		int i = 0;
		while(i < 1000000) 
		{
			System.out.println("x");
			i++;
		}
	}
}

public class Demo1_Template 
{
	//测试结果
	public static void main(String[] args) 
	{
		//Demo d = new Demo();
		//System.out.println(d.getTime());
		Size size=Size.LARGE;
		System.out.println("abbreviation=" + size.getAbbreviation());
		
	}
}

enum Size
{
	//Size类型有4个常量值，初始化时传入一个字符串作为缩写
	//要写在枚举类定义的最前面
	SMALLf("S"), MEDIUM("M") , LARGE("L") , EXTRA_LARGE("XL");
	//记录枚举值得缩写
	private String abbreviation;
	//枚举类的构造函数必须是private
	private Size(String abbreviation) 
	{ 
		this.abbreviation = abbreviation; 
	}
	public String getAbbreviation() 
	{ 
		return abbreviation; 
	}
}








