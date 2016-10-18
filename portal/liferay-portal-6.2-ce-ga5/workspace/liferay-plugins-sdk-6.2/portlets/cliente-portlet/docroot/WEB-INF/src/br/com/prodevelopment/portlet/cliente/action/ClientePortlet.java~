package br.com.prodevelopment.portlet.cliente.action;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.MimeResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import br.com.prodevelopment.cliente.ClienteAlteradoOutroUsuarioException;
import br.com.prodevelopment.cliente.ClienteCNPJDuplicadoException;
import br.com.prodevelopment.cliente.ClienteCNPJInvalidoException;
import br.com.prodevelopment.cliente.ClienteCPFDuplicadoException;
import br.com.prodevelopment.cliente.ClienteCPFInvalidoException;
import br.com.prodevelopment.cliente.ClienteDataLimiteMaxCreditoInvalidaException;
import br.com.prodevelopment.cliente.ClienteDataNascimentoInvalidaException;
import br.com.prodevelopment.cliente.ClienteEmailInvalidoException;
import br.com.prodevelopment.cliente.ClienteNomeObrigatorioException;
import br.com.prodevelopment.cliente.ClienteRGDataEmissaoInvalidaException;
import br.com.prodevelopment.cliente.ClienteRGInscricaoMunDuplicadoException;
import br.com.prodevelopment.cliente.ClienteUsuarioDuplicadoException;
import br.com.prodevelopment.cliente.model.Cliente;
import br.com.prodevelopment.cliente.service.ClienteLocalServiceUtil;
import br.com.prodevelopment.contato.EnderecoEmailEnderecoInvalidoException;
import br.com.prodevelopment.contato.EnderecoEmailEnderecoObrigatotioException;
import br.com.prodevelopment.contato.EnderecoEmailTipoObrigatotioException;
import br.com.prodevelopment.contato.EnderecoLogradouroObrigatotioException;
import br.com.prodevelopment.contato.EnderecoTipoObrigatotioException;
import br.com.prodevelopment.contato.TelefoneDDDInvalidoException;
import br.com.prodevelopment.contato.TelefoneDDDObrigatotioException;
import br.com.prodevelopment.contato.TelefoneNumeroInvalidoException;
import br.com.prodevelopment.contato.TelefoneNumeroObrigatotioException;
import br.com.prodevelopment.contato.TelefoneTipoObrigatotioException;
import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.portlet.cliente.Constantes;
import br.com.prodevelopment.portlet.cliente.util.ClienteUtil;
import br.com.prodevelopment.portlet.cliente.util.EnderecoEmailUtil;
import br.com.prodevelopment.portlet.cliente.util.Helper;
import br.com.prodevelopment.portlet.cliente.util.MunicipioUtil;
import br.com.prodevelopment.portlet.cliente.util.TelefoneUtil;

import com.liferay.portal.ImageTypeException;
import com.liferay.portal.NoSuchRepositoryException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.image.ImageBag;
import com.liferay.portal.kernel.image.ImageToolUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Region;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ClientePortlet
 */
public class ClientePortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse) throws PortletException, IOException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String portletTitulo = Helper.getTituloPortlet(renderRequest,
					renderResponse, themeDisplay);

			renderRequest
					.setAttribute(Constantes.PORTLET_TITULO, portletTitulo);

			ClienteUtil.getCliente(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long clienteId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_CLIENTE_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		// Recuperar campos do request
		String nome = ParamUtil.getString(actionRequest, Constantes.CAMPO_NOME);
		String tipoPessoa = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_TIPO_PESSOA);
		String observacao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_OBSERVACAO);
		String rg = ParamUtil.getString(actionRequest, Constantes.CAMPO_RG);
		String inscricaoMun = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_INSCRICAO_MUN);
		String rgInscricaoMun = (Constantes.PESSOA_FISICA.equals(tipoPessoa) ? rg
				: inscricaoMun);
		String rgOrgaoEmissor = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_ORGAO_EMISSOR);
		String rgDataEmissao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_DATA_EMISSAO);
		String cpf = ParamUtil.getString(actionRequest, Constantes.CAMPO_CPF);
		String cnpj = ParamUtil.getString(actionRequest, Constantes.CAMPO_CNPJ);
		String cpfCnpj = (Constantes.PESSOA_FISICA.equals(tipoPessoa) ? cpf
				: cnpj);
		String sexo = ParamUtil.getString(actionRequest, Constantes.CAMPO_SEXO);
		String estadoCivil = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ESTADO_CIVIL);
		String dataNascimento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_NASCIMENTO);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);
		double valorLimiteMaximoCredito = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VALOR_LIM_MAX_CREDITO);
		String dataLimiteMaximoCredito = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_LIM_MAX_CREDITO);
		double valorLimiteMaximoCheque = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VALOR_LIM_MAX_CHEQUE);
		int qtdeLimiteMaximoCheque = ParamUtil.getInteger(actionRequest,
				Constantes.CAMPO_QTDE_LIM_MAX_CHEQUE);
		String endComLogradouro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_LOGRADOURO);
		String endComNumero = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_NUMERO);
		String endComComplemento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_COMPLEMENTO);
		String endComCep = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_CEP);
		String endComBairro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_BAIRRO);
		long endComCidade = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_END_COM_CIDADE);
		String endComUf = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_UF);
		String endComPais = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_COM_PAIS);
		String endResLogradouro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_LOGRADOURO);
		String endResNumero = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_NUMERO);
		String endResComplemento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_COMPLEMENTO);
		String endResCep = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_CEP);
		String endResBairro = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_BAIRRO);
		long endResCidade = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_END_RES_CIDADE);
		String endResUf = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_UF);
		String endResPais = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_END_RES_PAIS);

		try {
			List<Telefone> telefones = TelefoneUtil.getTelefones(actionRequest);
			List<EnderecoEmail> enderecosEmail = EnderecoEmailUtil
					.getEnderecosEmail(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Cliente.class.getName(), actionRequest);

			boolean deleteLogo = ParamUtil.getBoolean(actionRequest,
					"deleteLogo");

			if (deleteLogo) {
				ClienteLocalServiceUtil.deleteFoto(clienteId);
			}

			if (Constantes.ADD.equals(acao)) {
				ClienteLocalServiceUtil.addCliente(themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nome, tipoPessoa, observacao,
						rgInscricaoMun, rgOrgaoEmissor, rgDataEmissao, cpfCnpj,
						sexo, estadoCivil, dataNascimento, endComLogradouro,
						endComNumero, endComComplemento, endComCep,
						endComBairro, endComCidade, endComUf, endComPais,
						endResLogradouro, endResNumero, endResComplemento,
						endResCep, endResBairro, endResCidade, endResUf,
						endResPais, valorLimiteMaximoCredito,
						dataLimiteMaximoCredito, valorLimiteMaximoCheque,
						qtdeLimiteMaximoCheque, Constantes.VERSAO_INICIAL,
						enderecosEmail, telefones, serviceContext);

				SessionMessages.add(actionRequest,
						"mensagem.cliente.adicionado.sucesso");
			} else {
				ClienteLocalServiceUtil.update(clienteId,
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nome, tipoPessoa, observacao,
						rgInscricaoMun, rgOrgaoEmissor, rgDataEmissao, cpfCnpj,
						sexo, estadoCivil, dataNascimento, endComLogradouro,
						endComNumero, endComComplemento, endComCep,
						endComBairro, endComCidade, endComUf, endComPais,
						endResLogradouro, endResNumero, endResComplemento,
						endResCep, endResBairro, endResCidade, endResUf,
						endResPais, valorLimiteMaximoCredito,
						dataLimiteMaximoCredito, valorLimiteMaximoCheque,
						qtdeLimiteMaximoCheque, versao, enderecosEmail,
						telefones, serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.cliente.alterado.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof ClienteRGDataEmissaoInvalidaException
					|| e instanceof ClienteDataNascimentoInvalidaException
					|| e instanceof ClienteDataLimiteMaxCreditoInvalidaException
					|| e instanceof ClienteNomeObrigatorioException
					|| e instanceof ClienteCPFInvalidoException
					|| e instanceof ClienteCPFDuplicadoException
					|| e instanceof ClienteCNPJInvalidoException
					|| e instanceof ClienteCNPJDuplicadoException
					|| e instanceof ClienteRGInscricaoMunDuplicadoException
					|| e instanceof ClienteEmailInvalidoException
					|| e instanceof ClienteUsuarioDuplicadoException
					|| e instanceof ClienteAlteradoOutroUsuarioException
					|| e instanceof TelefoneTipoObrigatotioException
					|| e instanceof TelefoneDDDObrigatotioException
					|| e instanceof TelefoneDDDInvalidoException
					|| e instanceof TelefoneNumeroObrigatotioException
					|| e instanceof TelefoneNumeroInvalidoException
					|| e instanceof EnderecoEmailTipoObrigatotioException
					|| e instanceof EnderecoEmailEnderecoObrigatotioException
					|| e instanceof EnderecoEmailEnderecoInvalidoException
					|| e instanceof EnderecoTipoObrigatotioException
					|| e instanceof EnderecoLogradouroObrigatotioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter(
						Constantes.CAMPO_RG_DATA_EMISSAO, rgDataEmissao);
				actionResponse.setRenderParameter(
						Constantes.CAMPO_DATA_NASCIMENTO, dataNascimento);
				actionResponse.setRenderParameter(
						Constantes.CAMPO_DATA_LIM_MAX_CREDITO,
						dataLimiteMaximoCredito);

				actionResponse.setRenderParameter("jspPage",
						"/html/cliente/cadastro.jsp");
			}
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Cliente cliente = ClienteUtil.getCliente(actionRequest);
		if (Validator.isNotNull(cliente)) {
			ClienteLocalServiceUtil.deleteCliente(cliente,
					themeDisplay.getUserId());
		}
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String metodo = ParamUtil.getString(request, Constantes.METODO);
		String pais = ParamUtil.getString(request, "pais");
		String uf = ParamUtil.getString(request, "uf");
		String cep = ParamUtil.getString(request, "cep");
		String cmd = ParamUtil.getString(request, Constants.CMD);
		String clienteId = ParamUtil.getString(request, Constantes.CLIENTE_ID);
		request.setAttribute(Constantes.CLIENTE_ID, clienteId);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.LISTAR_UF)) {
				List<Region> lista = MunicipioUtil.listarUf(pais);
				resultJsonArray = MunicipioUtil.carregarUfs(lista);
			} else if (metodo.equals(Constantes.LISTAR_MUNICIPIOS)) {
				List<Municipio> lista = MunicipioUtil.listarMunicipios(uf);
				resultJsonArray = MunicipioUtil.carregarMunicipios(lista);
			} else if (metodo.equals(Constantes.DADOS_CEP)) {
				List<Municipio> lista = null;
				Municipio municipio = MunicipioLocalServiceUtil
						.getDadosCep(cep);
				if (Validator.isNotNull(municipio)) {
					lista = new ArrayList<Municipio>(1);
					lista.add(municipio);
					resultJsonArray = MunicipioUtil.carregarDadosCep(lista);
				}
			} else if (cmd.equals(Constants.GET_TEMP)) {
				FileEntry tempFileEntry = getTempImageFileEntry(request);

				serveTempImageFile(response, tempFileEntry.getContentStream());
			}

			writeJSON(request, response, resultJsonArray);

		} catch (IOException e) {
		} catch (SystemException e) {
		} catch (PortalException e) {
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void deletarSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Cliente cliente = ClienteUtil.getCliente(Long.valueOf(deleteId));
			if (Validator.isNotNull(cliente)) {
				ClienteLocalServiceUtil.deleteCliente(cliente,
						themeDisplay.getUserId());
			}
		}
	}

	public void atualizarFoto(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		long clienteId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_CLIENTE_ID);

		try {
			actionResponse.setRenderParameter(Constantes.CAMPO_CLIENTE_ID,
					String.valueOf(clienteId));

			if (cmd.equals(Constants.ADD_TEMP)) {
				addTempImageFile(actionRequest);
			} else {
				saveTempImageFile(actionRequest);

				addSuccessMessage(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/cliente/editarFoto.jsp");
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass());
			copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("jspPage",
					"/html/cliente/editarFoto.jsp");
		}
	}

	protected void addTempImageFile(PortletRequest portletRequest)
			throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(portletRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String contentType = uploadPortletRequest.getContentType("fileName");

		if (!MimeTypesUtil.isWebImage(contentType)) {
			throw new ImageTypeException();
		}

		try {
			TempFileUtil.deleteTempFile(themeDisplay.getScopeGroupId(),
					themeDisplay.getUserId(),
					getTempImageFileName(portletRequest),
					getTempImageFolderName());
		} catch (Exception e) {
		}

		InputStream inputStream = null;

		try {
			inputStream = uploadPortletRequest.getFileAsStream("fileName");

			TempFileUtil.addTempFile(themeDisplay.getScopeGroupId(),
					themeDisplay.getUserId(),
					getTempImageFileName(portletRequest),
					getTempImageFolderName(), inputStream, contentType);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	protected String getTempImageFileName(PortletRequest portletRequest) {
		return ParamUtil.getString(portletRequest, "clienteId");
	}

	protected String getTempImageFolderName() {
		Class<?> clazz = getClass();

		return clazz.getName();
	}

	protected void saveTempImageFile(ActionRequest actionRequest)
			throws Exception {

		UploadPortletRequest uploadPortletRequest = PortalUtil
				.getUploadPortletRequest(actionRequest);

		FileEntry tempFileEntry = null;

		InputStream tempImageStream = null;

		try {
			tempFileEntry = getTempImageFileEntry(actionRequest);

			tempImageStream = tempFileEntry.getContentStream();

			ImageBag imageBag = ImageToolUtil.read(tempImageStream);

			RenderedImage renderedImage = imageBag.getRenderedImage();

			String cropRegionJSON = ParamUtil.getString(uploadPortletRequest,
					"cropRegion");

			if (Validator.isNotNull(cropRegionJSON)) {
				JSONObject jsonObject = JSONFactoryUtil
						.createJSONObject(cropRegionJSON);

				int height = jsonObject.getInt("height");
				int width = jsonObject.getInt("width");
				int x = jsonObject.getInt("x");
				int y = jsonObject.getInt("y");

				renderedImage = getCroppedRenderedImage(renderedImage, height,
						width, x, y);
			}

			byte[] bytes = ImageToolUtil.getBytes(renderedImage,
					imageBag.getType());

			saveTempImageFile(actionRequest, bytes);
		} catch (NoSuchFileEntryException nsfee) {
			throw new UploadException(nsfee);
		} catch (NoSuchRepositoryException nsre) {
			throw new UploadException(nsre);
		} finally {
			StreamUtil.cleanUp(tempImageStream);

			if (tempFileEntry != null) {
				TempFileUtil.deleteTempFile(tempFileEntry.getFileEntryId());
			}
		}
	}

	protected FileEntry getTempImageFileEntry(PortletRequest portletRequest)
			throws PortalException, SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		return TempFileUtil.getTempFile(themeDisplay.getScopeGroupId(),
				themeDisplay.getUserId(), getTempImageFileName(portletRequest),
				getTempImageFolderName());
	}

	protected RenderedImage getCroppedRenderedImage(
			RenderedImage renderedImage, int height, int width, int x, int y) {

		Rectangle rectangle = new Rectangle(width, height);

		Rectangle croppedRectangle = rectangle.intersection(new Rectangle(
				renderedImage.getWidth(), renderedImage.getHeight()));

		BufferedImage bufferedImage = ImageToolUtil
				.getBufferedImage(renderedImage);

		return bufferedImage.getSubimage(x, y, croppedRectangle.width,
				croppedRectangle.height);
	}

	protected void saveTempImageFile(PortletRequest portletRequest, byte[] bytes)
			throws Exception {

		long clienteId = ParamUtil.getLong(portletRequest, "clienteId");

		ClienteLocalServiceUtil.updateFoto(clienteId, bytes);
	}

	protected void serveTempImageFile(MimeResponse mimeResponse,
			InputStream tempImageStream) throws Exception {

		ImageBag imageBag = ImageToolUtil.read(tempImageStream);

		byte[] bytes = ImageToolUtil.getBytes(imageBag.getRenderedImage(),
				imageBag.getType());

		String contentType = MimeTypesUtil.getExtensionContentType(imageBag
				.getType());

		mimeResponse.setContentType(contentType);

		PortletResponseUtil.write(mimeResponse, bytes);
	}

	private void copyRequestParameters(ActionRequest request,
			ActionResponse actionResponse) {

		actionResponse.setRenderParameter("p_p_lifecycle", "1");

		Enumeration<String> enu = request.getParameterNames();

		Map<String, String[]> renderParameters = actionResponse
				.getRenderParameterMap();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();
			String[] values = request.getParameterValues(param);

			if (renderParameters.get(actionResponse.getNamespace() + param) == null
					&& (Validator.isNotNull(param) && Validator
							.isNotNull(values))) {
				actionResponse.setRenderParameter(param, values);
			}
		}
	}
}
