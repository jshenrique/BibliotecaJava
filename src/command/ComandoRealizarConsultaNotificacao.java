package command;

public class ComandoRealizarConsultaNotificacao implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaNotificacao(stringComando);
	}
}
