import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class Teste {

	public static void main(String[] args) {
		Locale LOCALE_BRASIL = new Locale("pt", "BR");
		SimpleDateFormat sdfFormat = new SimpleDateFormat("HH:mm", LOCALE_BRASIL);
		try {
			Date hr01 = sdfFormat.parse("09:00");
			Date hr02 = sdfFormat.parse("08:30");
			if (hr01.after(hr02)) {
				System.out.println("ERRO");
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
