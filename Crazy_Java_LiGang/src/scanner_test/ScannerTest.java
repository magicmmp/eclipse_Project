package scanner_test;
import java.util.Scanner;

public class ScannerTest {
	
	public static void main(String[] args) throws Exception{
		
		// ��ȡ�û�����ķ���1�������еķ�ʽ�������ݸ�����
		int n=0;
		System.out.println("����ʱ������ "+args.length+" �������в�����");
		for(String s:args)
		{
			System.out.println("����ĵ� "+n+++"�����ǣ�"+s);
		}
		
		// ��ȡ�û�����ķ���2��Scanner��ȡ��������
		Scanner scanner=new Scanner(System.in);
		while (scanner.hasNextInt()) {
			System.out.println("���������ˣ�"+scanner.nextInt());
			
		}
		System.out.println("�����벻������ʱ�����˳�����ѭ����");
		scanner.close();
		
		Runtime rtRuntime=Runtime.getRuntime();
		System.out.println(rtRuntime.toString());
	}
}
