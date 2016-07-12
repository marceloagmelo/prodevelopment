package br.com.prodevelopment.equipefitness.portlet.usuario.util;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.Query;
import com.liferay.portal.kernel.search.SearchEngineUtil;
import com.liferay.portal.kernel.search.Sort;
import com.liferay.portal.kernel.search.StringQueryImpl;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.service.UserLocalServiceUtil;

public class UsuarioUtil {

	public static List<User> search(String categorias, int inicio, int fim)
			throws SystemException, PortalException {
		List<User> lista = new ArrayList<User>();
		
		StringBuilder sb = new StringBuilder();

		if (Validator.isNotNull(categorias)) {
			String[] terms = StringUtil.split(categorias, ",");
			if (terms.length > 1) {
				sb.append(" +(");
				int contador = 0;
				for (String term : terms) {
					contador++;
					sb.append(Field.ASSET_CATEGORY_IDS + ":" + term);
					if (contador < terms.length) {
						sb.append(" OR ");
					}
				}
				sb.append(")");
			} else {
				sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":(" + categorias + ")");
			}
		}

		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":" + User.class.getName());

		Query query = new StringQueryImpl(sb.toString());

		Sort sort = new Sort(Field.USER_NAME, false);

		Indexer indexer = IndexerRegistryUtil
				.getIndexer(User.class);
		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(),
				CompanyThreadLocal.getCompanyId(), query, sort, inicio, fim);
		if (hits.getLength() > 0) {
			for (int i = 0; hits != null && hits.getDocs() != null
					&& i < hits.getDocs().length; i++) {
				Document doc = hits.getDocs()[i];
				String userId = doc.get(Field.USER_ID);
				
				try {
					User usuario = UserLocalServiceUtil.getUser(Long.valueOf(userId));
					lista.add(usuario);

				} catch (Exception e) {
					e.getMessage();
				}
			}
		}
		return lista;
	}

	public static int searchCount(String categorias)
			throws SystemException, PortalException {
		int retorno = 0;
		
		StringBuilder sb = new StringBuilder();

		if (Validator.isNotNull(categorias)) {
			String[] terms = StringUtil.split(categorias, ",");
			if (terms.length > 1) {
				sb.append(" +(");
				int contador = 0;
				for (String term : terms) {
					contador++;
					sb.append(Field.ASSET_CATEGORY_IDS + ":" + term);
					if (contador < terms.length) {
						sb.append(" OR ");
					}
				}
				sb.append(")");
			} else {
				sb.append(" +" + Field.ASSET_CATEGORY_IDS + ":(" + categorias + ")");
			}
		}

		sb.append(" +" + Field.ENTRY_CLASS_NAME
				+ ":" + User.class.getName());

		Query query = new StringQueryImpl(sb.toString());

		Sort sort = new Sort(Field.USER_NAME, false);

		Indexer indexer = IndexerRegistryUtil
				.getIndexer(User.class);
		Hits hits = SearchEngineUtil.search(indexer.getSearchEngineId(),
				CompanyThreadLocal.getCompanyId(), query, sort, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		if (hits.getLength() > 0) {
			retorno = hits.getLength();
		}
		return retorno;
	}
}
