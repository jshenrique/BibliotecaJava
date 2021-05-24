 package CommandProfessor;

public class ComandoRealizarReserva implements Comando {

	@Override
	public void executar() {
		FachadaBiblioteca.obterInstancia().realizarReserva();

	}

}
