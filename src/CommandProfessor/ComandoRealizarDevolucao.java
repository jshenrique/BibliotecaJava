package CommandProfessor;

public class ComandoRealizarDevolucao implements Comando {

	@Override
	public void executar() {
		FachadaBiblioteca.obterInstancia().realizarDevolucao();

	}

}
