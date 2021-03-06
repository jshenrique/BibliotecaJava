package system;

import model.Livro;
import model.Professor;
import model.Reserva;
import teste.DadosDeTeste;

/** 
 * Fachada do Sistema de Biblioteca - Padr?es Fa?ade e Singleton
 *  
 * @since 1.0
*/
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
			InterfaceUsuario.obterInstancia().imprimirMensagemErro(e.getMessage());
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
		l.verificaQtdeReservas();
		Reserva r = new Reserva(dadosTeste.usuario(Integer.parseInt(stringComando[1])), l);
		
		try {
			r.getUsuario().realizarReserva(r);
		} catch (Exception e) {
			InterfaceUsuario.obterInstancia().imprimirMensagemErro(e.getMessage());
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
	
		Professor observer = dadosTeste.professor(Integer.parseInt(stringComando[1]));
		Livro l = new Livro();		
		l = dadosTeste.livro(Integer.parseInt(stringComando[2]));		
		l.addObservador(observer);
		
		InterfaceUsuario.obterInstancia().imprimirMensagem("Observador registrado com sucesso \nUsuario: " + observer.getNome() + "\nLivro: "+ l.getTitulo());
	
	}
	
	public void realizarConsultaNotificacao(String[] stringComando) {
		Professor observer = dadosTeste.professor(Integer.parseInt(stringComando[1]));
		
		InterfaceUsuario.obterInstancia().imprimirMensagem("Registro de notifica??es " + observer.consultaNotificacao());
	}
}
