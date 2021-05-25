package command;

public class ComandoRealizarEmprestimo implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarEmprestimo(stringComando);		
	}

}
