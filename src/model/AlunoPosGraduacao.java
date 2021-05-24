package model;

public class AlunoPosGraduacao extends Usuario {
	private int limiteEmprestimo = 4;
	private int tempoDeEmprestimo = 4;

	
	public AlunoPosGraduacao(){
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
