package br.com.prodevelopment.banner.util;

public class DateUtil {
	
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

}
