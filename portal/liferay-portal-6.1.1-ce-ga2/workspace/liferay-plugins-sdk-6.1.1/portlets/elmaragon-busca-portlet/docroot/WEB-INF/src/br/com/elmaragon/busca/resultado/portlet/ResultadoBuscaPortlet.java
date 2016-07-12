package br.com.elmaragon.busca.resultado.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.elmaragon.busca.resultado.Constantes;
import br.com.elmaragon.busca.resultado.vo.ResultadoVO;
import br.com.elmaragon.busca.util.BuscaUtil;
import br.com.elmaragon.busca.util.Search;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.StringPool;
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

		String prefCategoriaProduto = preferences.getValue(
				Constantes.PREF_CATEGORIA_PRODUTO, StringPool.SPACE);
		String prefCategoriaOutro = preferences.getValue(
				Constantes.PREF_CATEGORIA_OUTRO, StringPool.SPACE);
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
					|| tipoConteudo.equals(Constantes.TIPO_CONTEUDO_OUTROS)) {
				categoria = prefCategoriaOutro;
				tipoConteudo = Constantes.TIPO_CONTEUDO_OUTROS;
			} else if (tipoConteudo.equals(Constantes.TIPO_CONTEUDO_PRODUTO)) {
				categoria = prefCategoriaProduto;
				tipoConteudo = Constantes.TIPO_CONTEUDO_PRODUTO;
			}

			// verificando a ordenacao

			String ordenacao = null;
			boolean direcao = true;

			ordenacao = Field.MODIFIED_DATE;

			// realizando a busca
			Search busca = new Search();
			List<ResultadoVO> resultados = null;

			int resultadosPorPag = Constantes.QUANTIDADE_RESULTADO_DEFAULT;

			int pagina = busca.getPage(httpReq);
			int inicio = (pagina * resultadosPorPag) - resultadosPorPag;
			int fim = inicio + resultadosPorPag;
			int totalConteudos = 0;

			try {

				resultados = busca.realizaBusca(request, termosBusca,
						categoria, ordenacao, direcao, inicio, fim,
						tipoConteudo);

				totalConteudos = busca.getTotalConteudos(request, termosBusca,
						categoria, ordenacao, direcao, QueryUtil.ALL_POS,
						QueryUtil.ALL_POS, tipoConteudo);
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
