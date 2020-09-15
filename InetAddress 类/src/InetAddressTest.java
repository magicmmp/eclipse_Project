import java.net.InetAddress;

public class InetAddressTest {

	public static void main(String[] args)
			throws Exception
		{
			// ��������������ȡ��Ӧ��InetAddressʵ��
			InetAddress ip = InetAddress.getByName("www.baidu.com");
			// �ж��Ƿ�ɴ�
			System.out.println("baidu�Ƿ�ɴ" + ip.isReachable(2000));
			// ��ȡ��InetAddressʵ����IP�ַ���
			System.out.println(ip.getHostAddress());
			// ����ԭʼIP��ַ����ȡ��Ӧ��InetAddressʵ��
			InetAddress local = InetAddress.getByAddress(
				new byte[]{127,0,0,1});
			System.out.println("�����Ƿ�ɴ" + local.isReachable(5000));
			// ��ȡ��InetAddressʵ����Ӧ��ȫ�޶�����
			System.out.println(local.getCanonicalHostName());
		}
}
