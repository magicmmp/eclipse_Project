package 计算文件夹大小;

import java.io.File;
import java.util.Scanner;

public class getDirSize 
{
	public static File getDir() 
	{
		Scanner scanner=new Scanner(System.in);
		System.out.println("请输入文件夹路径：");
		while (true) 
		{
			String line=scanner.nextLine();
			File dirFile=new File(line);
			if(!dirFile.exists())
			{
				System.out.println("文件夹不存在，请重新输入");
			}
			else if (dirFile.isFile()) 
			{
				System.out.println("这是文件，请输入文件夹路径");
			}
			else {
				return dirFile;
			}
		}
	}
	
	public static long getFileLen(File dir) 
	{
		long len=0;
		File[]subFiles=dir.listFiles();
		for(File subFile:subFiles)
		{
			if(subFile.isFile())
			{
				len=len+subFile.length();
			}
			else 
			{
				len=len+getFileLen(subFile);
			}
		}
		return len;
	}
	
	
	

	public static void main(String[] args) {
		
		File dirFile=getDir();//获取文件夹路径
		//计算文件夹大小
		System.out.println("该文件夹大小： "+getFileLen(dirFile));
	}
}
