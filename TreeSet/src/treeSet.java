import java.util.Comparator;

class Person implements Comparable<Person> {
	String name;
	int age;
	
	@Override
//为了放在TreeSet中排序，重写自定义类person的比较方法
//先比较年龄，年龄相等则比较名字
	public int compareTo(Person arg0) {
		int num=this.age-age;
		return num==0 ? this.name.compareTo(arg0.name) : num;
	}
		
}


class MyComparator implements Comparator<Person>
{
	@Override
	//根据名字字典序来比较
	public int compare(Person o1, Person o2) {
		
		return o1.name.compareTo(o2.name);
	}
}







public class treeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
