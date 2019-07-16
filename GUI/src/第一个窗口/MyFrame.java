package 第一个窗口;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame 
{
	public static void main(String[] args) 
	{
		Frame frame=new Frame("我的第一个窗口");
		frame.setSize(500, 600);//设置窗口大小
		frame.setLocation(300, 300);//窗口位置
		//设置窗口图标
		frame.setIconImage(java.awt.Toolkit.getDefaultToolkit().createImage("葵花.jpg"));
		Button button=new Button("Button");
		frame.add(button);//添加按钮到窗口
		//给按钮添加鼠标监听
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				System.out.println("You Click Button!");
			}
		});
		//给按钮添加键盘监听
		button.addKeyListener(new KeyAdapter() 
		{
			@Override
			public void keyReleased(KeyEvent e) 
			{
				// 打印键值，如果按下回车就退出
				System.out.println("按下的键盘码值是 "+e.getKeyCode());
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					System.exit(0);
			}
		});
		
		Button button2=new Button("Button2");
		frame.add(button2);
		//给按键2添加动作监听，能监听鼠标和键盘的动作
		//但是键盘默认只监听空格键
		button2.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent arg0) 
			{
				// 点鼠标或按空格键，都会退出
				System.exit(0);
			}
		});
		
		//给窗口设置流式布局
		frame.setLayout(new FlowLayout());
		//使用匿名内部类，生成一个继承WindowAdapter的子类
		//给窗口添加窗口监听，只重写需要的方法
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) 
			{
				System.exit(0); //窗口点关闭时，退出虚拟机
			}
		});
		//设置窗口可见
		frame.setVisible(true);		
	}
}
