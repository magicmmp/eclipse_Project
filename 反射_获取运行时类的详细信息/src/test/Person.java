package test;

public class Person {
	public String name;
	private int age;
	
	private void info_1()
	{
		System.out.println("my name is "+ name+", age is "+age);
	}
	
	public String info_2()
	{
		info_1();
		return name;
	}

}
