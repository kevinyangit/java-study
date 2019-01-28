package date;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateTest {

	@SuppressWarnings("deprecation")
	@Test
	public void testDateEqual() throws Exception {
		Date date = new Date();
		int date2 = date.getDate();
		System.out.println(date2);
		long time = date.getTime();
		Date date3 = new Date();
		long time2 = date3.getTime();
		System.out.println(time == time2);

	}

	@Test
	public void testSqlDate() throws Exception {
		//(1)   
		java.util.Date time1 = new java.util.Date();   
		  //(2)   
		java.sql.Date time2 = new java.sql.Date(System.currentTimeMillis());   
		  //(3)   
		java.sql.Time time3 = new java.sql.Time(System.currentTimeMillis());     
		  //(4)
		java.sql.Timestamp time = new java.sql.Timestamp(System.currentTimeMillis());     
		System.out.println(time);   
		DateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日  HH：mm：ss 今年第ww周  第DD天");     
		System.out.println("北京时间：" + sdf.format(time1) + "\n");   
		System.out.println("北京时间：" + sdf.format(time2)+ "\n");   
		System.out.println("北京时间：" + sdf.format(time3)+ "\n");
		System.out.println("北京时间：" + sdf.format(time)+ "\n");
		
	}

}
