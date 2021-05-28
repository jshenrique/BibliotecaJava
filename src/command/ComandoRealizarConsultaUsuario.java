package command;

import system.FachadaBiblioteca;

/** 
 * Representa um Comando concreto para consultar um usu�rio - Padr�o Command
 *  
 * @since 1.0
*/
public class ComandoRealizarConsultaUsuario implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaUsuario(stringComando);
	}
}
