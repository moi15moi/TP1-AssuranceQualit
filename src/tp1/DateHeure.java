package tp1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHeure {
    
	public static String getDateFormat() {
		
		LocalDateTime localDateTime = LocalDateTime.now();
	
	    DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern( "dd-MMMM-yyyy-HH.mm" );
	    		
	    return localDateTime.format( dateFormat );
	}
}
