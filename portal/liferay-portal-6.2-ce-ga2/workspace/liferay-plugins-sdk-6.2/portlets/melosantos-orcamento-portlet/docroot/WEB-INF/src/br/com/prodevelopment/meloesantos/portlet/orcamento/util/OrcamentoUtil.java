package br.com.prodevelopment.meloesantos.portlet.orcamento.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.RenderRequest;

import br.com.prodevelopment.meloesantos.portlet.orcamento.util.DateUtil;
import br.com.prodevelopment.meloesantos.portlet.orcamento.vo.OrcamentoVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

public class OrcamentoUtil {
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

	public static List<String> montarListaTipoResposta() {
		List<String> lista = new ArrayList<String>();

		// Adicionar na lista
		lista.add("Telefone");
		lista.add("E-mail");

		return lista;
	}

	public static void enviar(OrcamentoVO orcamentoVO, String resourceBundle, Locale locale) throws Exception {
		enviarEmail(orcamentoVO, resourceBundle, locale);
	}

	private static void enviarEmail(OrcamentoVO orcamentoVO, String resourceBundle, Locale locale)
			throws Exception {
		StringBuffer bfCorpoEmail = new StringBuffer();

		String sDataHora = DateUtil.dateToStringWithHour(new Date());

		ResourceBundle resource  = ResourceBundle.getBundle(resourceBundle, locale);

		String orcamento = resource.getString("label.orcamento.tituloPortlet");
		String endereco = resource.getString("label.orcamento.endereco");

		bfCorpoEmail
				.append("<i>Este email foi gerado automaticamente pelo portal.</i>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<br>");
		bfCorpoEmail.append("<b>"+orcamento+"</b>");
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
		if (Validator.isNotNull(orcamentoVO.getNomeEmpresa())) {
			bfCorpoEmail.append("<tr>");
			bfCorpoEmail.append("<td>Empresa: </td>");
			bfCorpoEmail.append("<td>" + orcamentoVO.getNomeEmpresa() + "</td>");
			bfCorpoEmail.append("</tr>");
		}
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Nome: </td>");
		bfCorpoEmail.append("<td>" + orcamentoVO.getNomeUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Email: </td>");
		bfCorpoEmail.append("<td>" + orcamentoVO.getEmailUsuario() + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>"+endereco+": </td>");
		bfCorpoEmail.append("<td>"+orcamentoVO.getEndereco()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Cep: </td>");
		bfCorpoEmail.append("<td>"+orcamentoVO.getCep()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Cidade: </td>");
		bfCorpoEmail.append("<td>"+orcamentoVO.getCidade()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Estado: </td>");
		bfCorpoEmail.append("<td>"+orcamentoVO.getEstado()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Telefone: </td>");
		StringBuffer telefone = new StringBuffer();
		if (Validator.isNotNull(orcamentoVO.getDdd())) {
			telefone.append("("+orcamentoVO.getDdd()+") ");
		}
		telefone.append(orcamentoVO.getTelefone());
		bfCorpoEmail.append("<td>"+telefone.toString()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>Tipo Resposta: </td>");
		bfCorpoEmail.append("<td>"+orcamentoVO.getTipoResposta()+"</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail
				.append("<td colspan='2'><center><b><i>"+orcamento+"<b><i></center></td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("<tr>");
		bfCorpoEmail.append("<td>"+orcamento+": </td>");
		bfCorpoEmail.append("<td>" + orcamentoVO.getSolicitacao().replaceAll("\n", "<br>") + "</td>");
		bfCorpoEmail.append("</tr>");
		bfCorpoEmail.append("</table>");

		String body = bfCorpoEmail.toString();
		String subject = "Portal - "+orcamento;
		String fromName = orcamentoVO.getNomeUsuario();
		String fromAddress = orcamentoVO.getEmailUsuario();
		String toName = orcamentoVO.getRemetente();

		Pattern p = Pattern.compile("\n");
		Matcher m = p.matcher(orcamentoVO.getEmailResponsavel());
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
				InternetAddress toCC = new InternetAddress(email, toName, "UTF-8");
				aToCC[contador-1] = toCC;
			}
			contador++;
		}
		InternetAddress from = new InternetAddress(fromAddress, fromName, "UTF-8");

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

	public static ThemeDisplay getDadosPortal(RenderRequest request) {
		// Objeto do portal
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		return themeDisplay;
	}
}
