package test;

import java.applet.AudioClip;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;







/**
 * @author pss
 *˵�����ϲ�Bվ�������Ƶ����Ƶ�ļ���ʹ�ñ�������Ҫ�Ȱ�װFfmpeg���ҽ���װĿ¼��bin�ļ���·����ӵ���������
 */
public class GsonTest {
	
	
	//sourceFolder
	/**
	 * @param sourceFolder ��ת���Ļ�����Ƶ�ļ���·��
	 * @return ������Ƶ�ļ���·����Ϣ����������ffmpeg����
	 */
	public static HashSet<VideoFileBean> getVideoFiles(String sourceFolder) 
	{
		File dirFile=new File(sourceFolder);
		if(!dirFile.exists())
		{
			System.out.println(dirFile.getName()+" ���ļ��в����ڣ�");
			return null;
		}
		else if (dirFile.isFile()) {
			System.out.println(dirFile.getName()+" ������һ���ļ���");
			return null;
		}
		
		HashSet<VideoFileBean> videoFiles=new HashSet<VideoFileBean>();
		File[]upFiles=dirFile.listFiles();
		for (File upFile : upFiles) 
		{
			if(upFile.isDirectory())
			{
				File[] subVideos=upFile.listFiles();
				for(File subVideo:subVideos)
				{
					if(subVideo.isDirectory())
					{
						File[] jsonFiles=subVideo.listFiles(new FileFilter() {
							
							@Override
							public boolean accept(File pathname) {
								// TODO Auto-generated method stub
								if(pathname.getName().endsWith(".json"))
									return true;
								else
									return false;
							}
						});
						
						if(jsonFiles.length>0)//�����json��Ϣ�ļ�
						{
							File[] videoDir=subVideo.listFiles(new FileFilter() {
								
								@Override
								public boolean accept(File pathname) {
									// TODO Auto-generated method stub
									if(pathname.isDirectory())
										return true;
									else 
										return false;
								}
							});
							
							if(videoDir.length>0)//�����һ���ļ���
							{
								
								File[] video=videoDir[0].listFiles(new FileFilter() {
									
									@Override
									public boolean accept(File pathname) {
										// TODO Auto-generated method stub 0.blv
										if(pathname.getName().equals("video.m4s") || pathname.getName().equals("0.blv"))
											return true;
										else 
											return false;
									}
								});
								
								if(video.length>0)//�������Ƶ�ļ�video.m4s
								{
									if(video[0].getName().equals("0.blv"))
									{
										videoFiles.add(new VideoFileBean(jsonFiles[0], video[0]));
									}
									else 
									{
										File[] audio=videoDir[0].listFiles(new FileFilter() {
											
											@Override
											public boolean accept(File pathname) {
												// TODO Auto-generated method stub
												if(pathname.getName().equals("audio.m4s"))
													return true;
												else 
													return false;
											}
										});
										
										if(audio.length>0)//�������Ƶ�ļ�audio.m4s
										{
											videoFiles.add(new VideoFileBean(jsonFiles[0], video[0], audio[0]));
										}
										else
										{
											System.out.println(subVideo.getName()+"ȱ����Ƶ�ļ�audio.m4s");
										}
										
									}
									
									
									
								}
								else
								{
									System.out.println(subVideo.getName()+"ȱ����Ƶ�ļ�video.m4s");
								}
								
								
							}
							else
							{
								System.out.println(subVideo.getName()+"ȱ�����ļ���");
							}
							
							
						}
						else
						{
							System.out.println(subVideo.getName()+"ȱ��Json�ļ�");
						}
					}
					
					
				}
			}
				
		}
		System.out.println("���� "+videoFiles.size()+" ����Ƶ�ļ���");
		System.out.println();
		return videoFiles;
	}
	//��Ƶ��ʽ��0.blv�Ĳ���Ҫ�ϲ���Ƶ��ֻ��Ҫ�ĸ��ļ���  2020-12-4
	
	public static void merging_video_and_audio(String destinationFolder,HashSet<VideoFileBean> videos) throws Exception 
	{
		
		
		File outDir=new File(destinationFolder);
		if (!outDir.exists()) 
		{
			outDir.mkdir();
		}
		
		int video_no=1;
		for(VideoFileBean video:videos)
		{
			//ffmpeg.exe -i audio.m4s -i video.m4s -acodec copy -vcodec copy output.mp4 
			String command =video.getFfmpegCmd(outDir,video_no);
			System.out.println(video_no+" ִ�����"+command);

			try 
			{
				Process p = Runtime.getRuntime().exec(command);
				//System.out.println(video_no+" �ȴ�p.waitFor()��������");
				p.waitFor();//�ȴ��������
				//System.out.println(video_no+" p.waitFor()�����Ѿ�����");
				if (p.exitValue() == 0) 
				{
				    System.out.println(video_no+":��Ƶ�ϲ��ɹ���"+video.fileName);
				}
				else 
				{
					System.out.println(video_no+":��Ƶ�ϲ�ʧ�ܣ�"+video.fileName);
				}
				
			} 
			catch (Exception e) 
			{
				//���ִ���
				System.out.println(video_no+":����ִ��ʧ�ܣ�");
				System.out.println(e);
			}
			
			video_no++;
			System.out.println();
		}
	}
	
	

	
	public static void main(String[] args) throws Exception
	{
		
		HashSet<VideoFileBean> videos=getVideoFiles("D:\\BiLi_Vedio2");//��ȡ��ת�����ļ���·����Ϣ
		merging_video_and_audio("D:\\OutPutVideo2",videos);//ת����Ƶ������ļ���
	

	}

}
