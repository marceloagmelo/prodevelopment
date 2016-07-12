package br.com.prodevelopment.trabalheconosco.validacao;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

	public static boolean isEmail(String valor) {
		// TODO Auto-generated method stub
		boolean retorno = true;
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,7}$");
		Matcher m = p.matcher(valor);
	    if (!m.find()) {
	    	retorno = false;
	    }
		return retorno;
	}
}
