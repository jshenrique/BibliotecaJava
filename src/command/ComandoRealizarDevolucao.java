package command;

public class ComandoRealizarDevolucao implements Comando {

	@Override
	public void executar(String stringComando[]) {
		FachadaBiblioteca.obterInstancia().realizarDevolucao(stringComando);
	}
}
