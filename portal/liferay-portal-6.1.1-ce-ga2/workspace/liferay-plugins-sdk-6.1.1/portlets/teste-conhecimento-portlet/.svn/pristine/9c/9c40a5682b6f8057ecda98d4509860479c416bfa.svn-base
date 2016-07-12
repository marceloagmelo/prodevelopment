package br.com.prodevelopment.testeconhecimento.cadastro.validacao;

import java.util.List;
import java.util.Locale;

import br.com.prodevelopment.testeconhecimento.vo.PerguntaVO;

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
		// Validar justificativa resposta
		String justificativaResposta = perguntaVO.getJustificativaRespostaMap().get(defaultLocale);
		if (Validator.isNull(justificativaResposta)) {
			errors.add("mensagem.pergunta.justificativa.obrigatoria");
			valid = false;
		}
		// Validar pontuação
		if (Validator.isNull(perguntaVO.getPontuacao())) {
			errors.add("mensagem.pergunta.pontuacao.obrigatoria");
			valid = false;
		}
		else {
			perguntaVO.setPontuacao(perguntaVO.getPontuacao().replaceAll(",", "."));
			try {
				Double dbValor = Double.valueOf(perguntaVO.getPontuacao());
			}
			catch (NumberFormatException e) {
				errors.add("mensagem.pergunta.pontuacao.temQueSerNumerica");
				valid = false;
			}
		}

		return valid;
	}
}
