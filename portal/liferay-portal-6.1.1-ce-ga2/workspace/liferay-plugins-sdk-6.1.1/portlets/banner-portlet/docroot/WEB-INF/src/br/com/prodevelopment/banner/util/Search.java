package br.com.prodevelopment.banner.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;

import br.com.prodevelopment.banner.rotativo.Constantes;
import br.com.prodevelopment.banner.vo.BannerVO;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class Search {

	private Hits hits;
	private SimpleDateFormat format;

	public Search() {
		format = new SimpleDateFormat("yyyyMMddHHmmss");
	}

	public List<BannerVO> buscarBannersById(String ids[],
			RenderRequest request, boolean showDisplayable)
			throws PortalException, SystemException, ParseException {

		if (Validator.isNull(ids))
			return null;

		StringBuilder idsBusca = new StringBuilder();

		for (String id : ids) {
			idsBusca.append(id + " ");
		}

		long companyId = PortalUtil.getCompanyId(request);

		List<BannerVO> banners = new ArrayList<BannerVO>();

		StringBuilder sb = new StringBuilder();

		sb.append(" +" + Field.ENTRY_CLASS_PK + ":");
		sb.append("(");
		sb.append(idsBusca);
		sb.append(")");
		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":com.liferay.portlet.journal.model.JournalArticle");
		sb.append(" +" + Constantes.APPROVED + ":true");
		sb.append(" +" + Constantes.EXPIRED + ":false");

		// realizando a busca
		Hits hits = SearchEngineUtil.search(companyId,
				new StringQueryImpl(sb.toString()), QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		Document[] docs = hits.getDocs();

		for (Document doc : docs) {

			String dateString = doc.get(Field.MODIFIED_DATE);
			Date displayDate = null;

			if (Validator.isNotNull(dateString)) {
				displayDate = format.parse(dateString);
			}

			if (!showDisplayable && !isDisplayableArt(displayDate, new Date())) {
				continue;
			}

			BannerVO banner = new BannerVO();
			banner.setIdBanner(doc.get(Field.ENTRY_CLASS_PK));
			banner.setImagem(doc.get(Constantes.IMAGEM).replace("[", "").replace("]", ""));
			banner.setImagem(banner.getImagem().replaceAll("&", "&amp;"));
			banner.setLinkDestino(doc.get(Constantes.LINK).replace("[", "")
					.replace("]", ""));
			banner.setExisteLink(Constantes.N);
			if (Validator.isNotNull(banner.getLinkDestino())) {
				banner.setExisteLink(Constantes.S);
			} else {
				banner.setLinkDestino(Constantes.TRALHA);
			}
			banner.setTitulo(doc.get(Constantes.TITULO));
			banner.setDataCriacao(DateUtil.getFormatDate(doc
					.get(Field.MODIFIED_DATE)));
			banner.setDescricao(doc.get(Field.DESCRIPTION).replaceAll("\n", "<br>"));

			banners.add(banner);
		}

		return banners;
	}

	private boolean isDisplayableArt(Date articleDate, Date now) {

		boolean isDisplayable = true;

		if (Validator.isNull(articleDate)) {
			return false;
		}

		if (articleDate != null) {
			isDisplayable = articleDate.compareTo(now) > 0 ? false : true;
		}

		return isDisplayable;
	}

	public List<BannerVO> buscarBanners(String estrutura, String idsCategorias,
			String order, String tags, int inicio, int fim,
			PortletRequest request) throws PortalException, SystemException {

		StringBuilder sb = new StringBuilder();

		// groupId
		sb.append(" +" + Field.GROUP_ID + ":");
		sb.append(PortalUtil.getScopeGroupId(request));

		// categorias
		if (idsCategorias != null && !idsCategorias.isEmpty()) {

			idsCategorias = idsCategorias.replace(",", " ");

			sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":");
			sb.append("(");
			sb.append(idsCategorias);
			sb.append(")");
		}

		// tags
		if (tags != null && !tags.isEmpty()) {

			tags = tags.replace(",", " ");

			sb.append(" +" + Field.ASSET_TAG_NAMES + ":");
			sb.append("(");
			sb.append(tags);
			sb.append(")");
		}

		// estrutura
		if (estrutura != null && !estrutura.isEmpty()) {
			sb.append(" +" + Constantes.STRUCTURE_ID + ":");
			sb.append(estrutura);
		}
		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":com.liferay.portlet.journal.model.JournalArticle");

		// outros campos
		sb.append(" +" + Constantes.APPROVED + ":true");
		sb.append(" +" + Constantes.EXPIRED + ":false");

		long companyId = PortalUtil.getCompanyId(request);

		if (Validator.isNull(order)) {
			order = Field.MODIFIED_DATE;
		}

		Sort sort = new Sort(order, true);

		// realizando a busca
		hits = SearchEngineUtil.search(companyId,
				new StringQueryImpl(sb.toString()), sort, inicio, fim);

		Document[] docs = hits.getDocs();
		List<BannerVO> banners = new ArrayList<BannerVO>();

		for (Document doc : docs) {

			BannerVO banner = new BannerVO();
			banner.setIdBanner(doc.get(Field.ENTRY_CLASS_PK));
			banner.setImagem(doc.get(Constantes.IMAGEM).replace("[", "").replace("]", ""));
			banner.setImagem(banner.getImagem().replaceAll("&", "&amp;"));
			banner.setLinkDestino(doc.get(Constantes.LINK).replace("[", "")
					.replace("]", ""));
			if (Validator.isNull(banner.getLinkDestino())) {
				banner.setLinkDestino(Constantes.TRALHA);
			}
			banner.setTitulo(doc.get(Constantes.TITULO));
			banner.setDataCriacao(DateUtil.getFormatDate(doc
					.get(Field.MODIFIED_DATE)));
			banner.setDescricao(doc.get(Field.DESCRIPTION).replaceAll("\n", "<br>"));

			banners.add(banner);
		}

		return banners;
	}

	public int getTotalBanners() {

		return hits.getLength();
	}
}
