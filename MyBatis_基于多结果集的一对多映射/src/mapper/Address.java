package mapper;

import org.apache.ibatis.type.Alias;

@Alias("address")
public class Address {
	private Integer id;
	private String detail;
	private Person person;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", detail=" + detail + ", person=" + person + "]";
	}
	
	
	
}
