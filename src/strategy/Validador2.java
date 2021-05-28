package strategy;

import model.Livro;
import model.Usuario;
import util.Mensagem;

/** 
 * Validador - regras de emprestimo para professor
 * Implementação do Padrão Strategy
 * @since 1.0
*/
public class Validador2 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) throws Exception {
		

		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			
			throw new Exception(Mensagem.EXEMPLAR_INDISPONIVEL_ERRO);
				
		} else if (usuario.verificaEmprestimoAtrasado() == false) {			
			throw new Exception(Mensagem.USUARIO_EMPRESTIMO_ATRASO_ERRO);
		} else {
			return true;
		}
		
		
	}
}
