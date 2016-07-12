package br.com.prodevelopment.testeconhecimento.cadastro.validacao;

import java.util.List;
import java.util.Locale;

import br.com.prodevelopment.testeconhecimento.vo.TesteVO;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class TesteValidator {

	public static boolean validar(TesteVO testeVO, List<String> errors) {
		
		boolean valid = true;

		Locale defaultLocale = LocaleUtil.getDefault();
		
		// Validar titulo
		String titulo = testeVO.getTituloMap().get(defaultLocale);
		// Validar titulo
		if (Validator.isNull(titulo)) {
			errors.add("mensagem.teste.titulo.obrigatorio");
			valid = false;
		}
		// Validar descricao
		String descricao = testeVO.getDescricaoMap().get(defaultLocale);
		if (Validator.isNull(descricao)) {
			errors.add("mensagem.teste.descricao.obrigatoria");
			valid = false;
		}
		
		return valid;
	}
}
