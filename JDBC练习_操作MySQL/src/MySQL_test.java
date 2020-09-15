/**
 * 
 */

/**
 * @author magicmmp
 *
 */

import java.sql.*;

public class MySQL_test {

	public static void main(String[] args) throws Exception
	{
		
		// 1.����������ʹ�÷����֪ʶ�����ڼ�ס��ôд��
		Class.forName("com.mysql.jdbc.Driver");
		try(
			// 2.ʹ��DriverManager��ȡ���ݿ�����,
			// ���з��ص�Connection�ʹ�����Java��������ݿ������
			// ��ͬ���ݿ��URLд����Ҫ�������ĵ�֪�����û�����������DBA����
			Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/study_sql?characterEncoding=UTF-8","root","pss123456");
			// 3.ʹ��Connection������һ��Statment����
			Statement stmt = conn.createStatement();
			// 4.ִ��SQL���
			/*
			Statement������ִ��sql���ķ�����
			1 execute ��ִ���κ�SQL��䡣- ����һ��booleanֵ��
			  ���ִ�к��һ�������ResultSet���򷵻�true�����򷵻�false
			2 executeQuery ִ��Select��� �� ���ز�ѯ���Ľ����
			3 executeUpdate ����ִ��DML��䡣�� ����һ��������
			  ����SQL���Ӱ��ļ�¼����
			*/
			ResultSet rs = stmt.executeQuery("select * "
				+ " from orders "))
		{
			// ResultSet��ϵ�е�getXxx(������ | ����)�����ڻ�ȡ��¼ָ��
			// ָ���С��ض��е�ֵ�����ϵ�ʹ��next()����¼ָ������һ�У�
			// ����ƶ�֮���¼ָ����Ȼָ����Ч�У���next()��������true��
			while(rs.next())
			{
				System.out.println(rs.getInt(1) + "\t"
					+ rs.getString(2)+ "\t"
					+ rs.getInt(3) );
			}
		}
	}

}
