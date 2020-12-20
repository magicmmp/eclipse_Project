import org.junit.Test;

import com.google.gson.Gson;

public class TestHello {
	
	@Test
	public void testHello()
	{
		Hello hello=new Hello();
		String string=hello.sayHello("Maven");
		System.out.println(string);
		Gson gson=new Gson();
		System.out.println("¥Ú”°gson∂‘œÛ£∫"+gson);
	}

}
