package strategy;

import model.Livro;
import model.Mensagem;
import model.Usuario;

public class Validador2 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) throws Exception {
		
		Mensagem msg = new Mensagem();

		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			
			throw new Exception("Insucesso. Nao existe exemplares disponivel para o livro solicitado.");
			
			
		} else if (usuario.verificaEmprestimoAtrasado() == false) {			
			throw new Exception("Insucesso. O usuario tem emprestimo em atraso.");
		} else {
			return true;
		}
		
		
	}
}
