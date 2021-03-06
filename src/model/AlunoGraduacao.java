package model;

import strategy.Validador1;

/** 
 * Representa um aluno de gradua??o
 * 
 * @since 1.0
*/
public class AlunoGraduacao extends Usuario{
	private int limiteEmprestimo = 3;
	private int tempoDeEmprestimo = 3;
	
	public AlunoGraduacao(){
		this.validar = new Validador1();
	}

	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	@Override
	int getTempoEmprestimo() {
		return this.tempoDeEmprestimo;
	}
	
}
