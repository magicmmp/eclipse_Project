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
		System.out.println("服务器启动,绑定54321端口");
		
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
						//反转客户端发来的句子
						line = new StringBuilder(line).reverse().toString();
						ps.println(line);
						//关闭这条连接
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
