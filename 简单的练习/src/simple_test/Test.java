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
		return "���Ѿ���д��toString()";
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
    	curNode=head;//��ǰ�ڵ�
    	while(l1!=null && l2!=null)
    	{
    		if(l1.val<l2.val)
    		{
    			curNode.next=l1;//������һ���ڵ�
    			l1=l1.next;
    		}
    		else 
    		{
    			curNode.next=l2;//������һ���ڵ�
    			l2=l2.next;
			}
    		curNode=curNode.next;//��ǰ�ڵ�
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
		// ʹ��Properties�������������ļ�
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
		scores.put("����", 80);
		scores.put("��ѧ", 90);
		scores.put("Ӣ��", 85);
		scores.forEach((key,value)->System.out.println(key+"------"+value));
		
		System.out.println("�����ļ���ȡ��ϰ��");
		ExecuteDML.printParam();
		
		
		// �Ե�ǰ·��������һ��File����
				File file = new File(".");
				// ֱ�ӻ�ȡ�ļ��������һ��
				System.out.println(file.getName());
				// ��ȡ���·���ĸ�·�����ܳ�������������null
				System.out.println(file.getParent());
				// ��ȡ����·��
				System.out.println(file.getAbsoluteFile());
				// ��ȡ��һ��·��
				System.out.println(file.getAbsoluteFile().getParent());
				// �ڵ�ǰ·���´���һ����ʱ�ļ�
				File tmpFile = File.createTempFile("aaa", ".txt", file);
				// ָ����JVM�˳�ʱɾ�����ļ�
				tmpFile.deleteOnExit();
				// ��ϵͳ��ǰʱ����Ϊ���ļ������������ļ�
				File newFile = new File(System.currentTimeMillis() + "");
				System.out.println("newFile�����Ƿ���ڣ�" + newFile.exists());
				// ��ָ��newFile����������һ���ļ�
				newFile.createNewFile();
				// ��newFile����������һ��Ŀ¼����ΪnewFile�Ѿ����ڣ�
				// �������淽������false�����޷�������Ŀ¼
				newFile.mkdir();
				// ʹ��list()�������г���ǰ·���µ������ļ���·��
				String[] fileList = file.list();
				System.out.println("====��ǰ·���������ļ���·������====");
				for (String fileName : fileList)
				{
					System.out.println(fileName);
				}
				// listRoots()��̬�����г����еĴ��̸�·����
				File[] roots = File.listRoots();
				System.out.println("====ϵͳ���и�·������====");
				for (File root : roots)
				{
					System.out.println(root);
				}
				
				
				file = new File(".");
				// ʹ��Lambda���ʽ��Ŀ������ΪFilenameFilter��ʵ���ļ���������
				// ����ļ�����.java��β�������ļ���Ӧһ��·��������true
				String[] nameList = file.list((dir, name) -> name.endsWith(".java")
					|| new File(name).isDirectory());
				for(String name : nameList)
				{
					System.out.println(name);
				}

	}

}
