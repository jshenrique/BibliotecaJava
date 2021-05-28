package command;

import system.FachadaBiblioteca;

/** 
 * Representa um Comando concreto para consultar um usuário - Padrão Command
 *  
 * @since 1.0
*/
public class ComandoRealizarConsultaUsuario implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaUsuario(stringComando);
	}
}
