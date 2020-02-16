package System_and_Runtime_test;

import java.util.Date;

public class System_and_Runtime_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("环境变量JAVA_HOME的值= "+System.getenv("JAVA_HOME"));
		System.out.println("操作系统的名称= "+System.getProperty("os.name"));
		
		Runtime runtime=Runtime.getRuntime();
		System.out.println("处理器数量= "+runtime.availableProcessors());
		System.out.println("总内存数    = "+runtime.totalMemory());
		
		String string="abc我";
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
