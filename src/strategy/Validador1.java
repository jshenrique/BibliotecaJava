package strategy;

import model.Livro;
import model.Mensagem;
import model.Usuario;

public class Validador1 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) throws Exception {
		Mensagem msg = new Mensagem();
		
		// São as regras para emprestar o livro para alunos.
		
		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			
			throw new Exception("Insucesso: nao existe exemplares disponivel para o livro solicitado.");
			
			
		} else if (usuario.verificaEmprestimoAtrasado() == false) {
			
			throw new Exception("Insucesso: usuario tem emprestimo em atraso.");
			
			
		} else if (usuario.verificaQuantidadeDeEmprestimoAtivo() == false) {
		
			
			throw new Exception("Insucesso: usuario ja realizou a quantidade maxima de emprestimo simutaneo.");
		
		} else if (usuario.verificaEmprestimoAtivoDoLivro(livro) == false) {
			
			throw new Exception("Insucesso: usuario tem um emprestimo em curso deste exemplar.");
			
			
		} else if (livro.verificarReservaDoUsuario(usuario) == true) {
			return true;
			
		} else if (livro.verificarReservas() == true) {
			return true;
		
		} else {
			
			throw new Exception("Insucesso: livro ja foi reservado por outros usuarios.");			
		}
		
		
	}
}