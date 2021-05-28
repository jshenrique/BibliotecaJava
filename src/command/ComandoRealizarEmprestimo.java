package command;

import system.FachadaBiblioteca;

/** 
 * Representa um Comando concreto para emprestar um livro - Padrão Command
 *  
 * @since 1.0
*/
public class ComandoRealizarEmprestimo implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarEmprestimo(stringComando);		
	}
}
