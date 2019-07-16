package 工厂模式;

//具体工厂类负责创建对象
public class DogFactory implements Factory {
	@Override
	public Animal createAnimal() {
		return new Dog();
	}
}
