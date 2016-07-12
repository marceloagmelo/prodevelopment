package br.com.rasecmadeiras.orcamento.validacao;

import java.util.List;

import br.com.rasecmadeiras.orcamento.Constantes;
import br.com.rasecmadeiras.orcamento.vo.OrcamentoVO;

import com.liferay.portal.kernel.util.Validator;

public class OrcamentoValidator {

	public static boolean validar(OrcamentoVO orcamentoVO, List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(orcamentoVO.getNomeUsuario())) {
			errors.add("mensagem.orcamento.nomeUsuario.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNotNull(orcamentoVO.getTipoResposta())) {
			if (Constantes.EMAIL.equals(orcamentoVO.getTipoResposta())) {
				if (Validator.isNull(orcamentoVO.getEmailUsuario())) {
					errors.add("mensagem.orcamento.email.obrigatorio");
					valid = false;
				}
			}
		}
		if (Validator.isNotNull(orcamentoVO.getEmailUsuario())) {
			if (!EmailValidator.isEmail(orcamentoVO.getEmailUsuario())) {
				errors.add("mensagem.orcamento.email.invalido");
				valid = false;
			}
		}
		// Validar solicitação
		if (Validator.isNull(orcamentoVO.getSolicitacao())) {
			errors.add("mensagem.orcamento.solicitacao.obrigatoria");
			valid = false;
		}
		// Validar endereço
		if (Validator.isNull(orcamentoVO.getEndereco())) {
			errors.add("mensagem.orcamento.endereco.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(orcamentoVO.getCidade())) {
			errors.add("mensagem.orcamento.cidade.obrigatoria");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(orcamentoVO.getEstado())) {
			errors.add("mensagem.orcamento.estado.obrigatorio");
			valid = false;
		}
		if (Validator.isNotNull(orcamentoVO.getTipoResposta())) {
			if (Constantes.TELEFONE.equals(orcamentoVO.getTipoResposta())) {
				// Validar DDD
				if (Validator.isNull(orcamentoVO.getDdd())) {
					errors.add("mensagem.orcamento.ddd.obrigatorio");
					valid = false;
				}
				// Validar telefone
				if (Validator.isNull(orcamentoVO.getTelefone())) {
					errors.add("mensagem.orcamento.telefone.obrigatorio");
					valid = false;
				}
			}
		}

		// Validar tipo de resposta
		if (Validator.isNull(orcamentoVO.getTipoResposta())) {
			errors.add("mensagem.orcamento.tipoReposta.obrigatoria");
			valid = false;
		}
		return valid;
	}

}
