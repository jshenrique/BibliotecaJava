package teste;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import model.AlunoGraduacao;
import model.Emprestimo;
import model.Exemplar;
import model.Livro;
import model.Reserva;
import model.Usuario;


public class Main {

	public static void main(String[] args) {
		/*
		String s = "emp 111 222";
		
		System.out.println(s);
		
		String array[] = new String[3];
		array = s.split(" ");
		
		System.out.println(array[0]);
		*/
		
		// ArrayList<Exemplares> e = new ArrayList();
		// e.add(idLivro, idExemplar, status);
		// e.add(idLivro, idExemplar, status);
		
		// e.add(exemplar);
		
		
		AlunoGraduacao u = new AlunoGraduacao();
		Livro l = new Livro();
		Livro l2 = new Livro();

		Exemplar e1 = new Exemplar();
		Exemplar e2 = new Exemplar();
		Exemplar e3 = new Exemplar();

		
		u.setIdUsuario(100);
		u.setNome("Maria");
		
		l.setId(100);
		l.setTitulo("Engenharia de Software");
		l.setAnoPublicacao(0);
		l.setAutores(null);
		l.setEdicao(0);
		l.setEditora(null);
		
		l2.setId(400);
		l2.setTitulo("UML 2.0");
		l2.setAnoPublicacao(2020);
		l2.setAutores(null);
		l2.setEdicao(0);
		l2.setEditora(null);
		
		e1.setIdExemplar(01);
		//e1.setIdLivro(l.getId());
		e2.setIdExemplar(02);
		//e2.setIdLivro(l.getId());
		e3.setIdExemplar(03);
		//e3.setIdLivro(l.getId());
		
		l.adicionarExemplar(e1);
		e1.setLivro(l);
		l.adicionarExemplar(e2);

		l2.adicionarExemplar(e3);
		
		
		
		//Reserva r = new Reserva(u, l);
		//Reserva r2 = new Reserva();
		//l.reservarLivro(r);
		//u.realizarReserva(r);
		
		//r2 = l.listarReservasAtivas().get(0);
		//System.out.println(r2.getLivro().getTitulo());
	
		//Emprestimo emp = new Emprestimo(u, e1);
		u.realizarEmprestimo(l);
		u.realizarEmprestimo(l2);
				
		//u.consultaUsuario();
		//l.consultaLivro();
		
		//System.out.println("E: "+u.listarEmprestimoAtivo().get(0).getDataEmprestimo()+"\nD: "+u.listarEmprestimoAtivo().get(0).getDataParaDevolucao());
		
		/* LocalDate dataEmprestimo = LocalDate.now();
		 LocalDate dataParaDevolucao = dataEmprestimo.plusDays(5);
		 
		 System.out.println("Dia do emprestimo: "+dataEmprestimo);
		 System.out.println("Data para devolucao: "+dataParaDevolucao);*/
		 
		 
		/*emp = new Emprestimo(u, e2);
		u.realizarEmprestimo(e2);
		
		emp = new Emprestimo(u, e3);
		u.realizarEmprestimo(e3);*/

		//System.out.println(u.verificaQuantidadeDeEmprestimoAtivo());
		
		/*
		//Regras emprestimo aluno
		//R4 - verifica reservas
		l.verificarDisponibilidade(); // Se retornar true é porque ta disponível.
		
		//R5 - verificar se o usuario tem uma reserva do livro.
		l.verificarReservaDoUsuario(u); // Se retornar true é porque o usuario reservou o livro.
		
		//R6 - verificar se tem emprestimo ativo do livro.
		u.verificaEmprestimoAtivoDoLivro(l); // Se retornar true é pq não tem emprestimo ativo do mesmo livro.
		
		//R3 - Verifica a quantidade de emprestimo ativo.
		u.verificaQuantidadeDeEmprestimoAtivo(); // Se retornar true é pq ele ainda nao atingiu a quantidade maxima de emprestimo simultaneo
		*/
	}

}
