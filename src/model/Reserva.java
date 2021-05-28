package model;

import java.time.LocalDate;

/** 
 * Representa uma reserva
 * 
 * @since 1.0
*/
public class Reserva {
	private int idReserva;
	private Usuario usuario;
	private Livro livro;
	private LocalDate dataReserva;

	
	public Reserva(Usuario usuario, Livro livro) {
		this.setUsuario(usuario);
		this.setLivro(livro);
		LocalDate dataAtual = LocalDate.now();
		this.setDataReserva(dataAtual);
	}

	public Reserva() {}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public LocalDate getDataReserva() {
		return dataReserva;
	}

	public void setDataReserva(LocalDate dataReserva) {
		this.dataReserva = dataReserva;
	}
	
}
