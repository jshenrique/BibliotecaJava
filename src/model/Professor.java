package model;

import strategy.Validador2;

public class Professor extends Usuario{
	private int tempoDeEmprestimo = 7;
	
	public Professor() {
		 this.validar = new Validador2();
	}
	
	public int getLimiteEmprestimo() {
		return limiteEmprestimo;
	}

	@Override
	int getTempoEmprestimo() {
		return this.tempoDeEmprestimo;
	}
	
}
