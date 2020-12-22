import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class MySocketThread extends Thread{
	Socket socket;
	int threadNo;
	public MySocketThread(Socket socket,int threadNo)
	{
		super();
		this.socket=socket;
		this.threadNo=threadNo;
	}
	
	@Override
	public void run() 
	{
		try
		{
			BufferedReader br = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintStream ps = new PrintStream(socket.getOutputStream());
			
			while(true)
			{
				String line = br.readLine();
				if(line==null)
					break;
				 System.out.println("�߳�"+threadNo+" �յ���"+line);
				 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
					//1������ת�ַ���  
				Calendar calendar = Calendar.getInstance(); 
			    Date date = calendar.getTime();  
			    String dateStringParse = sdf.format(date);  
			    
				line=dateStringParse+" �߳�"+threadNo+" Server received: "+line;
				//��ת�ͻ��˷����ľ���
				//line = new StringBuilder(line).reverse().toString();
				try {
					sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				ps.println(line);
			}		
		} 
		catch (IOException e) 
		{	
			e.printStackTrace();
		}
		finally
		{
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�߳�"+threadNo+" �˳���");
	}
}



public class TCP_Server_MultiThread 
{
	public static void main(String[] args) 
			throws IOException 
	{
		
		
		
		
		try(ServerSocket server = new ServerSocket(8086))
		{
			System.out.println("����������,��8086�˿�");
			int threadNo=1;
			while(true) 
			{
				Socket socket=server.accept();
				MySocketThread mySocketThread=new MySocketThread(socket,threadNo++); 
				mySocketThread.start();
			}
			
		}
		
	}
}
