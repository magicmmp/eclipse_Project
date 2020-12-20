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
 *说明：合并B站缓存的视频和音频文件。使用本程序需要先安装Ffmpeg并且将安装目录的bin文件夹路径添加到环境变量
 */
public class GsonTest {
	
	
	//sourceFolder
	/**
	 * @param sourceFolder 待转换的缓存视频文件夹路径
	 * @return 所有视频文件的路径信息，用于生成ffmpeg命令
	 */
	public static HashSet<VideoFileBean> getVideoFiles(String sourceFolder) 
	{
		File dirFile=new File(sourceFolder);
		if(!dirFile.exists())
		{
			System.out.println(dirFile.getName()+" ：文件夹不存在！");
			return null;
		}
		else if (dirFile.isFile()) {
			System.out.println(dirFile.getName()+" ：这是一个文件！");
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
						
						if(jsonFiles.length>0)//如果有json信息文件
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
							
							if(videoDir.length>0)//如果有一个文件夹
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
								
								if(video.length>0)//如果有视频文件video.m4s
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
										
										if(audio.length>0)//如果有音频文件audio.m4s
										{
											videoFiles.add(new VideoFileBean(jsonFiles[0], video[0], audio[0]));
										}
										else
										{
											System.out.println(subVideo.getName()+"缺少音频文件audio.m4s");
										}
										
									}
									
									
									
								}
								else
								{
									System.out.println(subVideo.getName()+"缺少视频文件video.m4s");
								}
								
								
							}
							else
							{
								System.out.println(subVideo.getName()+"缺少子文件夹");
							}
							
							
						}
						else
						{
							System.out.println(subVideo.getName()+"缺少Json文件");
						}
					}
					
					
				}
			}
				
		}
		System.out.println("发现 "+videoFiles.size()+" 个视频文件。");
		System.out.println();
		return videoFiles;
	}
	//视频格式是0.blv的不需要合并音频，只需要改个文件名  2020-12-4
	
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
			System.out.println(video_no+" 执行命令："+command);

			try 
			{
				Process p = Runtime.getRuntime().exec(command);
				//System.out.println(video_no+" 等待p.waitFor()函数返回");
				p.waitFor();//等待任务完成
				//System.out.println(video_no+" p.waitFor()函数已经返回");
				if (p.exitValue() == 0) 
				{
				    System.out.println(video_no+":视频合并成功："+video.fileName);
				}
				else 
				{
					System.out.println(video_no+":视频合并失败："+video.fileName);
				}
				
			} 
			catch (Exception e) 
			{
				//出现错误
				System.out.println(video_no+":任务执行失败！");
				System.out.println(e);
			}
			
			video_no++;
			System.out.println();
		}
	}
	
	

	
	public static void main(String[] args) throws Exception
	{
		
		HashSet<VideoFileBean> videos=getVideoFiles("D:\\BiLi_Vedio2");//提取待转换的文件的路径信息
		merging_video_and_audio("D:\\OutPutVideo2",videos);//转换视频的输出文件夹
	

	}

}
