import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopyFolder 
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
				System.out.println("文件夹不存在，请重新输入");
			else if (dirFile.isFile()) 
				System.out.println("这是文件，请输入文件夹路径");
			else 
				return dirFile;
		}
	}
	
	public static void copyFile(File src,File dest) throws IOException 
	{
		File newDir=new File(dest,src.getName());
		newDir.mkdir();
		File[]subFiles=src.listFiles();
		for(File subFile:subFiles)
		{
			if(subFile.isFile())
			{
				FileInputStream fis=new FileInputStream(subFile);
				FileOutputStream fos=new FileOutputStream(new File(newDir,subFile.getName()));
				byte[]arr=new byte[8192];
				int len;
				while((len=fis.read(arr))!=-1)
					fos.write(arr, 0, len);
				fis.close();
				fos.close();
			}
			else 
			{
				copyFile(subFile, newDir);
			}
		}		
	}

	public static void main(String[] args) throws IOException 
	{		
		File srcDir=getDir();
		File destDir=getDir();
		if(srcDir.equals(destDir))//避免无限复制
			System.out.println("目标文件夹与源文件夹相同，请重输");
		else 
			copyFile(srcDir, destDir);
	}
}
