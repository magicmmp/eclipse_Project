package abstract_class_test;

public class AbstractClassTest {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//������Shape���ͣ�����ʵ����Circle����
		Shape shape = new Circle("��ɫ", 1.5);
		System.out.println(shape.getPerimeter());
		System.out.println(shape.getType());

	}

}
