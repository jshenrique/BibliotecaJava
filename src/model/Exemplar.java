package model;

public class Exemplar {
	private int idExemplar;
	private Livro livro;
	private String status = "Disponivel";
	private Emprestimo emprestimo;
	
	
	public int getIdExemplar() {
		return idExemplar;
	}
	public void setIdExemplar(int idExemplar) {
		this.idExemplar = idExemplar;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public Emprestimo getEmprestimo() {
		return emprestimo;
	}
	
	public void setEmprestimo(Emprestimo emprestimo) {
		this.emprestimo = emprestimo;
	}
	
}

