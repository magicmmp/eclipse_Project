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
		System.out.println("����һ���෽��");
	}
	void fun2()
	{
		System.out.println("����һ��ʵ������");
	}
	
}


public class NullPointerExceptionTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Test test=null;
		FileOutputStream fileOutputStream=new FileOutputStream("�������ɵ��ļ�");
		fileOutputStream.write('��');
		fileOutputStream.close();
		
		try {
			test.fun();
		} 
		catch (NullPointerException e) {
			//System.out.println("��ָ���쳣");
			e.getMessage();
		}
		catch (Exception e) {
			System.out.println("δ֪�쳣");
		}

	}

}
