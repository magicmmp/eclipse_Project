package EnumSet_test_8_3;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

enum Season
{
	SPRING,SUMMER,FALL,WINTER
}

public class EnumSetTest {

	public static void main(String[] args) {
		//创建一个EnumSet集合，包含枚举类Season全部枚举值
		EnumSet es1=EnumSet.allOf(Season.class);
		System.out.println(es1);//打印集合元素
		EnumSet es2=EnumSet.noneOf(Season.class);
		System.out.println(es2);
		es2.add(Season.WINTER);
		es2.add(Season.SPRING);
		System.out.println(es2);
		EnumSet es3=EnumSet.of(Season.SUMMER,Season.WINTER);
		System.out.println(es3);
		EnumSet es4=EnumSet.range(Season.SUMMER, Season.WINTER);
		System.out.println(es4);
		EnumSet es5=EnumSet.complementOf(es4);
		System.out.println(es5);
		
		
	}
}






























































