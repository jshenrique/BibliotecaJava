package model;

public class Mensagem {
	
	public void exemplarIndisponivel() {
		System.out.println("Insucesso. Nao existe exemplares disponivel para o livro solicitado.");
	}
	
	public void emprestimoAtrasado() {
		System.out.println("Insucesso. O usuario tem emprestimo em atraso.");
	}
	
	public void quantidadeMaximaEmprestimo() {
		System.out.println("Insucesso. O ja realizou a quantidade maxima de emprestimo simutaneo.");
	}
	
	public void livroReservado() {
		System.out.println("Insucesso. O livro ja foi reservado por outros usuarios.");
	}
	
	public void emprestimoAtivoDoExemplar() {
		System.out.println("Insucesso. O usuario tem um emprestimo em cursor deste exemplar.");
	}
	
	//Mensagem reserva negada.
	
}
