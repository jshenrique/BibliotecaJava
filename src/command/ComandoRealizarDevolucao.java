package command;

import system.FachadaBiblioteca;

/** 
 * Representa um Comando concreto para devolver um livro - Padrão Command
 *  
 * @since 1.0
*/
public class ComandoRealizarDevolucao implements Comando {

	@Override
	public void executar(String stringComando[]) {
		FachadaBiblioteca.obterInstancia().realizarDevolucao(stringComando);
	}
}
