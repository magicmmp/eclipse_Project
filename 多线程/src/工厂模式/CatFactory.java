package 工厂模式;

//具体工厂类负责创建对象
public class CatFactory implements Factory {
	@Override
	public Animal createAnimal() {
		return new Cat();
	}
}
