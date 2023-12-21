import java.util.Calendar;
import java.util.Date;

public class kk {

	public static void main(String[] args) {


		Date hoy = crearDate(2022,12,31);
		
		System.out.println(hoy);

	}
	
	
public static Date crearDate(int year,int month, int day) { 
		
		Calendar calendario = Calendar.getInstance();

        //calendario.set(2019, Calendar.SEPTEMBER, 25, 18, 20, 10);
        calendario.set(Calendar.YEAR, year - 1900);
        calendario.set(Calendar.MONTH, month - 1 );  
        calendario.set(Calendar.DAY_OF_MONTH, day);
		return calendario.getTime(); 
	}

}
