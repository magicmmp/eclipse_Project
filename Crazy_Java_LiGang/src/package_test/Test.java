package package_test;

//这个类属于包my_package
public class Test 
{
	public String toString()
	{
		return "我已经改写了Object的toString()方法。";
	}
	
	public static void main(String[] args) 
	{
		Object object=new Test();
		System.out.println(object.toString());
		
	}
}
