package 删除文件夹;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Properties;
import java.util.Scanner;

public class FolderDelete{

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
	
	public static void deleteFile(File dir) 
	{
		File[]subFiles=dir.listFiles();
		for (File subFile : subFiles) 
		{
			if(subFile.isFile())
				subFile.delete();
			else
				deleteFile(subFile);	
		}
		dir.delete();//删除当前空文件夹	
	}
	
	public static void main(String[] args) throws IOException {
		//File dirFile=getDir();//获取文件夹路径
		//deleteFile(dirFile);//递归删除文件夹

		



	}
}






































