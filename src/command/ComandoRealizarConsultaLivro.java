package command;

/** 
 * Representa um Comando concreto para consultar um livro - Padrão Command
 *  
 * @since 1.0
*/

public class ComandoRealizarConsultaLivro implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaLivro(stringComando);
	}
}
