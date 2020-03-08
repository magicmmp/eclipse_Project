package chapter_1_stack_and_queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;//网上提交要引入这句
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

class Pet{
	private String petType;
	private long timeStamp;
	private int petNumber;
	
	
	Pet(String petType,int petNumber,long timeStamp)
	{
		this.petType=petType;
		this.petNumber=petNumber;
		this.timeStamp=timeStamp;
	}

	String getPetType() {
		return petType;
	}

	int getPetNumber() {
		return petNumber;
	}

	long getTimeStamp() {
		return timeStamp;
	}
}

class Cat extends Pet{
	Cat(int petNumber,long timeStamp){
		super("cat",petNumber,timeStamp);
	}
}

class Dog extends Pet{
	Dog(int petNumber,long timeStamp){
		super("dog",petNumber,timeStamp);
	}
}


class DogCatQueue{
	private Queue<Pet>CatQ;
	private Queue<Pet>DogQ;
	private long timeStamp;
	
	public DogCatQueue() {
		CatQ=new LinkedList<>();
		DogQ=new LinkedList<>();
		timeStamp=0;
	}
	
	public void add(String petType,int petNumber) {
		if("cat".equals(petType))
			CatQ.add(new Cat(petNumber, timeStamp++));
		else if ("dog".equals(petType)) {
			DogQ.add(new Dog(petNumber, timeStamp++));
		}
		else {
			throw new RuntimeException("not dog or cat");
		}
	}
	
	public Pet pollAll() {
		if(!CatQ.isEmpty() && !DogQ.isEmpty())
		{
			if(CatQ.peek().getTimeStamp()<DogQ.peek().getTimeStamp())
				return	CatQ.poll();
			else
				return  DogQ.poll();
		}
		else if (!CatQ.isEmpty()) {
			return	CatQ.poll();
		}
		else if (!DogQ.isEmpty()) {
			return DogQ.poll();
		}
		else {
			throw new RuntimeException("no dog or cat");
		}
	}
	
	public Cat pollCat() {
		if(!CatQ.isEmpty())
			return (Cat)CatQ.poll();
		else
			throw new RuntimeException("no cat");
	}
	
	public Dog pollDog() {
		if(!DogQ.isEmpty())
			return (Dog)DogQ.poll();
		else
			throw new RuntimeException("no dog");
	}
	
	public boolean isEmpty()
	{
		if(CatQ.isEmpty() && DogQ.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isDogEmpty() {
		if(DogQ.isEmpty())
			return true;
		else
			return false;
	}
	
	public boolean isCatEmpty() {
		if(CatQ.isEmpty())
			return true;
		else
			return false;
	}
}


public class Problem_04_DogCatQueue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//在牛客网提交时用这句
				//BufferedReader scanner = new BufferedReader(new InputStreamReader(System.in));
				//本地文件模拟测试数据  用这句
				BufferedReader scanner = new BufferedReader(new FileReader("Problem_04_DogCatQueue的输入数据.txt"));
				DogCatQueue dogCatQueue=new DogCatQueue();
				int row = Integer.valueOf(scanner.readLine());
		        for (int i = 0; i < row; i++) {
		            String[] data = scanner.readLine().split(" ");
		            if(data[0].equals("add")) {
		            		dogCatQueue.add(data[1], Integer.valueOf(data[2]));
		            }
		            else if (data[0].equals("pollAll")) {
		            	while(!dogCatQueue.isEmpty())
		            	{
		            		Pet pet=dogCatQueue.pollAll();
		            		String string=pet.getPetType()+" "+pet.getPetNumber();
		            		System.out.println(string);
		            	}
		            }
		            else if (data[0].equals("pollDog")) {
		            	while(!dogCatQueue.isDogEmpty())
		            	{
		            		Pet pet=dogCatQueue.pollDog();
		            		String string=pet.getPetType()+" "+pet.getPetNumber();
		            		System.out.println(string);
		            	}
					}
		            else if (data[0].equals("pollCat")) {
		            	while(!dogCatQueue.isCatEmpty())
		            	{
		            		Pet pet=dogCatQueue.pollCat();
		            		String string=pet.getPetType()+" "+pet.getPetNumber();
		            		System.out.println(string);
		            	}
					}   
		            else if (data[0].equals("isEmpty")) {
		            	if(dogCatQueue.isEmpty())
		            		System.out.println("yes");
		            	else
		            		System.out.println("no");
		            }
		            else if (data[0].equals("isCatEmpty")) {
		            	if(dogCatQueue.isCatEmpty())
		            		System.out.println("yes");
		            	else
		            		System.out.println("no");
		            }
		            else if (data[0].equals("isDogEmpty")) {
		            	if(dogCatQueue.isDogEmpty())
		            		System.out.println("yes");
		            	else
		            		System.out.println("no");
		            }
		        }
		        scanner.close();

	}
}
