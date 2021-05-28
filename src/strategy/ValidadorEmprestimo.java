package strategy;

import model.Livro;
import model.Usuario;

/** 
 * Interface para um Validador - Padrão Strategy
 *  
 * @since 1.0
*/
public interface ValidadorEmprestimo {

	public boolean validar(Usuario usuario, Livro livro) throws Exception;
	
}
