package br.com.prodevelopment.testeconhecimento.cadastro.validacao;

import java.util.List;
import java.util.Locale;

import br.com.prodevelopment.testeconhecimento.vo.RespostaVO;

import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class RespostaValidator {

	public static boolean validar(RespostaVO respostaVO, List<String> errors) {
		
		boolean valid = true;
		
		Locale defaultLocale = LocaleUtil.getDefault();
		
		// Validar descricao
		String descricao = respostaVO.getDescricaoMap().get(defaultLocale);
		if (Validator.isNull(descricao)) {
			errors.add("mensagem.resposta.descricao.obrigatoria");
			valid = false;
		}
		// Validar correta
		if (Validator.isNull(respostaVO.getCorreta())) {
			errors.add("mensagem.resposta.selecioneCorreta.obrigatoria");
			valid = false;
		}
		return valid;
	}
}
