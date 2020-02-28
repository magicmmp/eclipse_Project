package String_Regular_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegularTest {

	public static void main(String[] args) {
		//Java正则表达式类Matcher和Pattern的使用
		String[] msgs=
		{
				"Java has expression regular regular  in 1.4",
				"regular expression now expressing in java",
				"Java represses oracular expressions"
		};
		Pattern p=Pattern.compile("re\\w*");
		Matcher matcher=null;
		for(int i=0;i<msgs.length;i++)
		{
			if(matcher==null)//没有就生成一个Matcher对象
				matcher=p.matcher(msgs[i]);
			else //更换一个字符串
				matcher.reset(msgs[i]);
			//替换string中第一个匹配的子串
			System.out.println(matcher.replaceFirst("哈哈"));
		}
	}
}
