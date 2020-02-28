package chapter_1_stack_and_queue;

import java.io.*;
import java.util.Stack;

//�����㷨ʵ����
class GetMinStack {
	private Stack<Integer> stackMin;
	private Stack<Integer> stackData;
	
	public GetMinStack(){
		stackData=new Stack<Integer>();
		stackMin =new Stack<Integer>();
	}
	
	public void push(int newNum){
		if(stackMin.isEmpty())
			stackMin.push(newNum);
		else if(newNum<=getMin())
			stackMin.push(newNum);
		stackData.push(newNum);
	}
	
	public int pop(){
		if(stackData.isEmpty())
			throw new RuntimeException("You stack is empty!");
		int num=stackData.pop();
		if(num==getMin())
			stackMin.pop();
		return num;
	}
	
	public int getMin(){
		if(stackMin.isEmpty())
			throw new RuntimeException("You stack is empty!");
		return stackMin.peek();
	}
}	

//��ţ�����ύʱ���Ѵ�������ΪMain
public class Problem_01_GetMinStack {

	public static void main(String[] args) throws IOException {
		//��ţ�����ύʱ�����
		//BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
		//�����ļ�ģ���������  �����
		BufferedReader scanner = new BufferedReader(new FileReader("GetMinStack����������.txt"));
		GetMinStack stack=new GetMinStack();
		int row = Integer.valueOf(scanner.readLine());
        for (int i = 0; i < row; i++) {
            String[] data = scanner.readLine().split(" ");
            if(data[0].equals("push")) {
            	stack.push(Integer.valueOf(data[1]));
                continue;
            }
            if (data[0].equals("pop")) {
            	stack.pop();
                continue;
            }
            System.out.println(stack.getMin());   
        }
        scanner.close();
	}
}

























