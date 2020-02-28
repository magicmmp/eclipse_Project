package String_Regular_test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringRegularTest {

	public static void main(String[] args) {
		//Java������ʽ��Matcher��Pattern��ʹ��
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
			if(matcher==null)//û�о�����һ��Matcher����
				matcher=p.matcher(msgs[i]);
			else //����һ���ַ���
				matcher.reset(msgs[i]);
			//�滻string�е�һ��ƥ����Ӵ�
			System.out.println(matcher.replaceFirst("����"));
		}
	}
}
