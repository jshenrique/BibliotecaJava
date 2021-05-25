package strategy;

import model.Livro;
import model.Usuario;

public interface ValidadorEmprestimo {

	public boolean validar(Usuario usuario, Livro livro);
	
}
