package model;

import observer.Observador;
import observer.Sujeito;
import strategy.Validador2;

/** 
 * Representa um professor
 * 
 * @since 1.0
*/
public class Professor extends Usuario implements Observador{
	private int tempoDeEmprestimo = 7;
	private int registroNotificacoes = 0;
	
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
	public void atualizar(Sujeito subject) {
		registroNotificacoes++;
	}
	
	public int consultaNotificacao() {		
		return registroNotificacoes;
	}
	
}
