package calendar_test_7_4;

import java.util.Calendar;

public class CalendarTest {

	public static void main(String[] args) {
		// 日期类使用Calendar，不要用过时的Date类
		Calendar calendar=Calendar.getInstance();
		//2020-2-16  12:13:36
		calendar.set(2020, 1, 16, 12, 13, 36);
		//获取月份，输出1
		System.out.println(calendar.get(Calendar.MONTH));
		//打印 Sun Feb 16 12:13:36 CST 2020
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MONTH, 11);//日期往前加11个月
		//打印 Sat Jan 16 12:13:36 CST 2021
		System.out.println(calendar.getTime());
	}
}
