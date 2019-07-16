import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDP_MultiThread_Send_And_Receive 
{
	public static void main(String[] args) 
	{
		//创建接受数据线程
		new Receive().start();
		//创建发送数据线程
		new Send().start();
	}
}

class Receive extends Thread 
{
	public void run() 
	{
		try 
		{	//创建UDP socket
			DatagramSocket socket = new DatagramSocket(6666);
			//创建packet来接收数据
			DatagramPacket packet = new DatagramPacket(new byte[1024], 1024);			
			while(true) 
			{
				socket.receive(packet);												//接收货物
				byte[] arr = packet.getData();
				int len = packet.getLength();
				//获取数据包的IP地址
				String ip = packet.getAddress().getHostAddress();
				System.out.println(ip + ":" + new String(arr,0,len));
			}
		} 
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
}

class Send extends Thread 
{
	public void run() 
	{
		try 
		{
			//创建UDP socket
			DatagramSocket socket = new DatagramSocket();
			Scanner sc = new Scanner(System.in);			
			while(true) 
			{
				//从键盘接受输入
				String str = sc.nextLine();
				if("quit".equals(str))
					break;
				//创建发送数据包packet
				DatagramPacket packet = new DatagramPacket(str.getBytes(), 
				    str.getBytes().length, InetAddress.getByName("127.0.0.1"), 6666);
				socket.send(packet);//发送数据包
			}
			socket.close();
		}  
		catch (IOException e) 
		{			
			e.printStackTrace();
		}
	}
}
