package br.com.prodevelopment.conteudo.util;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;

public class Email {

	/**
	  * Send a single email.
	  */
	  public static void sendEmail(String aFromEmailAddr, String aToEmailAddr, String aSubject, String aBody){
		  try {

	        MailMessage mailMessage = new MailMessage(new InternetAddress(aFromEmailAddr), new InternetAddress(aToEmailAddr), aSubject, aBody, true);
			MailServiceUtil.sendEmail(mailMessage);
	    }
	    catch (MessagingException ex){
	    	ex.getMessage();
	    }

	  }

}
