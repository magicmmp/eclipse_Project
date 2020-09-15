package simple_test;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Properties;
import java.util.Queue;
import java.util.Stack;

import sun.security.timestamp.TSRequest;

class hehe{
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "我已经改写了toString()";
	}
}



/**
 * Definition for singly-linked list.
 * 
 */
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	
    	
    	ListNode head,curNode;
    	head=new ListNode(0);
    	curNode=head;//当前节点
    	while(l1!=null && l2!=null)
    	{
    		if(l1.val<l2.val)
    		{
    			curNode.next=l1;//连接下一个节点
    			l1=l1.next;
    		}
    		else 
    		{
    			curNode.next=l2;//连接下一个节点
    			l2=l2.next;
			}
    		curNode=curNode.next;//当前节点
    	}
    	curNode.next=(l1!=null)?l1:l2;
    	
		return head.next;
        
    }
}

class ExecuteDML
{
	private String driver;
	private String url;
	private String user;
	private String pass;

	public void initParam(String paramFile)
		throws Exception
	{
		// 使用Properties类来加载属性文件
		Properties props = new Properties();
		props.load(new FileInputStream(paramFile));
		driver = props.getProperty("driver");
		url = props.getProperty("url");
		user = props.getProperty("user");
		pass = props.getProperty("pass");
	}
	
	
	public static void printParam() throws Exception
	{
		ExecuteDML ed = new ExecuteDML();
		ed.initParam("property.ini");
		
		System.out.println("driver :" + ed.driver);
		System.out.println("url :" + ed.url);
		System.out.println("user :" + ed.user);
		System.out.println("pass :" + ed.pass);
	}
}



public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(new hehe());
		
		LinkedHashMap<String,Integer> scores=new LinkedHashMap<>();
		scores.put("语文", 80);
		scores.put("数学", 90);
		scores.put("英语", 85);
		scores.forEach((key,value)->System.out.println(key+"------"+value));
		
		System.out.println("属性文件读取练习：");
		ExecuteDML.printParam();
		
		
		// 以当前路径来创建一个File对象
				File file = new File(".");
				// 直接获取文件名，输出一点
				System.out.println(file.getName());
				// 获取相对路径的父路径可能出错，下面代码输出null
				System.out.println(file.getParent());
				// 获取绝对路径
				System.out.println(file.getAbsoluteFile());
				// 获取上一级路径
				System.out.println(file.getAbsoluteFile().getParent());
				// 在当前路径下创建一个临时文件
				File tmpFile = File.createTempFile("aaa", ".txt", file);
				// 指定当JVM退出时删除该文件
				tmpFile.deleteOnExit();
				// 以系统当前时间作为新文件名来创建新文件
				File newFile = new File(System.currentTimeMillis() + "");
				System.out.println("newFile对象是否存在：" + newFile.exists());
				// 以指定newFile对象来创建一个文件
				newFile.createNewFile();
				// 以newFile对象来创建一个目录，因为newFile已经存在，
				// 所以下面方法返回false，即无法创建该目录
				newFile.mkdir();
				// 使用list()方法来列出当前路径下的所有文件和路径
				String[] fileList = file.list();
				System.out.println("====当前路径下所有文件和路径如下====");
				for (String fileName : fileList)
				{
					System.out.println(fileName);
				}
				// listRoots()静态方法列出所有的磁盘根路径。
				File[] roots = File.listRoots();
				System.out.println("====系统所有根路径如下====");
				for (File root : roots)
				{
					System.out.println(root);
				}
				
				
				file = new File(".");
				// 使用Lambda表达式（目标类型为FilenameFilter）实现文件过滤器。
				// 如果文件名以.java结尾，或者文件对应一个路径，返回true
				String[] nameList = file.list((dir, name) -> name.endsWith(".java")
					|| new File(name).isDirectory());
				for(String name : nameList)
				{
					System.out.println(name);
				}

	}

}
