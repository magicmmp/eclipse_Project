//����һ������ʱ���ģ����
abstract class GetTime 
{
	//��final���̶�����ʱ����㷨�����������޸�
	public final long getTime() 
	{
		long start = System.currentTimeMillis();				//��¼��ʼʱ��
		code();
		long end = System.currentTimeMillis();					//��¼����ʱ��
		
		return end - start;
	}
	
	//��������Եķ��������ఴ��Ҫ����
	public abstract void code();	
}

//����һ����������
class Demo extends GetTime 
{
	@Override
	//��д��Ҫ����ʱ��ķ���
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
	//���Խ��
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
	//Size������4������ֵ����ʼ��ʱ����һ���ַ�����Ϊ��д
	//Ҫд��ö���ඨ�����ǰ��
	SMALLf("S"), MEDIUM("M") , LARGE("L") , EXTRA_LARGE("XL");
	//��¼ö��ֵ����д
	private String abbreviation;
	//ö����Ĺ��캯��������private
	private Size(String abbreviation) 
	{ 
		this.abbreviation = abbreviation; 
	}
	public String getAbbreviation() 
	{ 
		return abbreviation; 
	}
}








