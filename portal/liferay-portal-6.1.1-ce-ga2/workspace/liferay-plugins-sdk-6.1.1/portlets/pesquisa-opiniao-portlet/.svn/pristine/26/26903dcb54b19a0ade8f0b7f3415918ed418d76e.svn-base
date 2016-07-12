package br.com.prodevelopment.pesquisaopiniao.cadastro.validacao;

import java.util.List;
import java.util.Locale;

import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaVO;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class PesquisaValidator {

	public static boolean validar(PesquisaVO pesquisaVO, List<String> errors) {
		
		boolean valid = true;
		
		Locale defaultLocale = LocaleUtil.getDefault();
		
		// Validar titulo
		String titulo = pesquisaVO.getTituloMap().get(defaultLocale);
		if (Validator.isNull(titulo)) {
			errors.add("mensagem.pesquisa.titulo.obrigatorio");
			valid = false;
		}
		// Validar descricao
		String descricao = pesquisaVO.getDescricaoMap().get(defaultLocale);
		if (Validator.isNull(descricao)) {
			errors.add("mensagem.pesquisa.descricao.obrigatoria");
			valid = false;
		}
		
		return valid;
	}
}
