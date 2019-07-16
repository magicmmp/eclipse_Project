import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server_MultiThread 
{
	public static void main(String[] args) 
			throws IOException 
	{
		ServerSocket server = new ServerSocket(54321);
		System.out.println("����������,��54321�˿�");
		
		while(true) 
		{
			final Socket socket = server.accept();
			new Thread() 
			{
				public void run() 
				{
					try 
					{
						BufferedReader br = new BufferedReader(
								new InputStreamReader(socket.getInputStream()));
						PrintStream ps = new PrintStream(socket.getOutputStream());
						
						String line = br.readLine();
						//��ת�ͻ��˷����ľ���
						line = new StringBuilder(line).reverse().toString();
						ps.println(line);
						//�ر���������
						socket.close();
					} 
					catch (IOException e) 
					{	
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
}
