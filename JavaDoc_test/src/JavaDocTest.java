


/**
 * ��飺����һ������JavaDoc����
 * @author pss
 * @version 2020.2.4
 */
public class JavaDocTest {
	
	/**
	 * ��ʾ������
	 */
	protected String name;//��ô�ò��˴˱�����
	
	void jump()
	{
		System.out.println("����ִ��jump������");
	}
	
	void run(String...books)
	{
		for(String book :books)
			System.out.println(book);
		this.jump();
		System.out.println("����ִ��run������");
	}

	/**
	 * ����������ʾ��������
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
