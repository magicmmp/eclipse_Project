package abstract_class_test;

public class AbstractClassTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//引用是Shape类型，但是实例是Circle类型
		Shape shape = new Circle("黄色", 1.5);
		System.out.println(shape.getPerimeter());
		System.out.println(shape.getType());

	}

}
