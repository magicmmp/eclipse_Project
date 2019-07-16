package MyComparator;

import java.util.Comparator;

import Person_Bean.Person;

public class MyComparator implements Comparator<Person> {

	@Override
	public int compare(Person o1, Person o2) {
		
		return o1.name.compareTo(o2.name);
	}

	
}
