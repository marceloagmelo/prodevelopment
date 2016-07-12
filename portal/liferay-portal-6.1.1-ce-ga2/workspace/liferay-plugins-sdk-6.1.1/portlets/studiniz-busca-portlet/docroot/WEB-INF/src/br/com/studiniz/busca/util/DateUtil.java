package br.com.studiniz.busca.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

import com.liferay.portal.kernel.util.Validator;

public class DateUtil {

	public static final Locale LOCALE_BRASIL = new Locale("pt", "BR");

	public static String getFormatDate(String date) {
		
		if(date == null || date.isEmpty())
			return null;
		
		StringBuilder sb = new StringBuilder();
		
		//dia
		sb.append(date.substring(6,8));
		sb.append("/");
		
		//mes
		sb.append(date.substring(4,6));
		sb.append("/");
		
		//ano
		sb.append(date.substring(0,4));
		
		sb.append(" ");
		
		//hora
		sb.append(date.substring(8,10));
		sb.append(":");
		
		//minuto
		sb.append(date.substring(10,12));

		return sb.toString();
	}

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
	 * Formata uma variavel do tipo date para uma String formato dd/MM/yyyy �s
	 * HH/mm.
	 * 
	 * @param Date
	 *            data a ser tratada.
	 * @return String data formatada.
	 */
	public static String dateToStringWithHour(Date data) {
		String result = null;
		if (data != null) {
			result = new SimpleDateFormat("dd/MM/yyyy - HH:mm",
					LOCALE_BRASIL).format(data);
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
	 * M�todo para comparar as das e retornar o numero de dias de diferen�a
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

		// Marca que � um saldo negativo ou positivo
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
		// m�s
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
}