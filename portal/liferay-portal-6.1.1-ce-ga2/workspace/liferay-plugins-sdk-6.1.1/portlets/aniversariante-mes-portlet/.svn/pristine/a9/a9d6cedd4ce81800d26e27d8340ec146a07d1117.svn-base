package br.com.prodevelopment.aniversariantemes.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;

import br.com.prodevelopment.aniversariantemes.Constantes;
import br.com.prodevelopment.aniversariantemes.util.DateUtil;
import br.com.prodevelopment.aniversariantemes.util.Helper;
import br.com.prodevelopment.aniversariantemes.vo.UsuarioVO;

import com.liferay.mail.service.MailServiceUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

public class AniversarianteAction {

	public static void inicio(RenderRequest req, RenderResponse res,
			List<User> users, int maximoRegistrosHome) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) req
				.getAttribute(WebKeys.THEME_DISPLAY);

		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();

		Date dataAtual = new Date();
		int mesAtual = dataAtual.getMonth();

		for (User usuario : users) {
			if (!usuario.isDefaultUser()) {
				if (mesAtual == usuario.getBirthday().getMonth()) {
					UsuarioVO usuarioVO = getUsuarioVO(usuario.getUserId());
					usuarioVO
							.setUrlImagem(usuario.getPortraitURL(themeDisplay));

					lista.add(usuarioVO);
				}
			}
		}
		if (lista.size() == 0) {
			SessionMessages.add(req, "mensagem.aniversario.nao.existem");
		} else {
			lista = ordenarLista(lista);
		}
		req.setAttribute("listaUsuario", lista);

		PortletURL verTodosURL = res.createActionURL();
		verTodosURL.setWindowState(WindowState.MAXIMIZED);
		req.setAttribute(Constantes.NOME_PARAM_VER_TODOS_URL,
				verTodosURL.toString());
	}

	public static void enviar(ActionRequest request, ActionResponse response,
			long id, String mensagem) throws Exception {
		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		
		String resourceBundle = ParamUtil.getString(request,
				Constantes.RESOURCE_BUNDLE);
		ResourceBundle resource = ResourceBundle.getBundle(resourceBundle,
				PortalUtil.getLocale(httpReq));

		String emailRemetente = resource.getString("email.remetente");
		String assunto = resource.getString("email.assunto");

		List<String> errors = new ArrayList<String>();
		UsuarioVO usuarioVO = null;
		if (Validator.isNotNull(mensagem)) {
			usuarioVO = getUsuarioVO(id);
			usuarioVO.setMensagem(mensagem);

			ThemeDisplay themeDisplay = (ThemeDisplay) request
					.getAttribute(WebKeys.THEME_DISPLAY);
			long userId = themeDisplay.getUserId();
			UsuarioVO usuarioOrigemVO = getUsuarioVO(userId);

			String body = mensagem.replaceAll("\n", "<br>");
			body = body + "<br><br><b>" + usuarioOrigemVO.getNome() + "</b>";
			String subject = assunto;
			String fromName = usuarioOrigemVO.getNome();
			String fromAddress = emailRemetente;
			String toName = usuarioVO.getNome();
			String toAddress = usuarioVO.getEmail();

			InternetAddress from = new InternetAddress(fromAddress, fromName);

			InternetAddress to = new InternetAddress(toAddress, toName);

			MailMessage message = new MailMessage(from, to, subject, body, true);

			MailServiceUtil.sendEmail(message);

			SessionMessages.add(request,
					"mensagem.aniversario.mensagem.enviada.sucesso");
		} else {
			errors.add("mensagem.aniversariante.mensagem.obrigatoria");
			for (String error : errors) {
				SessionErrors.add(request, error);
			}
		}
		response.setRenderParameter(Constantes.NOME_PARAM_METODO,
				Constantes.METODO_PREPARAR_MENSAGEM);
		response.setRenderParameter(Constantes.NOME_PARAM_ID,
				String.valueOf(id));
	}

	private static UsuarioVO getUsuarioVO(long id) throws Exception {
		UsuarioVO usuarioVO = new UsuarioVO();

		User usuario = UserLocalServiceUtil.getUserById(id);

		if (usuario != null) {
			usuarioVO.setNome(usuario.getFirstName() + Constantes.ESPACO
					+ usuario.getLastName());
			usuarioVO.setDiaAniversario(DateUtil.getDiaDate(usuario
					.getBirthday()));
			usuarioVO.setMesAniversario(DateUtil.getNomeMesCorrente(
					usuario.getBirthday().getMonth() + 1).substring(0, 3));
			usuarioVO.setAnoAniversario(DateUtil.getAnoDate(
					DateUtil.getDataAtual(), "yy"));
			usuarioVO.setImagem(String.valueOf(usuario.getPortraitId()));
			usuarioVO.setId(String.valueOf(usuario.getUserId()));
			usuarioVO.setEmail(usuario.getEmailAddress());
			usuarioVO.setDia(usuarioVO.getDiaAniversario());
			usuarioVO.setMes(DateUtil.getMesDate(usuario.getBirthday()));
		}
		return usuarioVO;
	}

	public static void prepararMensagem(RenderRequest req, RenderResponse res,
			long id) throws Exception {

		UsuarioVO usuarioVO = getUsuarioVO(id);

		PortletURL enviarURL = res.createActionURL();
		enviarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.METODO_ENVIAR_MENSAGEM);
		enviarURL.setWindowState(WindowState.MAXIMIZED);
		req.setAttribute(Constantes.NOME_PARAM_ENVIAR_MENSAGEM_URL,
				enviarURL.toString());
		//
		PortletURL cancelarURL = res.createActionURL();
		cancelarURL.setParameter(Constantes.PORTLET_ACTION,
				Constantes.METODO_CANCELAR);
		cancelarURL.setWindowState(WindowState.NORMAL);
		req.setAttribute(Constantes.NOME_PARAM_CANCELAR_URL,
				cancelarURL.toString());
		//
		req.setAttribute(Constantes.NOME_PARAM_USUARIO_VO, usuarioVO);
	}

	private static List<UsuarioVO> ordenarLista(List<UsuarioVO> lista) {
		List<UsuarioVO> retorno = new ArrayList<UsuarioVO>(lista.size());

		HashMap<String, UsuarioVO> map = new HashMap<String, UsuarioVO>();
		for (UsuarioVO usuarioVO : lista) {
			usuarioVO.setAnoAniversario(Helper.zerosEsquerda(
					String.valueOf(Integer.parseInt(usuarioVO
							.getAnoAniversario())), 2));

			map.put(usuarioVO.getMes() + usuarioVO.getDia()
					+ usuarioVO.getNome(), usuarioVO);
		}

		Object[] key = map.keySet().toArray();
		Arrays.sort(key);

		for (int i = 0; i < key.length; i++) {
			UsuarioVO usuarioVO = (UsuarioVO) map.get(key[i]);
			retorno.add(usuarioVO);
		}

		return retorno;
	}
}
