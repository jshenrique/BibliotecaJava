package model;

import java.util.ArrayList;
import observer.Sujeito;

public class Livro extends Sujeito{	
	
	int id;
	String titulo;
	String editora;
	String autores;
	int edicao;
	int anoPublicacao;
	ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
	ArrayList<Reserva> reservasAtivas = new ArrayList<Reserva>();
	ArrayList<Reserva> reservasFinalizadas = new ArrayList<Reserva>();
	
		
	public void adicionarExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar); 
	}
	
	public int exemplaresDisponiveis() {
		int exempalresDisponiveis = 0;
		for(Exemplar exem : this.exemplares) {
			 if(exem.getStatus() == "Disponivel") {
				 exempalresDisponiveis++;
			 }
		}
		return exempalresDisponiveis;
	}
	
	public boolean exemplaresDisponiveisEmprestimo() {
		for(Exemplar exem : this.exemplares) {
			 if(exem.getStatus() == "Disponivel") {
				 return true;
			 }
		}
		return false;
	}
	
	public Exemplar exemplarParaEmprestimo() {
		for(Exemplar exem : this.exemplares) {
			 if(exem.getStatus() == "Disponivel") {
				 return exem;
			 }
		}
		return null;
	}
	
	public ArrayList<Reserva> listarReservasAtivas() {
		return reservasAtivas;
	}
	
	public ArrayList<Reserva> listarReservasFinalizadas() {
		return reservasFinalizadas;
	}
	
	
	public boolean verificarReservas() {
		if(this.listarReservasAtivas().size() < this.exemplaresDisponiveis()) {
			return true;
		}
		return false;
	}
	
	public boolean verificarReservaDoUsuario(Usuario usuario) {
		for(Reserva reserva : this.reservasAtivas) {
			 if(reserva.getUsuario().getIdUsuario() == usuario.getIdUsuario()) {
				 return true;
			 }
		}
		
		return false;
	}
		
	public void finalizarReserva(Reserva reserva) {
		this.reservasAtivas.remove(reserva);
		this.reservasFinalizadas.add(reserva);
	}
	
	public void reservarLivro(Reserva reserva) {
		this.reservasAtivas.add(reserva);
	}
	
	
	public void consultaLivro() {
		
		System.out.println("Titulo: "+this.getTitulo());
		System.out.println("Quantidade de reservas: "+this.listarReservasAtivas().size());
		for(Reserva res : this.reservasAtivas) {
			System.out.println("Usuarios que reservaram: "+res.getUsuario().getNome());
		}
		
		System.out.println("-----------------------");
		System.out.println("- Exemplares -");
		
		for(Exemplar exemp : this.exemplares) {
			System.out.println("-----------------------");
			System.out.println("Codigo do exemplar: "+exemp.getIdExemplar());
			System.out.println("Status: "+exemp.getStatus());	
			if(exemp.getStatus() == "Emprestado") {
				System.out.println("Usuario: "+exemp.getEmprestimo().getUsuario().getNome());
				System.out.println("Data do Emprestimo: "+exemp.getEmprestimo().getDataEmprestimo());
				System.out.println("Data de Devolucao: "+exemp.getEmprestimo().getDataParaDevolucao());
			}
		}

	}
	
	
	public int quantidadeDeExemplares() {
		return exemplares.size();
	}	
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getEditora() {
		return editora;
	}
	
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	public String getAutores() {
		return autores;
	}
	
	public void setAutores(String autores) {
		this.autores = autores;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
	
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	public void verificaQtdeReservas() {
		
		if(this.listarReservasAtivas().size() >= 2) {
			notificarObservadores();
		}
		
	}

	
}
