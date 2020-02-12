


/**
 * 简介：这是一个测试JavaDoc的类
 * @author pss
 * @version 2020.2.4
 */
public class JavaDocTest {
	
	/**
	 * 表示人名字
	 */
	protected String name;//怎么用不了此变量？
	
	void jump()
	{
		System.out.println("正在执行jump方法。");
	}
	
	void run(String...books)
	{
		for(String book :books)
			System.out.println(book);
		this.jump();
		System.out.println("正在执行run方法。");
	}

	/**
	 * 主方法，表示程序的入口
	 * @param args
	 */
	public static void main(String[] args) {
	
		int[] intArray=new int[5];
		for(int i=0;i<intArray.length;i++)
			intArray[i]=i*2;
		for(int e:intArray)
		{
			System.out.println(e);
		}
		
		JavaDocTest pDocTest=new JavaDocTest();
		pDocTest.run();
		
		
		
	}

}
