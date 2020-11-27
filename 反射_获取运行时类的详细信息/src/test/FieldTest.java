package test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class FieldTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Class<Person> clazz = Person.class;
		Field[] fields = clazz.getDeclaredFields();
		for(Field f:fields)
		{
			//1、获取权限修饰符
			int modifier=f.getModifiers();
			System.out.print(Modifier.toString(modifier)+"\t");
			//2、数据类型
			Class type=f.getType();
			System.out.print(type.getName()+"\t");
			//3、变量名
			String fname =f.getName();
			System.out.println(fname);
			
		}

	}

}
