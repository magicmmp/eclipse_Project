import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reflect 
{
	/**
	 * ե֭��(Juicer)ե֭�İ���
	 * �ֱ���ˮ��(Fruit)ƻ��(Apple)�㽶(Banana)����(Orange)ե֭(squeeze)
	 */
	public static void main(String[] args) throws IOException, 
	ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		//����ե֭������
		Juicer j = new Juicer();
		//��ȡ�����ļ�
		BufferedReader br = new BufferedReader(
			new FileReader("config.properties"));
			//�������ļ���������ȡ����	
		Class<?> clazz = Class.forName(br.readLine());
		br.close();
		//ͨ��������ֽ�����󴴽��������
		//����ת��Ϊ�����ӿ�
		Fruit f = (Fruit) clazz.newInstance();
		j.run(f);
	}
}

//ˮ���ӿ�
interface Fruit 
{
	//ˮ��������ե֭
	public void squeeze();
}

class Apple implements Fruit 
{
	@Override
	public void squeeze() 
	{
		System.out.println("ե��һ��ƻ��֭��");
	}	
}

class Orange implements Fruit 
{
	@Override
	public void squeeze() 
	{
		System.out.println("ե��һ������֭��");
	}
}
//ե֭��
class Juicer 
{
	public void run(Fruit f) 
	{
		f.squeeze();
	}
}