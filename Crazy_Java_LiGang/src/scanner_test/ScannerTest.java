package scanner_test;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) throws Exception{
		
		// 获取用户输入的方法1：命令行的方式传入数据给程序
		int n=0;
		System.out.println("运行时传入了 "+args.length+" 个命令行参数：");
		for(String s:args)
		{
			System.out.println("输入的第 "+n+++"参数是："+s);
		}
		
		// 获取用户输入的方法2：Scanner获取键盘输入
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNextInt()) {
			System.out.println("键盘输入了："+scanner.nextInt());
			
		}
		System.out.println("当输入不是整数时，会退出输入循环。");
		scanner.close();
		
		Runtime rtRuntime=Runtime.getRuntime();
		System.out.println(rtRuntime.toString());
	}
}
