package br.com.prodevelopment.pesquisaopiniao.cadastro.validacao;

import java.util.List;
import java.util.Locale;

import br.com.prodevelopment.pesquisaopiniao.vo.PerguntaVO;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class PerguntaValidator {

	public static boolean validar(PerguntaVO perguntaVO, List<String> errors) {
		
		boolean valid = true;
		
		Locale defaultLocale = LocaleUtil.getDefault();

		// Validar descricao
		String descricao = perguntaVO.getDescricaoMap().get(defaultLocale);
		
		if (Validator.isNull(descricao)) {
			errors.add("mensagem.pergunta.descricao.obrigatoria");
			valid = false;
		}
		
		return valid;
	}
}
