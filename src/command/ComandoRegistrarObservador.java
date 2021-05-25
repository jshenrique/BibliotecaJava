package command;

public class ComandoRegistrarObservador implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().registrarObservador(stringComando);
	}

}
