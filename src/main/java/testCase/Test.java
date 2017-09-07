package testCase;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class Test {
public static void main(String[] args) {
	String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new java.util.Date());
	System.out.println(timeStamp);
	System.out.println(new Timestamp(System.currentTimeMillis()));
	System.out.println(new SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis()));
}

}
