package try_catch_finally_test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Try_Catch_Finally_Test {
	
	
	public static int fun() 
	{
		int step;
        try 
		{
           System.out.println("try块print语句前");
		   System.out.println(2/0);//此语句之后的都不被执行
		   System.out.println("try块print语句后");
		   step=2;
           return step;
		} 
		catch (Exception e) 
		{
			System.out.println("发生异常了");
			e.printStackTrace();//打印异常信息
			step=3;
			//执行return之前会检查是否有finally，有就执行再return。
			return step;
		}
        //此函数的try和catch语句块都要有return语句，
        //但不推荐在finally里写return语句。
		finally 
		{       
            step=4;  //不会改变上面的返回值
			System.out.println("执行finally释放资源");
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("fun()方法返回值= "+fun());
		
		

	}

}
