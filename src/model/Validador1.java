package model;

public class Validador1 implements ValidadorEmprestimo{

	@Override
	public boolean validar(Usuario usuario, Livro livro) {
		Mensagem msg = new Mensagem();
		
		// São as regras para emprestar o livro para alunos.
		
		if (livro.exemplaresDisponiveisEmprestimo() == false) {
			msg.exemplarIndisponivel();
			return false;
			
		} else if (usuario.verificaEmprestimoAtrasado() == false) {
			msg.emprestimoAtrasado();
			return false;
			
		} else if (usuario.verificaQuantidadeDeEmprestimoAtivo() == false) {
			msg.quantidadeMaximaEmprestimo();
			return false;
		
		} else if (usuario.verificaEmprestimoAtivoDoLivro(livro) == false) {
			msg.emprestimoAtivoDoExemplar();
			return false;
			
		} else if (livro.verificarReservaDoUsuario(usuario) == true) {
			return true;
			
		} else if (livro.verificarReservas() == true) {
			return true;
		
		} else {
			msg.livroReservado();
			return false;
		}
		
		
	}
}