
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCP_Client {
	
	public static void main(String[] args) 
			throws UnknownHostException, IOException 
	{
		Socket socket = new Socket("127.0.0.1", 54321);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		//������¼����ַ���д��������
		ps.println(sc.nextLine());	
		//����ת��Ľ����ӡ
		System.out.println(br.readLine());	
		socket.close();
	}
}
