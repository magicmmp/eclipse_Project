package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


/**
 * @author pss
 * 说明：保存B站缓存视频和音频文件的路径，用于拼接Ffmpeg视频合并的命令
 *
 */
public class VideoFileBean {
	public String fileName;
	public File jsonFile;//从json文件中可以提取文件的名字
	public File audioFile;//声音文件
	public File videoFile;//视频文件
	public int videoType;//0缺少视频文件。1是0.blv不需要合并音频，2是video.m4s需要合并音频
	public VideoFileBean(File jsonFile,File videoFile) 
	{
		this.videoType=1;
		this.jsonFile = jsonFile;
		this.videoFile = videoFile;
	}
	
	public VideoFileBean(File jsonFile, File videoFile, File audioFile) 
	{
		this.videoType=2;
		this.jsonFile = jsonFile;
		this.audioFile = audioFile;
		this.videoFile = videoFile;
	}
	
	/**
	 * @param ：DestinationFolder 要把合并的视频文件保存在哪个文件夹下
	 * @return ：Ffmpeg运行的命令
	 * @throws Exception
	 */
	public String getFfmpegCmd(File DestinationFolder, int index) throws Exception
	{
		Gson gson = new Gson();//利用GSON解析Json文件，从而获得文件名
		VideoInfo videoInfo=gson.fromJson(new InputStreamReader(new FileInputStream(jsonFile.getAbsolutePath()),"UTF-8"), VideoInfo.class);
		
		String command = "ffmpeg.exe";
		if(videoType==2)//video.m4s需要合并音频文件
		{
			command+=" -i "+audioFile.getAbsolutePath();
		}
		
		command+=" -i "+videoFile.getAbsolutePath();
		command+=" -acodec copy -vcodec copy -y ";
		File tmpFile;
		
		if(videoInfo.getPage_data().getPart()!=null)
		{
			fileName=videoInfo.getPage_data().getPart();
		}
		else 
		{
			fileName=videoInfo.getTitle();
		}
		fileName=fileName.replace(" ","+");//去掉文件名中的空格，否则Ffmpeg不能转换
		fileName+="_"+(videoInfo.getDownloaded_bytes()%10000);//附上文件字节数防止同名
		tmpFile=new File(DestinationFolder, fileName+".mp4");//本视频文件保存的绝对路径
		command+=tmpFile.getAbsolutePath();
		
		return command;
	}
	
	
}
