package command;

import model.Livro;
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
		dadosTeste.usuario(Integer.parseInt(stringComando[1])).realizarEmprestimo(
					dadosTeste.livro(Integer.parseInt(stringComando[2])));
		
	}
	
	public void realizarDevolucao(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));
		dadosTeste.usuario(Integer.parseInt(stringComando[1])).finalizarEmprestimo(l);

	}
	
	public void realizarReserva(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));
		Reserva r = new Reserva(dadosTeste.usuario(Integer.parseInt(stringComando[1])), l);
		r.getUsuario().realizarReserva(r);
	
	}
	
	public void realizarConsultaLivro(String[] stringComando) {
		Livro l = new Livro();
		l = dadosTeste.livro(Integer.parseInt(stringComando[1]));
		l.consultaLivro();
	}
	
	public void realizarConsultaUsuario(String[] stringComando) {
		dadosTeste.usuario(Integer.parseInt(stringComando[1])).consultaUsuario();
	}
}
