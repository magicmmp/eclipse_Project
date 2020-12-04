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
 * ˵��������Bվ������Ƶ����Ƶ�ļ���·��������ƴ��Ffmpeg��Ƶ�ϲ�������
 *
 */
public class VideoFileBean {
	public String fileName;
	public File jsonFile;//��json�ļ��п�����ȡ�ļ�������
	public File audioFile;//�����ļ�
	public File videoFile;//��Ƶ�ļ�
	public int videoType;//0ȱ����Ƶ�ļ���1��0.blv����Ҫ�ϲ���Ƶ��2��video.m4s��Ҫ�ϲ���Ƶ
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
	 * @param ��DestinationFolder Ҫ�Ѻϲ�����Ƶ�ļ��������ĸ��ļ�����
	 * @return ��Ffmpeg���е�����
	 * @throws Exception
	 */
	public String getFfmpegCmd(File DestinationFolder, int index) throws Exception
	{
		Gson gson = new Gson();//����GSON����Json�ļ����Ӷ�����ļ���
		VideoInfo videoInfo=gson.fromJson(new InputStreamReader(new FileInputStream(jsonFile.getAbsolutePath()),"UTF-8"), VideoInfo.class);
		
		String command = "ffmpeg.exe";
		if(videoType==2)//video.m4s��Ҫ�ϲ���Ƶ�ļ�
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
		fileName=fileName.replace(" ","+");//ȥ���ļ����еĿո񣬷���Ffmpeg����ת��
		fileName+="_"+(videoInfo.getDownloaded_bytes()%10000);//�����ļ��ֽ�����ֹͬ��
		tmpFile=new File(DestinationFolder, fileName+".mp4");//����Ƶ�ļ�����ľ���·��
		command+=tmpFile.getAbsolutePath();
		
		return command;
	}
	
	
}
