package package_test;

//��������ڰ�my_package
public class Test 
{
	public String toString()
	{
		return "���Ѿ���д��Object��toString()������";
	}
	
	public static void main(String[] args) 
	{
		Object object=new Test();
		System.out.println(object.toString());
		
	}
}
