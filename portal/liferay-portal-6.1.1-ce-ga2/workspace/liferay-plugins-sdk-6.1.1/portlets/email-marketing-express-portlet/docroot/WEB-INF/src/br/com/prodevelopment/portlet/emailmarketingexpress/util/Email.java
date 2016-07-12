package br.com.prodevelopment.portlet.emailmarketingexpress.util;

import java.io.File;
import java.util.List;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;

public class Email {

	/**
	 * Send a single email.
	 */
	public static void sendEmail(String aFromEmailAddr, String aToEmailAddr,
			String aSubject, String aBody, List<File> listaAnexos) {
		try {

			MailMessage mailMessage = new MailMessage(new InternetAddress(
					aFromEmailAddr), new InternetAddress(aToEmailAddr),
					aSubject, aBody, true);
			if (listaAnexos != null) {
				for (File arquivo : listaAnexos) {
					mailMessage.addFileAttachment(arquivo, arquivo.getName());
				}
			}
			mailMessage.setReplyTo(new InternetAddress[]
					{
					    new InternetAddress(aFromEmailAddr)
					});
			MailServiceUtil.sendEmail(mailMessage);
		} catch (MessagingException ex) {
			ex.getMessage();
		}

	}
}
