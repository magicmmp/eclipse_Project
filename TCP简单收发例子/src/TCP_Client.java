
import java.awt.desktop.ScreenSleepEvent;
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
		Socket socket = new Socket("127.0.0.1", 8086);
		BufferedReader br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		PrintStream ps = new PrintStream(socket.getOutputStream());
		Scanner sc = new Scanner(System.in);
		//将键盘录入的字符串写到服务器
		
		//ps.println(sc.nextLine());	
		int N=0;
		while(N++<100)
		{
			ps.println("客户端发送"+N);	
			//将反转后的结果打印
			System.out.println(br.readLine());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		socket.close();
		sc.close();
	}
}
