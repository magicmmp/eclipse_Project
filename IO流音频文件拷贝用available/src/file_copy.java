import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class file_copy {
	//小数组复制文件的推荐写法
	public static void main(String[] args) throws IOException {
		File fileMp3=new File("F:\\BaiduNetdiskDownload\\音乐", "爱江山更爱美人-李丽芬.mp3");
		FileInputStream fis = new FileInputStream(fileMp3);
		FileOutputStream fos=new FileOutputStream("copy_爱江山更爱美人-李丽芬.mp3");
		byte[] arr=new byte[1024];
		int len;
		while((len=fis.read(arr))!=-1)
		{
			fos.write(arr, 0, len);
		}
		fis.close();
		fos.close();
	}
}
