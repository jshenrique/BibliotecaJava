package model;

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
