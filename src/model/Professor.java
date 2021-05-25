package model;

import observer.Observador;
import observer.Sujeito;
import strategy.Validador2;

public class Professor extends Usuario implements Observador{
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

	@Override
	public void notificar(Sujeito subject) {
		// TODO Auto-generated method stub
		
	}
	
}
