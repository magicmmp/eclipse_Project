package System_and_Runtime_test;

import java.util.Date;

public class System_and_Runtime_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("��������JAVA_HOME��ֵ= "+System.getenv("JAVA_HOME"));
		System.out.println("����ϵͳ������= "+System.getProperty("os.name"));
		
		Runtime runtime=Runtime.getRuntime();
		System.out.println("����������= "+runtime.availableProcessors());
		System.out.println("���ڴ���    = "+runtime.totalMemory());
		
		String string="abc��";
		char[] cc=string.toCharArray();
		for(char c:cc)
		{
			System.out.println(c);
		}
		
		Date date=new Date();
		System.out.println(date);
		System.out.println(date.getTime());
		
		
	}
}
