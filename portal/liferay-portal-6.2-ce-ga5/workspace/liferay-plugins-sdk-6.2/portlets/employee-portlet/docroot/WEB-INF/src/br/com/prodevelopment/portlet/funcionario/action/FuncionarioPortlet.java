package br.com.prodevelopment.portlet.funcionario.action;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
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

import br.com.prodevelopment.contato.model.EnderecoEmail;
import br.com.prodevelopment.contato.model.Telefone;
import br.com.prodevelopment.funcionario.CargoAlteradoOutroUsuarioException;
import br.com.prodevelopment.funcionario.CargoNomeObrigatorioException;
import br.com.prodevelopment.funcionario.FuncionarioAlteradoOutroUsuarioException;
import br.com.prodevelopment.funcionario.FuncionarioCPFDuplicadoException;
import br.com.prodevelopment.funcionario.FuncionarioCPFInvalidoException;
import br.com.prodevelopment.funcionario.FuncionarioDataEntradaInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioDataNascimentoInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioDataSaidaInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioEmailInvalidoException;
import br.com.prodevelopment.funcionario.FuncionarioNomeObrigatorioException;
import br.com.prodevelopment.funcionario.FuncionarioRGDataEmissaoInvalidaException;
import br.com.prodevelopment.funcionario.FuncionarioRGDuplicadoException;
import br.com.prodevelopment.funcionario.FuncionarioUsuarioDuplicadoException;
import br.com.prodevelopment.funcionario.model.Cargo;
import br.com.prodevelopment.funcionario.model.Funcionario;
import br.com.prodevelopment.funcionario.service.CargoLocalServiceUtil;
import br.com.prodevelopment.funcionario.service.FuncionarioLocalServiceUtil;
import br.com.prodevelopment.municipio.model.Municipio;
import br.com.prodevelopment.municipio.service.MunicipioLocalServiceUtil;
import br.com.prodevelopment.portlet.funcionario.Constantes;
import br.com.prodevelopment.portlet.funcionario.util.CargoUtil;
import br.com.prodevelopment.portlet.funcionario.util.EnderecoEmailUtil;
import br.com.prodevelopment.portlet.funcionario.util.FuncionarioUtil;
import br.com.prodevelopment.portlet.funcionario.util.Helper;
import br.com.prodevelopment.portlet.funcionario.util.MunicipioUtil;
import br.com.prodevelopment.portlet.funcionario.util.TelefoneUtil;
import br.com.prodevelopment.portlet.funcionario.util.UsuarioUtil;

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
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class FuncionarioPortlet
 */
public class FuncionarioPortlet extends MVCPortlet {

	protected String viewCargoJSP;
	protected String selecioneCargoJSP;

	@Override
	public void init() throws PortletException {
		viewCargoJSP = getInitParameter(Constantes.JSP_VIEW_CARGO);
		selecioneCargoJSP = getInitParameter(Constantes.JSP_SELECIONE_CARGO);

		addProcessActionSuccessMessage = GetterUtil.getBoolean(
				getInitParameter("add-process-action-success-action"), false);
		super.init();
	}

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

			FuncionarioUtil.getFuncionario(renderRequest);
			CargoUtil.getCargo(renderRequest);
			UsuarioUtil.getUsuario(renderRequest);

			super.render(renderRequest, renderResponse);
		} catch (Exception e) {
			e.getMessage();
		}

	}

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		String redirect = ParamUtil.getString(renderRequest,
				Constantes.REDIRECT);

		if (Constantes.REDIRECT_VIEW_CARGO.equals(redirect)) {
			include(viewCargoJSP, renderRequest, renderResponse);
		} else if (Constantes.REDIRECT_SELECIONE_CARGO.equals(redirect)) {
			include(selecioneCargoJSP, renderRequest, renderResponse);
		} else {
			super.doView(renderRequest, renderResponse);
		}
	}

	public void salvar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		long funcionarioId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_FUNCIONARIO_ID);

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

		// Recuperar campos do request
		String nome = ParamUtil.getString(actionRequest, Constantes.CAMPO_NOME);
		String nomeReduzido = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_NOME_REDUZIDO);
		String observacao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_OBSERVACAO);
		String rg = ParamUtil.getString(actionRequest, Constantes.CAMPO_RG);
		String rgOrgaoEmissor = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_ORGAO_EMISSOR);
		String rgDataEmissao = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_RG_DATA_EMISSAO);
		String cpf = ParamUtil.getString(actionRequest, Constantes.CAMPO_CPF);
		String sexo = ParamUtil.getString(actionRequest, Constantes.CAMPO_SEXO);
		String estadoCivil = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_ESTADO_CIVIL);
		String dataNascimento = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_NASCIMENTO);
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
		String dataEntrada = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_ENTRADA);
		String dataSaida = ParamUtil.getString(actionRequest,
				Constantes.CAMPO_DATA_SAIDA);
		long cargoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_CARGO_ID);
		long userId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_USUARIO_ID);
		boolean existeUser = (userId > 0);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);
		boolean ativo = ParamUtil.getBoolean(actionRequest,
				Constantes.CAMPO_ATIVO);
		String site = "";// ParamUtil.getString(actionRequest,
		// Constantes.CAMPO_SITE);

		try {
			List<Telefone> telefones = TelefoneUtil.getTelefones(actionRequest);
			List<EnderecoEmail> enderecosEmail = EnderecoEmailUtil
					.getEnderecosEmail(actionRequest);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Funcionario.class.getName(), actionRequest);

			boolean deleteLogo = ParamUtil.getBoolean(actionRequest,
					"deleteLogo");

			if (deleteLogo) {
				FuncionarioLocalServiceUtil.deleteFoto(funcionarioId);
			}

			if (Constantes.ADD.equals(acao)) {
				Funcionario funcionario = FuncionarioLocalServiceUtil
						.addFuncionario(themeDisplay.getCompanyId(),
								themeDisplay.getScopeGroupId(),
								themeDisplay.getUserId(), nome, nomeReduzido,
								observacao, rg, rgOrgaoEmissor, rgDataEmissao,
								cpf, sexo, estadoCivil, dataNascimento,
								endComLogradouro, endComNumero,
								endComComplemento, endComCep, endComBairro,
								endComCidade, endComUf, endComPais,
								endResLogradouro, endResNumero,
								endResComplemento, endResCep, endResBairro,
								endResCidade, endResUf, endResPais,
								dataEntrada, dataSaida, existeUser, userId,
								Constantes.VERSAO_INICIAL, cargoId,
								Boolean.TRUE, 0, enderecosEmail, telefones,
								serviceContext);

				SessionMessages.add(actionRequest,
						"mensagem.funcionario.adicionado.sucesso");
			} else {
				Funcionario funcionario = FuncionarioLocalServiceUtil
						.getFuncionario(funcionarioId);
				funcionario = FuncionarioLocalServiceUtil.update(funcionarioId,
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nome, nomeReduzido,
						observacao, rg, rgOrgaoEmissor, rgDataEmissao, cpf,
						sexo, estadoCivil, dataNascimento, endComLogradouro,
						endComNumero, endComComplemento, endComCep,
						endComBairro, endComCidade, endComUf, endComPais,
						endResLogradouro, endResNumero, endResComplemento,
						endResCep, endResBairro, endResCidade, endResUf,
						endResPais, dataEntrada, dataSaida, existeUser, userId,
						versao, cargoId, ativo, 0, enderecosEmail, telefones,
						serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.funcionario.alterado.sucesso");
			}
			sendRedirect(actionRequest, actionResponse);
		} catch (Exception e) {
			if (e instanceof FuncionarioRGDataEmissaoInvalidaException
					|| e instanceof FuncionarioDataNascimentoInvalidaException
					|| e instanceof FuncionarioDataEntradaInvalidaException
					|| e instanceof FuncionarioDataSaidaInvalidaException
					|| e instanceof FuncionarioNomeObrigatorioException
					|| e instanceof FuncionarioCPFInvalidoException
					|| e instanceof FuncionarioCPFDuplicadoException
					|| e instanceof FuncionarioRGDuplicadoException
					|| e instanceof FuncionarioEmailInvalidoException
					|| e instanceof FuncionarioUsuarioDuplicadoException
					|| e instanceof FuncionarioAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter(
						Constantes.CAMPO_RG_DATA_EMISSAO, rgDataEmissao);
				actionResponse.setRenderParameter(
						Constantes.CAMPO_DATA_NASCIMENTO, dataNascimento);
				actionResponse.setRenderParameter(
						Constantes.CAMPO_DATA_ENTRADA, dataEntrada);
				actionResponse.setRenderParameter(Constantes.CAMPO_DATA_SAIDA,
						dataSaida);

				actionResponse.setRenderParameter("jspPage",
						"/html/funcionario/cadastro.jsp");
			}
		}
	}

	public void deletar(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		Funcionario funcionario = FuncionarioUtil.getFuncionario(actionRequest);
		if (Validator.isNotNull(funcionario)) {
			FuncionarioLocalServiceUtil.deleteFuncionario(funcionario,
					themeDisplay.getUserId());
		}
	}

	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response) {

		String metodo = ParamUtil.getString(request, Constantes.METODO);
		String uf = ParamUtil.getString(request, "uf");
		String cep = ParamUtil.getString(request, "cep");
		String cmd = ParamUtil.getString(request, Constants.CMD);
		String funcionarioId = ParamUtil.getString(request,
				Constantes.FUNCIONARIO_ID);
		request.setAttribute(Constantes.FUNCIONARIO_ID, funcionarioId);

		try {
			JSONArray resultJsonArray = JSONFactoryUtil.createJSONArray();
			if (metodo.equals(Constantes.LISTAR_MUNICIPIOS)) {
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
			Funcionario funcionario = FuncionarioUtil.getFuncionario(Long
					.valueOf(deleteId));
			if (Validator.isNotNull(funcionario)) {
				FuncionarioLocalServiceUtil.deleteFuncionario(funcionario,
						themeDisplay.getUserId());
			}
		}
	}

	public void salvarCargo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {

		// Recuperar campos do request
		long cargoId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_CARGO_ID);
		double versao = ParamUtil.getDouble(actionRequest,
				Constantes.CAMPO_VERSAO);
		String redirect = ParamUtil.getString(actionRequest,
				Constantes.REDIRECT);

		Map<Locale, String> nomeMap = LocalizationUtil.getLocalizationMap(
				actionRequest, Constantes.CAMPO_NOME);

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String acao = ParamUtil.getString(actionRequest, Constantes.ACAO);

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Cargo.class.getName(), actionRequest);

			if (Constantes.ADD.equals(acao)) {
				Cargo cargo = CargoLocalServiceUtil.addCargo(
						themeDisplay.getCompanyId(),
						themeDisplay.getScopeGroupId(),
						themeDisplay.getUserId(), nomeMap,
						Constantes.VERSAO_INICIAL, serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.cargo.adicionado.sucesso");
			} else {
				Cargo cargo = CargoLocalServiceUtil.getCargo(cargoId);
				cargo = CargoLocalServiceUtil.update(cargoId,
						themeDisplay.getUserId(), nomeMap, versao,
						serviceContext);
				SessionMessages.add(actionRequest,
						"mensagem.cargo.alterado.sucesso");
			}
			// sendRedirect(actionRequest, actionResponse);
			actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);
		} catch (Exception e) {
			if (e instanceof CargoNomeObrigatorioException
					|| e instanceof CargoAlteradoOutroUsuarioException) {

				SessionErrors.add(actionRequest, e.getClass());

				copyRequestParameters(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/cargo/cadastro.jsp");
			}
		}
	}

	public void deletarCargo(ActionRequest actionRequest,
			ActionResponse actionResponse) throws SystemException,
			PortalException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			String redirect = ParamUtil.getString(actionRequest, "direciona");
			actionResponse.setRenderParameter(Constantes.REDIRECT, redirect);

			Cargo cargo = CargoUtil.getCargo(actionRequest);
			if (Validator.isNotNull(cargo)) {
				CargoLocalServiceUtil.deleteCargo(cargo,
						themeDisplay.getUserId());
			}

			sendRedirect(actionRequest, actionResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void deletarCargosSelecionados(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		actionResponse.setRenderParameter(Constantes.REDIRECT,
				Constantes.REDIRECT_VIEW_CARGO);

		String[] deleteTagIds = StringUtil.split(ParamUtil.getString(
				actionRequest, Constantes.DELETE_TAG_IDS));
		for (String deleteId : deleteTagIds) {
			Cargo cargo = CargoUtil.getCargo(Long.valueOf(deleteId));
			if (Validator.isNotNull(cargo)) {
				CargoLocalServiceUtil.deleteCargo(cargo,
						themeDisplay.getUserId());
			}
		}
	}

	public void atualizarFoto(ActionRequest actionRequest,
			ActionResponse actionResponse) throws NumberFormatException,
			SystemException {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		long funcionarioId = ParamUtil.getLong(actionRequest,
				Constantes.CAMPO_FUNCIONARIO_ID);

		try {
			actionResponse.setRenderParameter(Constantes.CAMPO_FUNCIONARIO_ID,
					String.valueOf(funcionarioId));

			if (cmd.equals(Constants.ADD_TEMP)) {
				addTempImageFile(actionRequest);
			} else {
				saveTempImageFile(actionRequest);

				addSuccessMessage(actionRequest, actionResponse);

				actionResponse.setRenderParameter("jspPage",
						"/html/funcionario/editarFoto.jsp");
			}

		} catch (Exception e) {
			SessionErrors.add(actionRequest, e.getClass());
			copyRequestParameters(actionRequest, actionResponse);

			actionResponse.setRenderParameter("jspPage",
					"/html/funcionario/editarFoto.jsp");
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
		return ParamUtil.getString(portletRequest, "funcionarioId");
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

		long funcionarioId = ParamUtil.getLong(portletRequest, "funcionarioId");

		FuncionarioLocalServiceUtil.updateFoto(funcionarioId, bytes);
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
