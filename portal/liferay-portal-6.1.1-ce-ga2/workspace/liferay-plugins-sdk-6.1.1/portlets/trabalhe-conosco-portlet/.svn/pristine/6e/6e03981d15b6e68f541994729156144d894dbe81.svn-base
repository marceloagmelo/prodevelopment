package br.com.prodevelopment.trabalheconosco.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;

import br.com.prodevelopment.trabalheconosco.util.DateUtil;
import br.com.prodevelopment.trabalheconosco.vo.CargoVO;
import br.com.prodevelopment.trabalheconosco.vo.TrabalheConoscoVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class TrabalheConoscoAction {
	public static List<CargoVO> montarListaCargos(String texto) {
		List<CargoVO> lista = new ArrayList<CargoVO>();

		// uma palavra por vez
		String[] words = texto.trim().split("\n");
		for (int i = 0; i < words.length; i++) {
			CargoVO cargoVO = new CargoVO();
			cargoVO.setId(words[i]);
			cargoVO.setDescricao(words[i]);

			// Adicionar na lista
			lista.add(cargoVO);
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

	public static void enviar(TrabalheConoscoVO trabalheConoscoVO, String resourceBundle, Locale locale) throws Exception {
		enviarEmail(trabalheConoscoVO, resourceBundle, locale);
	}

	private static void enviarEmail(TrabalheConoscoVO trabalheConoscoVO, String resourceBundle, Locale locale)
			throws Exception {
		StringBuffer bfCorpoEmail = new StringBuffer();

		String sDataHora = DateUtil.dateToStringWithHour(new Date());

		ResourceBundle resource  = ResourceBundle.getBundle(resourceBundle, locale);

		String endereco = resource.getString("label.trabalheConosco.endereco");

		bfCorpoEmail
				.append("<i>Este email foi gerado automaticamente pelo portal.</i>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<b>Trabalhe Conosco</b>");
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
		bfCorpoEmail.append("<td>" + trabalheConoscoVO.getNomeUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Email: </td>");
		bfCorpoEmail.append("<td>" + trabalheConoscoVO.getEmailUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>"+endereco+": </td>");
		bfCorpoEmail.append("<td>"+trabalheConoscoVO.getEndereco()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Cep: </td>");
		bfCorpoEmail.append("<td>"+trabalheConoscoVO.getCep()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Cidade: </td>");
		bfCorpoEmail.append("<td>"+trabalheConoscoVO.getCidade()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Estado: </td>");
		bfCorpoEmail.append("<td>"+trabalheConoscoVO.getEstado()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Telefone: </td>");
		StringBuffer telefone = new StringBuffer();
		if (Validator.isNotNull(trabalheConoscoVO.getDdd())) {
			telefone.append("("+trabalheConoscoVO.getDdd()+") ");
		}
		telefone.append(trabalheConoscoVO.getTelefone());
		bfCorpoEmail.append("<td>"+telefone.toString()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail
				.append("<td colspan='2'><center><b><i>Dados Profissionais<b><i></center></td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Cargo: </td>");
		bfCorpoEmail.append("<td>" + trabalheConoscoVO.getCargo() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Objetivo: </td>");
		bfCorpoEmail.append("<td>" + trabalheConoscoVO.getResumo().replaceAll("\n", "<br>") + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("</table>");

		String body = bfCorpoEmail.toString();
		String subject = "Trabalhe Conosco (" + trabalheConoscoVO.getCargo()
				+ ")";
		String fromName = trabalheConoscoVO.getNomeUsuario();
		String fromAddress = trabalheConoscoVO.getEmailUsuario();
		String toName = "Trabalhe Conosco";

		Pattern p = Pattern.compile("\n");
		Matcher m = p.matcher(trabalheConoscoVO.getEmailResponsavel());
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
