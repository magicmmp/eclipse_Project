package exception_test_10_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

class Test
{
	static int value=10;
	static void fun()
	{
		System.out.println("这是一个类方法");
	}
	void fun2()
	{
		System.out.println("这是一个实例方法");
	}
	
}


public class NullPointerExceptionTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test test=null;
		FileOutputStream fileOutputStream=new FileOutputStream("测试生成的文件");
		fileOutputStream.write('中');
		fileOutputStream.close();
		
		try {
			test.fun();
		} 
		catch (NullPointerException e) {
			//System.out.println("空指针异常");
			e.getMessage();
		}
		catch (Exception e) {
			System.out.println("未知异常");
		}

	}

}
