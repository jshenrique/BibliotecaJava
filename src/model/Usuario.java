package model;

import java.util.ArrayList;

import strategy.ValidadorEmprestimo;
import system.InterfaceUsuario;
import util.Mensagem;

/** 
 * Representa um usuário do sistema 
 * 
 * @since 1.0
*/
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
				emprestimosAtivo.get(i).setStatus("Finalizado");
				emprestimosAtivo.get(i).getExemplar().setStatus("Disponivel");;
				
				InterfaceUsuario.obterInstancia().imprimirMensagem(Mensagem.DEVOLUCAO_SUCESSO);
				InterfaceUsuario.obterInstancia().imprimirMensagem("Usuario: " + this.getNome());
				InterfaceUsuario.obterInstancia().imprimirMensagem("Livro: " + emprestimosAtivo.get(i).getExemplar().getLivro().getTitulo());
				
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

				InterfaceUsuario.obterInstancia().imprimirMensagem(Mensagem.EMPRESTIMO_SUCESSO);
				InterfaceUsuario.obterInstancia().imprimirMensagem("Usuario: " + this.getNome());
				InterfaceUsuario.obterInstancia().imprimirMensagem("Livro: " + livro.getTitulo());
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
			
			InterfaceUsuario.obterInstancia().imprimirMensagem(Mensagem.RESERVA_SUCESSO);
			InterfaceUsuario.obterInstancia().imprimirMensagem("Usuario: " + this.getNome());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Livro: " + reserva.getLivro().getTitulo());
			
		} else {
			throw new Exception(Mensagem.TRES_RESERVAS_ATIVAS_ERRO);
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

		InterfaceUsuario.obterInstancia().imprimirMensagem("- Lista de emprestimos -");
		InterfaceUsuario.obterInstancia().imprimirMensagem("------------------------------------");
		for (Emprestimo emp : emprestimos) {
			InterfaceUsuario.obterInstancia().imprimirMensagem("Titulo: " + emp.getExemplar().getLivro().getTitulo());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Data do emprestimo: " + emp.getDataEmprestimo());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Status: " + emp.getStatus());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Data de devolucao: " + emp.getDataParaDevolucao());
			InterfaceUsuario.obterInstancia().imprimirMensagem("------------------------------------");
		}

		InterfaceUsuario.obterInstancia().imprimirMensagem("------------------------------------");

		ArrayList<Reserva> reservas = new ArrayList<Reserva>();
		reservas.addAll(this.reservaAtiva);
		reservas.addAll(this.reservaFinalizada);

		InterfaceUsuario.obterInstancia().imprimirMensagem("- Lista de reservas -");
		InterfaceUsuario.obterInstancia().imprimirMensagem("------------------------------------");
		for (Reserva res : reservas) {
			InterfaceUsuario.obterInstancia().imprimirMensagem("Titulo: " + res.getLivro().getTitulo());
			InterfaceUsuario.obterInstancia().imprimirMensagem("Data de solicitacao: " + res.getDataReserva());
			InterfaceUsuario.obterInstancia().imprimirMensagem("------------------------------------");
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
