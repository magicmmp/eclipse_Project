import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Reflect 
{
	/**
	 * 榨汁机(Juicer)榨汁的案例
	 * 分别有水果(Fruit)苹果(Apple)香蕉(Banana)桔子(Orange)榨汁(squeeze)
	 */
	public static void main(String[] args) throws IOException, 
	ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		//生成榨汁机对象
		Juicer j = new Juicer();
		//读取配置文件
		BufferedReader br = new BufferedReader(
			new FileReader("config.properties"));
			//将配置文件的类名读取出来	
		Class<?> clazz = Class.forName(br.readLine());
		br.close();
		//通过该类的字节码对象创建该类对象
		//类型转换为父类或接口
		Fruit f = (Fruit) clazz.newInstance();
		j.run(f);
	}
}

//水果接口
interface Fruit 
{
	//水果可用于榨汁
	public void squeeze();
}

class Apple implements Fruit 
{
	@Override
	public void squeeze() 
	{
		System.out.println("榨出一杯苹果汁儿");
	}	
}

class Orange implements Fruit 
{
	@Override
	public void squeeze() 
	{
		System.out.println("榨出一杯桔子汁儿");
	}
}
//榨汁机
class Juicer 
{
	public void run(Fruit f) 
	{
		f.squeeze();
	}
}