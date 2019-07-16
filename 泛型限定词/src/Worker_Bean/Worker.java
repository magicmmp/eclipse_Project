package Worker_Bean;

import Person_Bean.Person;

public class Worker extends Person {
	
	int salary;

	public Worker(int age, String name, int salary) {
		super(age, name);
		this.salary = salary;
	}

}
