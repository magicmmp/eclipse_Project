package calendar_test_7_4;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// ������ʹ��Calendar����Ҫ�ù�ʱ��Date��
		Calendar calendar=Calendar.getInstance();
		//2020-2-16  12:13:36
		calendar.set(2020, 1, 16, 12, 13, 36);
		//��ȡ�·ݣ����1
		System.out.println(calendar.get(Calendar.MONTH));
		//��ӡ Sun Feb 16 12:13:36 CST 2020
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MONTH, 11);//������ǰ��11����
		//��ӡ Sat Jan 16 12:13:36 CST 2021
		System.out.println(calendar.getTime());
	}
}
