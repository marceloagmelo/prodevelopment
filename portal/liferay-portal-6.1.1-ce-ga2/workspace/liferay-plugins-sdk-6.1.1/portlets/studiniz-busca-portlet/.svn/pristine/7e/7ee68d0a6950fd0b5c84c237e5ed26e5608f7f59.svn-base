package br.com.studiniz.busca.resultado.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.studiniz.busca.resultado.Constantes;
import br.com.studiniz.busca.resultado.vo.ResultadoVO;
import br.com.studiniz.busca.util.BuscaUtil;
import br.com.studiniz.busca.util.Search;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ResultadoBuscaPortlet
 */
public class ResultadoBuscaPortlet extends MVCPortlet {
	protected String naoConfiguradoJSP;

	@Override
	public void init() throws PortletException {

		naoConfiguradoJSP = getInitParameter(Constantes.JSP_NAO_CONFIGURADO);

		Constantes.NOME_PARAM = getInitParameter(Constantes.NOME_PARAM_INIT);
		Constantes.NOME_PARAM_ID = getInitParameter(Constantes.NOME_PARAM_ID_INIT);

		// carregando a lista de stopwords
		new BuscaUtil().carregaPalavrasProibidas();

		super.init();
	}

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		HttpServletRequest httpReq = PortalUtil
				.getOriginalServletRequest(PortalUtil
						.getHttpServletRequest(request));

		// verificando a estrutura que sera utilizada na busca
		PortletPreferences preferences = request.getPreferences();

		String prefQuatidadeResultado = preferences.getValue(
				Constantes.PREF_QUANTIDADE_RESULTADO,
				Constantes.QUANTIDADE_RESULTADO_DEFAULT);
		String prefConfigurado = preferences.getValue(
				Constantes.PREF_CONFIGURADO, Constantes.N);

		if (Constantes.S.equals(prefConfigurado)) {
			String termosBusca = httpReq.getParameter(Constantes.NOME_PARAM);
			if (Validator.isNull(termosBusca)) {
				HttpServletRequest httpReq1 = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(request));
				termosBusca = httpReq1.getParameter(Constantes.NOME_PARAM);
			}
			String tipoConteudo = httpReq
					.getParameter(Constantes.TIPO_CONTEUDO);
			if (Validator.isNull(tipoConteudo)) {
				HttpServletRequest httpReq1 = PortalUtil
						.getOriginalServletRequest(PortalUtil
								.getHttpServletRequest(request));
				tipoConteudo = httpReq1.getParameter(Constantes.TIPO_CONTEUDO);
			}

			String page = httpReq.getParameter("page");

			if (page == null || page.isEmpty()) {
				jogandoParametrosNaSessao(httpReq);
			} else {
				HttpSession sessao = httpReq.getSession();

				termosBusca = (String) sessao.getAttribute("termosBusca");
				tipoConteudo = (String) sessao.getAttribute("tipoConteudo");
			}

			String categoria = null;

			if (Validator.isNull(tipoConteudo)
					|| tipoConteudo.equals(Constantes.TIPO_CONTEUDO)) {
				tipoConteudo = Constantes.TIPO_CONTEUDO;
			} else {
				tipoConteudo = Constantes.TIPO_DOCUMENTO;
			}

			// realizando a busca
			Search busca = new Search();
			List<ResultadoVO> resultados = null;

			int resultadosPorPag = Integer.parseInt(prefQuatidadeResultado);

			int pagina = busca.getPage(httpReq);
			int inicio = (pagina * resultadosPorPag) - resultadosPorPag;
			int fim = inicio + resultadosPorPag;
			int totalConteudos = 0;

			try {
				if (Constantes.TIPO_CONTEUDO.equals(tipoConteudo)) {
					resultados = busca.buscaConteudos(request, termosBusca,
							inicio, fim);
					totalConteudos = busca.getTotalConteudos(request,
							termosBusca, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				} else {
					resultados = busca.buscaDocumentos(request, termosBusca,
							inicio, fim);

					totalConteudos = busca.totalDocumentos(request,
							termosBusca, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			request.setAttribute("resultados", resultados);
			request.setAttribute("termosBusca", termosBusca);
			request.setAttribute(Constantes.TIPO_CONTEUDO, tipoConteudo);

			request.setAttribute("total", totalConteudos);
			request.setAttribute("page", busca.getPage(httpReq));
			request.setAttribute("pageSize", resultadosPorPag);

			super.render(request, response);
		} else {
			SessionMessages.add(request, "mensagem.portletNaoConfigurado");
			include(naoConfiguradoJSP, request, response);
		}
	}

	private void jogandoParametrosNaSessao(HttpServletRequest httpReq) {

		String termosBusca = httpReq.getParameter(Constantes.NOME_PARAM);
		String tipoConteudo = httpReq.getParameter(Constantes.TIPO_CONTEUDO);

		HttpSession sessao = httpReq.getSession();

		sessao.setAttribute("termosBusca", termosBusca);
		sessao.setAttribute("tipoConteudo", tipoConteudo);
	}

}
