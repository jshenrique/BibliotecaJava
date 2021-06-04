package model;

import java.util.ArrayList;
import observer.Sujeito;
import system.InterfaceUsuario;

/** 
 * Representa um livro
 * 
 * @since 1.0
*/
public class Livro extends Sujeito{	
	
	private int id;
	private String titulo;
	private String editora;
	private String autores;
	private int edicao;
	private int anoPublicacao;
	private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();
	private ArrayList<Reserva> reservasAtivas = new ArrayList<Reserva>();
	private ArrayList<Reserva> reservasFinalizadas = new ArrayList<Reserva>();
	
		
	public void adicionarExemplar(Exemplar exemplar) {
		this.exemplares.add(exemplar); 
	}
	
	public int exemplaresDisponiveis() {
		int exemplaresDisponiveis = 0;
		for(Exemplar exem : this.exemplares) {
			 if(exem.getStatus() == "Disponivel") {
				 exemplaresDisponiveis++;
			 }
		}
		return exemplaresDisponiveis;
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
			
	public void reservarLivro(Reserva reserva) {
		this.reservasAtivas.add(reserva);
	}
	
	public void finalizarReserva(Reserva reserva) {
		this.reservasAtivas.remove(reserva);
		this.reservasFinalizadas.add(reserva);
	}
	
	public void verificaQtdeReservas() {	
		if(this.listarReservasAtivas().size() >= 2) {
			notificarObservadores();
		}
	}
	
	public ArrayList<Reserva> listarReservasAtivas() {
		return reservasAtivas;
	}
	
	public ArrayList<Reserva> listarReservasFinalizadas() {
		return reservasFinalizadas;
	}
	
	public void consultaLivro() {
		
		InterfaceUsuario.obterInstancia().imprimirMensagem("Titulo: "+this.getTitulo());
		InterfaceUsuario.obterInstancia().imprimirMensagem("Quantidade de reservas: "+this.listarReservasAtivas().size());
		for(Reserva res : this.reservasAtivas) {
			InterfaceUsuario.obterInstancia().imprimirMensagem("Usuarios que reservaram: "+res.getUsuario().getNome());
		}
		
		InterfaceUsuario.obterInstancia().imprimirMensagem("-----------------------");
		InterfaceUsuario.obterInstancia().imprimirMensagem("- Exemplares -");
		
		for(Exemplar exemp : this.exemplares) {
			InterfaceUsuario.obterInstancia().imprimirMensagem("-----------------------");
			InterfaceUsuario.obterInstancia().imprimirMensagem("Codigo do exemplar: "+exemp.getIdExemplar());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Status: "+exemp.getStatus());
			
			if(exemp.getStatus() == "Emprestado") {
				InterfaceUsuario.obterInstancia().imprimirMensagem("Usuario: "+exemp.getEmprestimo().getUsuario().getNome());
				InterfaceUsuario.obterInstancia().imprimirMensagem("Data do Emprestimo: "+exemp.getEmprestimo().getDataEmprestimo());
				InterfaceUsuario.obterInstancia().imprimirMensagem("Data de Devolucao: "+exemp.getEmprestimo().getDataParaDevolucao());
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
		
}
