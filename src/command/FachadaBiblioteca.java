package command;

import model.Reserva;

public class FachadaBiblioteca {
	private static FachadaBiblioteca instancia;
	
	private FachadaBiblioteca() {}
	
	public static FachadaBiblioteca obterInstancia() {
		if(instancia == null){
			instancia = new FachadaBiblioteca();
		}
		return instancia;
	}
	
	public void realizarEmprestimo(String[] stringComando) {
		System.out.println("Realizando empéstimo");
		//Livro l = 
		//Emprestimo e = Emprestimo();
		//e.emprestar(idUsuario, idLivro);
	}
	
	public void realizarDevolucao(String[] stringComando) {
		System.out.println("Realizando devolução");
		System.out.println("Testando a String"+stringComando[1]);
	}
	
	public void realizarReserva(String[] stringComando) {
		System.out.println("Realizando reserva");
		/* if(usuarios.getId() == stringComando[1]){
			if(livro.getId() == stringComando[2])
			Reserva r = new Reserva(u, l);
			l.reservarLivro(r);
			u.realizarReserva(r
		}*/
	}
}
