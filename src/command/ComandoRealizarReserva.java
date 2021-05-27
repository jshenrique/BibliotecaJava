 package command;

public class ComandoRealizarReserva implements Comando {

	@Override
	public void executar(String stringComando[]) {
		FachadaBiblioteca.obterInstancia().realizarReserva(stringComando);
	}
}
