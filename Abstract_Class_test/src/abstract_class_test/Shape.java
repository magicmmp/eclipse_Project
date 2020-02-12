package abstract_class_test;

//定义一个形状的抽象类
public abstract class Shape 
{
	private String color;
	
	
	

	//抽象类的构造函数，用于在子类被调用
	public Shape() {}
	//抽象类的构造函数，用于在子类被调用
	public Shape(String color) 
	{
		this.color = color;
	}

	public String getColor() 
	{
		return color;
	}
	
	//计算周长的抽象方法，在子类实现
	public abstract double getPerimeter();
	//返回图形的类型
	public abstract String getType();
	
	

	public void setColor(String color) 
	{
		this.color = color;
	}

}
