package strategy;

import model.Livro;
import model.Usuario;
import util.Mensagem;

/** 
 * Validador - regras de emprestimo para aluno
 * Implementação do Padrão Strategy
 * @since 1.0
*/
public class Validador1 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) throws Exception {
				
		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			
			throw new Exception(Mensagem.EXEMPLAR_INDISPONIVEL_ERRO);
			
		} else if (usuario.verificaEmprestimoAtrasado() == false) {
			
			throw new Exception(Mensagem.USUARIO_EMPRESTIMO_ATRASO_ERRO);
					
		} else if (usuario.verificaQuantidadeDeEmprestimoAtivo() == false) {
		
			throw new Exception(Mensagem.MAXIMO_EMPRESTIMO_ERRO);
		
		} else if (usuario.verificaEmprestimoAtivoDoLivro(livro) == false) {
			
			throw new Exception(Mensagem.EMPRESTIMO_SIMULTANEO_ERRO);
			
		} else if (livro.verificarReservaDoUsuario(usuario) == true) {
			return true;
			
		} else if (livro.verificarReservas() == true) {
			return true;
		
		} else {
			
			throw new Exception(Mensagem.RESERVA_INDISPONIVEL_ERRO);			
		}
		
		
	}
}