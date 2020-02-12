package abstract_class_test;

//����һ����״�ĳ�����
public abstract class Shape 
{
	private String color;
	
	
	

	//������Ĺ��캯�������������౻����
	public Shape() {}
	//������Ĺ��캯�������������౻����
	public Shape(String color) 
	{
		this.color = color;
	}

	public String getColor() 
	{
		return color;
	}
	
	//�����ܳ��ĳ��󷽷���������ʵ��
	public abstract double getPerimeter();
	//����ͼ�ε�����
	public abstract String getType();
	
	

	public void setColor(String color) 
	{
		this.color = color;
	}

}
