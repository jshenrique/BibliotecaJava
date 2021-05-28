package command;


/** 
 * Representa um Comando concreto para registrar um observador de livro - Padrão Command
 *  
 * @since 1.0
*/
public class ComandoRegistrarObservador implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().registrarObservador(stringComando);
	}
}
