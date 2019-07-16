package 工厂模式;

public class FactoryTest 
{
	public static void main(String[] args) 
	{
		// 测试工厂类
		//狗工厂生产一只狗
		DogFactory df=new DogFactory();
		Animal a=df.createAnimal();
		a.eat();
		//猫工厂生产一只猫
		CatFactory cf=new CatFactory();
		Animal b=cf.createAnimal();
		b.eat();
	}
}
