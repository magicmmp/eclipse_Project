import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class forEach {

	public static void main(String[] args) {
		
		ArrayList<String> list=new ArrayList<String>();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		
		for (String string : list) {
			System.out.println(string);
		}
		
		String[] arr= {"ass","cgf","hjjuy"};
		
		List<String> asList = Arrays.asList(arr);
		for (String string : asList) {
			System.out.println(string);
		}

	}

}
