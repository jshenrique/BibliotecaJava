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
		
		for (int i = 0; i < this.emprestimosAtivo.size(); i++ ) {
			if (emprestimosAtivo.get(i).getExemplar().getLivro().getId() == livro.getId()) {
				this.emprestimosFinalizado.add(emprestimosAtivo.get(i));
				
				System.out.println("Devolucao concluida com sucesso");
				System.out.println("Usuario: " + this.getNome());
				System.out.println("Livro: " + emprestimosAtivo.get(i).getExemplar().getLivro().getTitulo());
				
				emprestimosAtivo.get(i).getExemplar().setEmprestimo(null);
				
				this.emprestimosAtivo.remove(emprestimosAtivo.get(i));
			}
		}
	}

	public void realizarEmprestimo(Livro livro) throws Exception {
	
			if (validar.validar(this, livro) == true) {
				Exemplar exemplar = new Exemplar();
				exemplar = livro.exemplarParaEmprestimo();
				Emprestimo emp = new Emprestimo(this, exemplar);
				this.emprestimosAtivo.add(emp);
				exemplar.setStatus("Emprestado");
				exemplar.setEmprestimo(emp);

				if (this.verificarReservaDoUsuario(livro) != null) {
					this.removerReserva(this.verificarReservaDoUsuario(livro));
				}

				System.out.println("Emprestimo realizado com sucesso");
				System.out.println("Usuario: " + this.getNome());
				System.out.println("Livro: " + livro.getTitulo());
			}
		
	}

	public ArrayList<Emprestimo> listarEmprestimoAtivo() {
		return this.emprestimosAtivo;
	}

	public boolean verificaEmprestimoAtrasado() {

		for (Emprestimo emp : listarEmprestimoAtivo()) {
			if (emp.getStatus() == "atrasado") {
				return false;
			}
		}

		return true;
	}

	public void realizarReserva(Reserva reserva) throws Exception {
		if (reservaAtiva.size() < 3) {
			this.reservaAtiva.add(reserva);
			reserva.getLivro().reservarLivro(reserva);
			System.out.println("Reserva realizada com sucesso:");
			System.out.println("Usuario: " + this.getNome());
			System.out.println("Livro: " + reserva.getLivro().getTitulo());
		} else {
			throw new Exception("Insucesso: usuário já possui 3 reservas ativas");
		}
	}

	public void removerReserva(Reserva r) {
		this.reservaAtiva.remove(r);
		this.reservaFinalizada.add(r);
		r.getLivro().finalizarReserva(r);
	}

	public ArrayList<Reserva> listarReservasAtivas() {
		return this.reservaAtiva;
	}

	public ArrayList<Reserva> listarReservasFinalizadas() {
		return this.reservaFinalizada;
	}

	public boolean verificaEmprestimoAtivoDoLivro(Livro livro) {
		for (Emprestimo emp : this.emprestimosAtivo) {
			if (emp.getExemplar().getLivro().getId() == livro.getId()) {
				return false;
			}
		}
		return true;
	}

	public Reserva verificarReservaDoUsuario(Livro l) {
		for (Reserva reserva : this.reservaAtiva) {
			if (reserva.getLivro().getId() == l.getId()) {
				return reserva;
			}
		}

		return null;
	}

	public boolean verificaQuantidadeDeEmprestimoAtivo() {
		if (listarEmprestimoAtivo().size() < getLimiteEmprestimo()) {
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
		for (Emprestimo emp : emprestimos) {
			System.out.println("Titulo: " + emp.getExemplar().getLivro().getTitulo());
			System.out.println("Data do emprestimo: " + emp.getDataEmprestimo());
			System.out.println("Status: " + emp.getStatus());
			System.out.println("Data de devolucao: " + emp.getDataParaDevolucao());
			System.out.println("------------------------------------");
		}

		System.out.println("------------------------------------");

		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		reservas.addAll(this.reservaAtiva);
		reservas.addAll(this.reservaFinalizada);

		System.out.println("- Lista de reservas -");
		System.out.println("------------------------------------");
		for (Reserva res : reservas) {
			System.out.println("Titulo: " + res.getLivro().getTitulo());
			System.out.println("Data de solicitacao: " + res.getDataReserva());
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
