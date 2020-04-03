package tp1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHeure {
    
	public static String modifierAffichageDateHeure() {
		
		LocalDateTime dateHeure = LocalDateTime.now();
	
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern( "dd-MMMM-yyyy-HH.mm" );
	    
	    String dateFormate = dateHeure.format( myFormatObj );
		
	    return dateFormate;
	}
}
