package hehe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("MyBean223")
public class MyBean {
	
	@Autowired
	private MyRespository myRespository;
	
	public void info()
	{
		System.out.println("MyBean info...");
		myRespository.save();
	}

}
