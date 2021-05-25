package strategy;

import model.Livro;
import model.Mensagem;
import model.Usuario;

public class Validador2 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) {
		
		Mensagem msg = new Mensagem();

		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			msg.exemplarIndisponivel();
			return false;
			
		} else if (usuario.verificaEmprestimoAtrasado() == false) {
			msg.emprestimoAtrasado();
			return false;
		
		} else {
			return true;
		}
		
		
	}
}
