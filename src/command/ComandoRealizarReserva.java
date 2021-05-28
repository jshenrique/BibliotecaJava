 package command;

 
 /** 
  * Representa um Comando concreto para reservar um livro - Padr�o Command
  *  
  * @since 1.0
 */
public class ComandoRealizarReserva implements Comando {

	@Override
	public void executar(String stringComando[]) {
		FachadaBiblioteca.obterInstancia().realizarReserva(stringComando);
	}
}
