package br.com.prodevelopment.contato.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.hsqldb.lib.StringUtil;

import com.liferay.portal.kernel.util.Validator;

public class DateUtil {

	public static final Locale LOCALE_BRASIL = new Locale("pt", "BR");
	public static String ORDER_BY_DESC = "desc";
	public static String ORDER_BY_CRESC = "cresc";

	public static Date min(Date date, Date otherDate) {
		return date.getTime() < otherDate.getTime() ? date : otherDate;
	}

	public static Date max(Date date, Date otherDate) {
		return date.getTime() > otherDate.getTime() ? date : otherDate;
	}

	public static String getDiaSemana(int ano, int mes, int dia) {
		GregorianCalendar novaData = new GregorianCalendar(LOCALE_BRASIL);
		novaData.set(ano, mes, dia);
		SimpleDateFormat sdf = new SimpleDateFormat("E", LOCALE_BRASIL);
		return sdf.format(novaData);
	}

	public static String getNomeMesCorrente(int mes) {
		GregorianCalendar novaData = new GregorianCalendar(LOCALE_BRASIL);
		novaData.set(2006, mes - 1, 01);
		SimpleDateFormat sdf = new SimpleDateFormat("MMMM", LOCALE_BRASIL);
		return sdf.format(novaData.getTime());
	}

	/**
	 * Formata uma variavel do tipo String para um objeto do tipo Date.
	 * 
	 * @param String
	 *            data a ser tratada.
	 * @return Date objeto criado a partir da string.
	 */
	public static Date stringToDate(String data) {
		Date result = null;
		if (Validator.isNotNull(data)) {
			try {
				result = new SimpleDateFormat("dd/MM/yyyy", LOCALE_BRASIL)
						.parse(data);
			} catch (ParseException e) {
				// TODO logar o erro
			}
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo String para um objeto do tipo Date.
	 * 
	 * @param String
	 *            data a ser tratada.
	 * @return Date objeto criado a partir da string.
	 */
	public static Date stringToDate(String formato, String data)
			throws ParseException {
		Date result = null;
		if (Validator.isNotNull(data)) {
			result = new SimpleDateFormat(formato, LOCALE_BRASIL).parse(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String dateToString(Date data) {
		String result = null;
		if (data != null) {
			result = new SimpleDateFormat("dd/MM/yyyy", LOCALE_BRASIL)
					.format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd-MMM-yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String dateToStringSQL(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("dd-MMM-yy", LOCALE_BRASIL)
					.format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy
	 * HH/mm.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String dateToStringWithHour(Date data) {
		String result = null;
		if (data != null) {
			result = new SimpleDateFormat("dd/MM/yyyy - HH:mm", LOCALE_BRASIL)
					.format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato HH:mm.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String dateToStringOnlyHour(Date data) {
		String result = null;
		if (data != null) {
			result = new SimpleDateFormat("HH:mm", LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getDiaDate(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("dd", LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getMesDate(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("MM", LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getAnoDate(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("yyyy", LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getAnoDate(Date data, String formato) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat(formato, LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Formata uma variavel do tipo date para uma String formato HH.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getHoraDate(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("HH", LOCALE_BRASIL).format(data);
		}
		return result;
	}
	
	/**
	 * Formata uma variavel do tipo date para uma String formato mm.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String getMinutoDate(Date data) {
		String result = "";
		if (data != null) {
			result = new SimpleDateFormat("mm", LOCALE_BRASIL).format(data);
		}
		return result;
	}

	/**
	 * Método para comparar as das e retornar o numero de dias de diferença
	 * entre elas
	 * 
	 * Compare two date and return the difference between them in days.
	 * 
	 * @param dataLow
	 *            The lowest date
	 * @param dataHigh
	 *            The highest date
	 * 
	 * @return int
	 */
	public static int dataDiff(java.util.Date dataLow, java.util.Date dataHigh) {

		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		startTime.setTime(dataLow);
		endTime.setTime(dataHigh);

		int dif_multiplier = 1;

		// Verifica a ordem de inicio das datas
		if (dataLow.compareTo(dataHigh) < 0) {
			baseTime.setTime(dataHigh);
			curTime.setTime(dataLow);
			dif_multiplier = 1;
		} else {
			baseTime.setTime(dataLow);
			curTime.setTime(dataHigh);
			dif_multiplier = -1;
		}

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando
		// no total de dias. Ja leva em consideracao ano bissesto
		while (curTime.get(GregorianCalendar.YEAR) < baseTime
				.get(GregorianCalendar.YEAR)
				|| curTime.get(GregorianCalendar.MONTH) < baseTime
						.get(GregorianCalendar.MONTH)) {

			int max_day = curTime
					.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);

		}

		// Marca que um saldo negativo ou positivo
		result_months = result_months * dif_multiplier;

		// Retorna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime
				.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}

	public static Date addDias(Date date, int dias) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, dias);

		return calendar.getTime();

	}

	public static Date addMinutos(Date date, int minutos) {

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.MINUTE, minutos);
		return calendar.getTime();

	}

	public static Date addMeses(Date date, int meses) {

		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.MONTH, meses);
		return cal.getTime();

	}

	public static Date getDataAtual() {
		GregorianCalendar novaData = new GregorianCalendar();
		Date dataAtual = novaData.getTime();
		return dataAtual;
	}

	public static String getHojeExtenso() {
		String diaf = null;
		String mesf = null;
		String retorno = null;
		Calendar calendar = new GregorianCalendar();
		Date hoje = new Date();
		calendar.setTime(hoje);
		int semana = calendar.get(Calendar.DAY_OF_WEEK);
		int mes = calendar.get(Calendar.MONTH) + 1;
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		int ano = calendar.get(Calendar.YEAR);

		// semana
		switch (semana) {
		case 1:
			diaf = "Domingo";
			break;
		case 2:
			diaf = "Segunda";
			break;
		case 3:
			diaf = "Terçca";
			break;
		case 4:
			diaf = "Quarta";
			break;
		case 5:
			diaf = "Quinta";
			break;
		case 6:
			diaf = "Sexta";
			break;
		case 7:
			diaf = "Sábado";
			break;
		}
		// mês
		switch (mes) {
		case 1:
			mesf = "Janeiro";
			break;
		case 2:
			mesf = "Fevereiro";
			break;
		case 3:
			mesf = "Março";
			break;
		case 4:
			mesf = "Abril";
			break;
		case 5:
			mesf = "Maio";
			break;
		case 6:
			mesf = "Junho";
			break;
		case 7:
			mesf = "Julho";
			break;
		case 8:
			mesf = "Agosto";
			break;
		case 9:
			mesf = "Setembro";
			break;
		case 10:
			mesf = "Outubro";
			break;
		case 11:
			mesf = "Novembro";
			break;
		case 12:
			mesf = "Dezembro";
			break;
		}
		retorno = diaf + ", " + dia + " de " + mesf + ", de " + ano;
		return retorno;
	}

	public static String obterData(int dia, int mes, int ano) {
		
        String retorno = null;

        String sDia = Helper.zerosEsquerda(Integer.toString(dia), 2);
        String sMes = Helper.zerosEsquerda(Integer.toString(mes), 2);
        String sAno = Integer.toString(ano);

        retorno = sDia + "/" + sMes + "/" + sAno;

        return retorno;
	}
	
	public static List<Integer> generateRangeYears(int startYear, int endYear, String orderBy) {
		List<Integer> years = new ArrayList<Integer>();
		
		if(orderBy != null && orderBy.equals(ORDER_BY_DESC)) {
			for(int i = endYear; i > startYear; i--) {
				years.add(i);
			}
		} else {
			for(int i = startYear; i < endYear; i++) {
				years.add(i);
			}
		}
		
		return years;
	}
	
	public static int [] differenceInHours(Date startDate, Date endDate){  
        int [] result = new int[2];
        
        long difference = endDate.getTime() - startDate.getTime();  
        int hours = (int)(difference / 1000) / 3600;
        int minutes = (int)((difference / 1000) - (hours * 3600)) / 60;
        
        result[0] = hours;
        result[1] = minutes;
        
        return result;  
    }  
	
	public static boolean isBusinessDay(Calendar cal) {
		return !((cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) || (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY));
	}
	
	public static Date setStartDate(Date startDate){
		if(startDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(startDate);
			cal.set(Calendar.HOUR, 00);
			cal.set(Calendar.MINUTE, 00);
			cal.set(Calendar.SECOND, 00);
			
			return cal.getTime();
		}
		
		return null;		
	}
	
	public static Date setEndDate(Date endDate){
		if(endDate != null){
			Calendar cal = Calendar.getInstance();
			cal.setTime(endDate);
			cal.set(Calendar.HOUR, 23);
			cal.set(Calendar.MINUTE, 59);
			cal.set(Calendar.SECOND, 59);
			
			return cal.getTime();
		}
		
		return null;
	}
	
	public static boolean isBeforeCurrentDate(int month, int year){
		Calendar cal = Calendar.getInstance();
		int currentMonth = cal.get(Calendar.MONTH) + 1;
        int currentYear = cal.get(Calendar.YEAR);
        
        if(year > currentYear)
        	return false;
        
        if(month >= currentMonth && year == currentYear)
        	return false;
        
        return true;
	}
	
	public static boolean isAfterCurrentDate(int month, int year){
		return !isBeforeCurrentDate(month, year);
	}
	
	public static boolean isValidDate(String date, String pattern) {	
		if (date == null || date.equals("")) {
			return false;
		}
	
		try {
			DateFormat format = new SimpleDateFormat(pattern);
			format.setLenient(false);
			format.parse(date);
			
			return true;
		} catch (ParseException e) {
			return false;
		}
	}	
	public static boolean isAfter(Date startDate, Date endDate)
	{
		return ( startDate.getTime() > endDate.getTime() );
	}
	public static boolean isBefore(Date startDate, Date endDate)
	{
		return ( startDate.getTime() < endDate.getTime() );
	}

	public static boolean isEqual(Date startDate, Date endDate)
	{
		return ( startDate.getTime() == endDate.getTime() );
	}

	public static boolean isValidTime( String hora ) 
	{
		SimpleDateFormat sdf  = new SimpleDateFormat( "HH:mm" );   
		sdf.setLenient( false );   
		try   
		{   
		    @SuppressWarnings("unused")
			Date d = sdf.parse( hora );   
		}   
		catch( ParseException e )   
		{   
		    return false;   
		}  
		return true;
	}

	public static Date setDateHour( Date data, String hora, boolean isEndDate ) 
	{
		if ( data != null && !StringUtil.isEmpty( hora )  && hora.length() == 5 ) 
		{
			Calendar cal = Calendar.getInstance();
			cal.setTime( data );
			cal.set( Calendar.HOUR_OF_DAY, Integer.parseInt( hora.substring(0, 2) ) );
			cal.set( Calendar.MINUTE, Integer.parseInt( hora.substring(3, 5) ) );
			cal.set( Calendar.SECOND, ( ( isEndDate ? 59: 0 ) ) );
			
			return cal.getTime();
		}
		return null;
	}
	
	public static String getDateHour( Date data, String pattern ) 
	{
		if ( data != null )
		{
			SimpleDateFormat formatador = new SimpleDateFormat( pattern );   
			return formatador.format( data );  
		}
		return "";
	}

	public static Object getPastDateFromMonths( int months ) 
	{
		Calendar calendar = new GregorianCalendar();
		calendar.add(Calendar.MONTH, ( months * -1) );
		return  calendar.getTime();
	}

	public static int getYear( Date data ) 
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime( data );
		return  calendar.get( Calendar.YEAR );
	}

	public static int getMonth( Date data ) 
	{
		Calendar calendar = new GregorianCalendar();
		calendar.setTime( data );
		return  calendar.get( Calendar.MONTH );
	}
	
	public static Date createDate( int year, int month, int dayOfMonth )
	{
		GregorianCalendar gCalendar = new GregorianCalendar(year, month, dayOfMonth);
		return gCalendar.getTime();
	}
	
	public static int diferencaEntreDatas(Date dataInicial,Date dataFinal){  
		  
	     GregorianCalendar startTime = new GregorianCalendar();  
	     GregorianCalendar endTime = new GregorianCalendar();  
	       
	     GregorianCalendar curTime = new GregorianCalendar();  
	     GregorianCalendar baseTime = new GregorianCalendar();  
	  
	     startTime.setTime(dataInicial);  
	     endTime.setTime(dataFinal);  
	       
	     int dif_multiplier = 1;  
	       
	     /*Verifica a ordem de inicio das datas*/  
	     if( dataInicial.compareTo( dataFinal ) < 0 ){  
	         baseTime.setTime(dataFinal);  
	         curTime.setTime(dataInicial);  
	         dif_multiplier = 1;  
	     }else{  
	         baseTime.setTime(dataInicial);  
	         curTime.setTime(dataFinal);  
	         dif_multiplier = -1;  
	     }  
	       
	     int result_years = 0;  
	     int result_months = 0;  
	     int result_days = 0;  
	  
	     /*Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import acumulando*/  
	     /*no total de dias. Ja leva em consideracao ano bissesto*/  
	     while( curTime.get(GregorianCalendar.YEAR) < baseTime.get(GregorianCalendar.YEAR) ||  
	            curTime.get(GregorianCalendar.MONTH) < baseTime.get(GregorianCalendar.MONTH)  )  
	     {  
	           
	         int max_day = curTime.getActualMaximum( GregorianCalendar.DAY_OF_MONTH );  
	         result_months += max_day;  
	         curTime.add(GregorianCalendar.MONTH, 1);  
	           
	     }  
	       
	      /*Marca que é um saldo negativo ou positivo*/  
	     result_months = result_months*dif_multiplier;  
	       
	       
	      /*Retirna a diferenca de dias do total dos meses*/  
	     result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime.get(GregorianCalendar.DAY_OF_MONTH));  
	       
	     return result_years+result_months+result_days;  
	}  
	
	public static int diferencaEntreHoras(String horaInicial, String horaFinal ) 
	{
		int diferenca=0;
		try{
		// Define um formato de data igual ao da entrada esperada
				SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
				
				// Converte a entrada do usuário em um objeto data
				Date hora1 = sdf.parse(horaInicial);
				Date hora2 = sdf.parse(horaFinal);	
				
				long difMilli = hora2.getTime() - hora1.getTime();
				int timeInSeconds = (int) difMilli / 1000;
				int horas, minutos, segundos;
				
				horas = timeInSeconds / 3600;
				timeInSeconds = timeInSeconds - (horas * 3600);
				minutos = timeInSeconds / 60;
				timeInSeconds = timeInSeconds - (minutos * 60);
				segundos = timeInSeconds;
				diferenca=horas;
				
				/*System.out.println(horas + " hora(s) " + minutos + " minuto(s) "+ segundos + " segundo(s)");*/
		   }catch (ParseException p) {
			    System.out.println(p.getMessage());
			}
		return diferenca;
	}
	
	public static Calendar dateToCalendar(Date data) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(data);
		return calendar;
	}

	
	public static long calcularMillisEntreDuasDatas(Calendar dataInicial, Calendar dataFinal) {
		return (dataFinal.getTimeInMillis() - dataInicial.getTimeInMillis());
	}
	
	public static long calcularMillisEntreDuasDatas(Date dataInicial, Date dataFinal) {
		return DateUtil.calcularMillisEntreDuasDatas(DateUtil.dateToCalendar(dataInicial), DateUtil.dateToCalendar(dataFinal));
	}

	public static long calcularTempoTotalEmMillis(Calendar dataInicial, Calendar dataFinal) {
		return (dataInicial.getTimeInMillis() + dataFinal.getTimeInMillis());
	}
	
	public static long calcularTempoTotalEmMillis(Date dataInicial, Date dataFinal) {
		return DateUtil.calcularTempoTotalEmMillis(DateUtil.dateToCalendar(dataInicial), DateUtil.dateToCalendar(dataFinal));
	}
	
	public static Date nextDate(Date data) {
		Calendar nextDate = Calendar.getInstance();
		nextDate.setTime(data);
		nextDate.add(Calendar.MINUTE, 1);
		nextDate.set(Calendar.SECOND, 0);
		return nextDate.getTime();
		
	}
	
	public static boolean hasGap(Date dataInicial, Date dataFinal) {
		Date proximaData = DateUtil.nextDate(dataInicial);
		if (dataFinal.equals(proximaData) || dataFinal.before(dataInicial)) {
			return false;
		}
		return true;
	}

	public static Date timestampToDate(Date timestamp) {
		return DateUtil.dateToCalendar(timestamp).getTime();
	}
}