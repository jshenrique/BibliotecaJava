package command;

public class ComandoRealizarConsultaLivro implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaLivro(stringComando);

	}

}
