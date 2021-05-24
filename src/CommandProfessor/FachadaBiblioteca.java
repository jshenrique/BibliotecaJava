package CommandProfessor;

public class FachadaBiblioteca {
	private static FachadaBiblioteca instancia;
	
	private FachadaBiblioteca() {}
	
	public static FachadaBiblioteca obterInstancia() {
		if(instancia == null){
			instancia = new FachadaBiblioteca();
		}
		return instancia;
	}
	
	public void realizarEmprestimo() {
		System.out.println("Realizando emp�stimo");
		//Livro l = 
		//Emprestimo e = Emprestimo();
		//e.emprestar(idUsuario, idLivro);
	}
	
	public void realizarDevolucao() {
		System.out.println("Realizando devolu��o");
	}
	
	public void realizarReserva() {
		System.out.println("Realizando reserva");
	}
}
