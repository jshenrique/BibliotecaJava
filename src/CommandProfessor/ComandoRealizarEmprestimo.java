package CommandProfessor;

public class ComandoRealizarEmprestimo implements Comando {

	@Override
	public void executar() {
		FachadaBiblioteca.obterInstancia().realizarEmprestimo();

	}

}
