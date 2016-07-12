package br.com.prodevelopment.faleconosco.validacao;

import java.util.List;

import br.com.prodevelopment.faleconosco.vo.FaleConoscoVO;

import com.liferay.portal.kernel.util.Validator;

public class FaleConoscoValidator {

	public static boolean validar(FaleConoscoVO faleConoscoVO, List<String> errors) {
		
		boolean valid = true;
		
		// Validar nome
		if (Validator.isNull(faleConoscoVO.getNomeUsuario())) {
			errors.add("mensagem.faleConosco.nomeUsuario.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNull(faleConoscoVO.getEmailUsuario())) {
			errors.add("mensagem.faleConosco.email.obrigatorio");
			valid = false;
		}
		else {
			if (!EmailValidator.isEmail(faleConoscoVO.getEmailUsuario())) {
				errors.add("mensagem.faleConosco.email.invalido");
				valid = false;
			}
		}
		// Validar assunto
		if (Validator.isNull(faleConoscoVO.getAssunto())) {
			errors.add("mensagem.faleConosco.assunto.obrigatorio");
			valid = false;
		}
		// Validar mensagem
		if (Validator.isNull(faleConoscoVO.getMensagem())) {
			errors.add("mensagem.faleConosco.mensagem.obrigatoria");
			valid = false;
		}
		return valid;
	}
	
}
