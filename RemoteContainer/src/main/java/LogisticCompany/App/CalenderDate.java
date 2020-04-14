package LogisticCompany.App;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CalenderDate {

	public String getCurrentDate() {
		
		SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String  dateTime= formatter.format(date);
		return dateTime; 
	}
}
