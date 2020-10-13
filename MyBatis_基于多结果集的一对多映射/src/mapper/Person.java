package mapper;

import java.util.List;

import org.apache.ibatis.type.Alias;

@Alias("person")
public class Person {
	private Integer id;
	private String name;
	private Integer age;
	private List<Address> addresses;
	
	public Person() 
	{
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", age=" + age + ", addresses=" + addresses + "]";
	}
	
	

	
	

}
