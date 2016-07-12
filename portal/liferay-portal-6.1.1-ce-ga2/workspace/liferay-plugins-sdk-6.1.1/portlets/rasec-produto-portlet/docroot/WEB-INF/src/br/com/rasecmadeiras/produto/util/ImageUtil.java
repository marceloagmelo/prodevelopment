package br.com.rasecmadeiras.produto.util;

import br.com.rasecmadeiras.produto.destaque.Constantes;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.journal.model.JournalArticle;
import com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil;

public class ImageUtil {


	public static String getURLImage(Document doc, ThemeDisplay themeDisplay) {
		String urlImage = null;
		String contentId = doc.get(Constantes.ARTICLE_ID);
		long groupId = GetterUtil.getLong(doc.get(Field.GROUP_ID));

		try {
			JournalArticle ja = JournalArticleLocalServiceUtil.getArticle(groupId, contentId);

			if(ja.getSmallImage()) {

				urlImage = ja.getSmallImageURL();

				if(urlImage != null && !urlImage.equals("")) {
					urlImage = themeDisplay.getPathImage() + urlImage;
				} else {
					//pegando pelo id da small image
					urlImage = Constantes.URL_PREFIX_SMALL_IMAGEM + ja.getSmallImageId();
				}
			} else {
				urlImage = "";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return urlImage;

	}
}
