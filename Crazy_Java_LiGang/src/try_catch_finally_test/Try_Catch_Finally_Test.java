package try_catch_finally_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Try_Catch_Finally_Test {
	
	
	public static int fun() 
	{
		int step;
        try 
		{
           System.out.println("try��print���ǰ");
		   System.out.println(2/0);//�����֮��Ķ�����ִ��
		   System.out.println("try��print����");
		   step=2;
           return step;
		} 
		catch (Exception e) 
		{
			System.out.println("�����쳣��");
			e.printStackTrace();//��ӡ�쳣��Ϣ
			step=3;
			//ִ��return֮ǰ�����Ƿ���finally���о�ִ����return��
			return step;
		}
        //�˺�����try��catch���鶼Ҫ��return��䣬
        //�����Ƽ���finally��дreturn��䡣
		finally 
		{       
            step=4;  //����ı�����ķ���ֵ
			System.out.println("ִ��finally�ͷ���Դ");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("fun()��������ֵ= "+fun());
		
		

	}

}
