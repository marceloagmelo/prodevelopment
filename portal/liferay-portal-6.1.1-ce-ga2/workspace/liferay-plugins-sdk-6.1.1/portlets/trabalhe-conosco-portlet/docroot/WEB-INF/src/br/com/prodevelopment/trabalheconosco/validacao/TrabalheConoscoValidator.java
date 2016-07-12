package br.com.prodevelopment.trabalheconosco.validacao;

import java.util.List;

import br.com.prodevelopment.trabalheconosco.vo.TrabalheConoscoVO;

import com.liferay.portal.kernel.util.Validator;

public class TrabalheConoscoValidator {

	public static boolean validar(TrabalheConoscoVO trabalheConoscoVO, List<String> errors) {

		boolean valid = true;

		// Validar nome
		if (Validator.isNull(trabalheConoscoVO.getNomeUsuario())) {
			errors.add("mensagem.trabalheConosco.nomeUsuario.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNull(trabalheConoscoVO.getEmailUsuario())) {
			errors.add("mensagem.trabalheConosco.email.obrigatorio");
			valid = false;
		}
		else {
			if (!EmailValidator.isEmail(trabalheConoscoVO.getEmailUsuario())) {
				errors.add("mensagem.trabalheConosco.email.invalido");
				valid = false;
			}
		}
		// Validar cargo
		if (Validator.isNull(trabalheConoscoVO.getCargo())) {
			errors.add("mensagem.trabalheConosco.cargo.obrigatorio");
			valid = false;
		}
		// Validar resumo
		if (Validator.isNull(trabalheConoscoVO.getResumo())) {
			errors.add("mensagem.trabalheConosco.objetivo.obrigatorio");
			valid = false;
		}
		// Validar endereço
		if (Validator.isNull(trabalheConoscoVO.getEndereco())) {
			errors.add("mensagem.trabalheConosco.endereco.obrigatorio");
			valid = false;
		}
		// Validar cidade
		if (Validator.isNull(trabalheConoscoVO.getCidade())) {
			errors.add("mensagem.trabalheConosco.cidade.obrigatoria");
			valid = false;
		}
		// Validar estado
		if (Validator.isNull(trabalheConoscoVO.getEstado())) {
			errors.add("mensagem.trabalheConosco.estado.obrigatorio");
			valid = false;
		}
		// Validar DDD
		if (Validator.isNull(trabalheConoscoVO.getDdd())) {
			errors.add("mensagem.trabalheConosco.ddd.obrigatorio");
			valid = false;
		}
		// Validar telefone
		if (Validator.isNull(trabalheConoscoVO.getTelefone())) {
			errors.add("mensagem.trabalheConosco.telefone.obrigatorio");
			valid = false;
		}
		return valid;
	}

}
