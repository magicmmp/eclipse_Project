package HashMap_test_8_6;

import java.util.LinkedHashMap;

enum Season
{
	SPRING,SUMMER,FALL,WINTER
}

public class MapTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashMap scores=new LinkedHashMap();
		scores.put("ÓïÎÄ", 80);
		scores.put("ÊýÑ§", 90);
		scores.put("Ó¢Óï", 85);
		scores.forEach((key,value)->System.out.println(key+"------"+value));
		
		System.out.println(Season.SPRING);

	}

}
