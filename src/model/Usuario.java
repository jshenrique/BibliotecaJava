package model;

import java.util.ArrayList;

import strategy.ValidadorEmprestimo;

public abstract class Usuario {
	private int idUsuario;
	private String nome;
	protected ValidadorEmprestimo validar;
	private ArrayList<Emprestimo> emprestimosAtivo = new ArrayList<Emprestimo>();
	private ArrayList<Emprestimo> emprestimosFinalizado = new ArrayList<Emprestimo>();
	private ArrayList<Reserva> reservaAtiva = new ArrayList<Reserva>();
	private ArrayList<Reserva> reservaFinalizada = new ArrayList<Reserva>();
	protected int limiteEmprestimo;
		
	protected abstract int getLimiteEmprestimo();
	abstract int getTempoEmprestimo();
	
	
	public void finalizarEmprestimo(Livro livro) {
		for(Emprestimo emp : listarEmprestimoAtivo()){
			if (emp.getExemplar().getLivro().getId() == livro.getId()) {
				this.emprestimosAtivo.remove(emp);
				this.emprestimosFinalizado.add(emp);
				emp.setStatus("Finalizado");
				emp.getExemplar().setStatus("Disponivel");
				emp.getExemplar().setEmprestimo(null);
				
				if(this.verificarReservaDoUsuario(livro) != null) {
					this.removerReserva(this.verificarReservaDoUsuario(livro));
				}
				
			} else {
				// mostrar mensagem que o usuario não tem emprestimo ativo desse livro
			}
		}
	}
	
	public void realizarEmprestimo(Exemplar exemplar) {
		if (validar.validar(this, exemplar.getLivro()) == true) {
			Emprestimo emp = new Emprestimo(this, exemplar);
			this.emprestimosAtivo.add(emp);
			exemplar.setStatus("Emprestado");
			exemplar.setEmprestimo(emp);
		}
	}
	
	public ArrayList<Emprestimo> listarEmprestimoAtivo(){
		return this.emprestimosAtivo;
	}
	
	public boolean verificaEmprestimoAtrasado(){

		for(Emprestimo emp : listarEmprestimoAtivo()){
			if (emp.getStatus() == "atrasado") {
				return false;
			}
		}
		
		return true;
	}
	
	public void realizarReserva(Reserva reserva) {
		if (reservaAtiva.size() < 3) {
			this.reservaAtiva.add(reserva);
			reserva.getLivro().reservarLivro(reserva);
		} else {
			// Mensagem que não foi possivel reservar o livro por causa da quantidade de reserva já ativa.
		}
	}
	
	public void removerReserva(Reserva r) {
		this.reservaAtiva.remove(r);
		this.reservaFinalizada.add(r);
		r.getLivro().finalizarReserva(r);
	}
	
	public ArrayList<Reserva> listarReservasAtivas(){
		return this.reservaAtiva;
	}
	
	public ArrayList<Reserva> listarReservasFinalizadas(){
		return this.reservaFinalizada;
	}
	
	public boolean verificaEmprestimoAtivoDoLivro(Livro livro) {
		for(Emprestimo emp : this.emprestimosAtivo) {
			 if(emp.getExemplar().getLivro().getId() == livro.getId()) {
				 return false;
			 }
		}
		return true;
	}
	
	public Reserva verificarReservaDoUsuario(Livro l) {
		for(Reserva reserva : this.reservaAtiva) {
			 if(reserva.getLivro().getId() == l.getId()) {
				 return reserva;
			 }
		}
		
		return null;
	}
		
	
	public boolean verificaQuantidadeDeEmprestimoAtivo() {
		// Quantidade máxima de exemplar
		if(listarEmprestimoAtivo().size() < getLimiteEmprestimo()) {
			return true;
		}
		return false;
	}
	
	
	public void consultaUsuario() {
		ArrayList<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
		emprestimos.addAll(this.emprestimosAtivo);
		emprestimos.addAll(this.emprestimosFinalizado);
		
		System.out.println("- Lista de emprestimos -");
		System.out.println("------------------------------------");
		for(Emprestimo emp : emprestimos) {
			 System.out.println("Titulo: "+emp.getExemplar().getLivro().getTitulo());
			 System.out.println("Data do emprestimo: "+emp.getDataEmprestimo());
			 System.out.println("Status: "+emp.getStatus());
			 System.out.println("Data de devolucao: "+emp.getDataParaDevolucao());
			 System.out.println("------------------------------------");
		}
		
		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		reservas.addAll(this.reservaAtiva);
		reservas.addAll(this.reservaFinalizada);
		
		System.out.println("- Lista de reservas -");
		System.out.println("------------------------------------");
		for(Reserva res : reservas) {
			 System.out.println("Titulo: "+res.getLivro().getTitulo());
			 System.out.println("Data de solicitacao: "+res.getDataReserva());
			 System.out.println("------------------------------------");
		}
	}
	
	
	public int getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
}
