package command;

public class ComandoRealizarConsultaUsuario implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaUsuario(stringComando);

	}

}
