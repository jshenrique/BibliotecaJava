package command;


/** 
 * Representa um Comando concreto para consultar uma notifica��o - Padr�o Command
 *  
 * @since 1.0
*/
public class ComandoRealizarConsultaNotificacao implements Comando {

	@Override
	public void executar(String[] stringComando) {
		FachadaBiblioteca.obterInstancia().realizarConsultaNotificacao(stringComando);
	}
}
