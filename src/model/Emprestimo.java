package model;

import java.time.LocalDate;

/** 
 * Representa um empréstimo de livro
 * 
 * @since 1.0
*/
public class Emprestimo {
	private int idEmprestimo;
	private Usuario usuario;
	private Exemplar exemplar;
	private LocalDate dataEmprestimo;
	private LocalDate dataParaDevolucao;
	private String status;
	
	public Emprestimo(Usuario usuario, Exemplar exemplar) {
		this.setUsuario(usuario);
		this.setExemplar(exemplar);
		LocalDate dataAtual = LocalDate.now();
		this.dataEmprestimo = dataAtual;
		this.setDataParaDevolucao(dataEmprestimo.plusDays(usuario.getTempoEmprestimo()));
		this.setStatus("Em cursor");
	}
	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public int getIdEmprestimo() {
		return idEmprestimo;
	}


	public void setIdEmprestimo(int idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}


	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public Exemplar getExemplar() {
		return exemplar;
	}


	public void setExemplar(Exemplar exemplar) {
		this.exemplar = exemplar;
	}

	
	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataParaDevolucao() {
		return dataParaDevolucao;
	}

	public void setDataParaDevolucao(LocalDate dataParaDevolucao) {
		this.dataParaDevolucao = dataParaDevolucao;
	}
	
	
}
