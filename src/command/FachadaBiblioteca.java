package command;

import model.Livro;
import model.Professor;
import model.Reserva;
import teste.DadosDeTeste;

public class FachadaBiblioteca {
	private static FachadaBiblioteca instancia;
	private DadosDeTeste dadosTeste = new DadosDeTeste();
	
	private FachadaBiblioteca() {}
	
	public static FachadaBiblioteca obterInstancia() {
		if(instancia == null){
			instancia = new FachadaBiblioteca();
		}
		return instancia;
	}
	
	public void realizarEmprestimo(String[] stringComando) {
		try {
			dadosTeste.usuario(Integer.parseInt(stringComando[1])).realizarEmprestimo(
						dadosTeste.livro(Integer.parseInt(stringComando[2])));
		
		} catch (Exception e) {
			
			System.err.println(e.getMessage());
		}
		
	}
	
	public void realizarDevolucao(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));
		dadosTeste.usuario(Integer.parseInt(stringComando[1])).finalizarEmprestimo(l);

	}
	
	public void realizarReserva(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));
		//verificar se tem mais de 2 reservas para notificar profs
		l.verificaQtdeReservas();
		Reserva r = new Reserva(dadosTeste.usuario(Integer.parseInt(stringComando[1])), l);
		
		try {
			r.getUsuario().realizarReserva(r);
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	
	}
	
	public void realizarConsultaLivro(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[1]));
		l.consultaLivro();
	}
	
	public void realizarConsultaUsuario(String[] stringComando) {
		dadosTeste.usuario(Integer.parseInt(stringComando[1])).consultaUsuario();
	}
	
	public void registrarObservador(String[] stringComando) {
	
		//usuario
		Professor observer = dadosTeste.professor(Integer.parseInt(stringComando[1]));
		//livro
		Livro l = new Livro();		
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));		
		l.addObservador(observer);
		
		System.out.println("Observador registrado com sucesso \nUsuario: " + observer.getNome() + "\nLivro: "+ l.getTitulo());
	
	}
	
	public void realizarConsultaNotificacao(String[] stringComando) {
		Professor observer = dadosTeste.professor(Integer.parseInt(stringComando[1]));
		observer.consultaNotificacao();
	}
	
}
