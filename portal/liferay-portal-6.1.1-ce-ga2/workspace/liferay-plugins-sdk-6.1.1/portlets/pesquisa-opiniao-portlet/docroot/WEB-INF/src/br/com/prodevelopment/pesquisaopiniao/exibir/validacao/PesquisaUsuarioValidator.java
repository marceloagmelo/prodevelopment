package br.com.prodevelopment.pesquisaopiniao.exibir.validacao;

import java.util.List;

import br.com.prodevelopment.pesquisaopiniao.vo.PesquisaUsuarioVO;

import com.liferay.portal.kernel.util.Validator;

public class PesquisaUsuarioValidator {

	public static boolean validar(PesquisaUsuarioVO pesquisaUsuarioVO, List<String> errors) {
		
		boolean valid = true;
		
		// Validar nome
		if (Validator.isNull(pesquisaUsuarioVO.getNome())) {
			errors.add("mensagem.pesquisaUsuario.nome.obrigatorio");
			valid = false;
		}
		// Validar email
		if (Validator.isNull(pesquisaUsuarioVO.getEmail())) {
			errors.add("mensagem.pesquisaUsuario.email.obrigatorio");
			valid = false;
		}
		
		return valid;
	}
}
