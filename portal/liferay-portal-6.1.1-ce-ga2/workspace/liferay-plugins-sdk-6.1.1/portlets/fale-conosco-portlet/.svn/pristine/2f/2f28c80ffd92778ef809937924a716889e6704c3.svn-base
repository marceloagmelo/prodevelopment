package br.com.prodevelopment.faleconosco.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import br.com.prodevelopment.faleconosco.util.DateUtil;
import br.com.prodevelopment.faleconosco.vo.AssuntoVO;
import br.com.prodevelopment.faleconosco.vo.FaleConoscoVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class FaleConoscoAction {

	public static List<AssuntoVO> montarListaAssuntos(String texto) {
		List<AssuntoVO> lista = new ArrayList<AssuntoVO>();

		// uma palavra por vez
		String[] words = texto.trim().split("\n");
		for (int i = 0; i < words.length; i++) {
			AssuntoVO assuntoVO = new AssuntoVO();
			assuntoVO.setId(words[i]);
			assuntoVO.setDescricao(words[i]);

			// Adicionar na lista
			lista.add(assuntoVO);
		}

		return lista;
	}

	public static List<String> montarListaEstados() {
		List<String> lista = new ArrayList<String>();

		// Adicionar na lista
		lista.add("AC");
		lista.add("AL");
		lista.add("AM");
		lista.add("AP");
		lista.add("BA");
		lista.add("CE");
		lista.add("DF");
		lista.add("ES");
		lista.add("GO");
		lista.add("MA");
		lista.add("MG");
		lista.add("MS");
		lista.add("MT");
		lista.add("PA");
		lista.add("PB");
		lista.add("PE");
		lista.add("PI");
		lista.add("PR");
		lista.add("RJ");
		lista.add("RN");
		lista.add("RO");
		lista.add("RR");
		lista.add("RS");
		lista.add("SC");
		lista.add("SE");
		lista.add("SP");
		lista.add("TO");

		return lista;
	}

	public static void enviar(FaleConoscoVO faleConoscoVO) throws Exception {
		enviarEmail(faleConoscoVO);
	}

	private static void enviarEmail(FaleConoscoVO faleConoscoVO)
			throws Exception {
		StringBuffer bfCorpoEmail = new StringBuffer();

		String sDataHora = DateUtil.dateToStringWithHour(new Date());

		bfCorpoEmail
				.append("<i>Este email foi gerado automaticamente pelo portal.</i>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<b>Fale Conosco</b>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<table border='1'>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Data: </td>");
		bfCorpoEmail.append("<td>" + sDataHora + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail
				.append("<td colspan='2'><center><b><i>Contato<b><i></center></td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Nome: </td>");
		bfCorpoEmail.append("<td>" + faleConoscoVO.getNomeUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Email: </td>");
		bfCorpoEmail.append("<td>" + faleConoscoVO.getEmailUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail
				.append("<td colspan='2'><center><b><i>Mensagem<b><i></center></td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Assunto: </td>");
		bfCorpoEmail.append("<td>" + faleConoscoVO.getAssunto() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Mensagem: </td>");
		bfCorpoEmail.append("<td>" + faleConoscoVO.getMensagem().replaceAll("\n", "<br>") + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("</table>");

		String body = bfCorpoEmail.toString();
		String subject = "Fale Conosco (" + faleConoscoVO.getAssunto()
				+ ")";
		String fromName = faleConoscoVO.getNomeUsuario();
		String fromAddress = faleConoscoVO.getEmailUsuario();
		String toName = "Fale Conosco";

		Pattern p = Pattern.compile("\n");
		Matcher m = p.matcher(faleConoscoVO.getEmailResponsavel());
		String emails = m.replaceAll("#");

		String[] aEmails = emails.split("#");

		InternetAddress[] aToCC = new InternetAddress[aEmails.length-1];

		String toAddress = "";

		int contador = 0;
		for (String email : aEmails) {
			emails = email;
			if (contador == 0) {
				toAddress = email;
			}
			else {
				InternetAddress toCC = new InternetAddress(email, toName);
				aToCC[contador-1] = toCC;
			}
			contador++;
		}
		InternetAddress from = new InternetAddress(fromAddress, fromName);

		InternetAddress to = new InternetAddress(toAddress, toName);

		MailMessage message = new MailMessage(from, to, subject, body, true);
		message.setCC(aToCC);

		MailServiceUtil.sendEmail(message);
	}

	public static ThemeDisplay getDadosPortal(ActionRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}

}
