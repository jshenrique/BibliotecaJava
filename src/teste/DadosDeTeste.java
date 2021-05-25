package teste;

import java.util.ArrayList;

import model.AlunoGraduacao;
import model.AlunoPosGraduacao;
import model.Emprestimo;
import model.Exemplar;
import model.Livro;
import model.Professor;
import model.Usuario;

public class DadosDeTeste {
	private ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
	private ArrayList<Livro> livros = new ArrayList<Livro>();

	
	public DadosDeTeste() {
		this.instanciaUsuarios();
		this.instanciaLivros();		
	}
	
	public Usuario usuario(int codigoUsuario) {
		for(Usuario u : usuarios) {
			if(u.getIdUsuario() == codigoUsuario) {
				return u;
			}
		}
		return null;
	}
	
	public Livro livro(int codigoLivro) {
		for(Livro l : livros) {
			if(l.getId() == codigoLivro) {
				return l;
			}
		}
		return null;
	}
	
	public void instanciaUsuarios(){
		Usuario userG = new AlunoGraduacao();
		userG.setIdUsuario(123);
		userG.setNome("Joao da Silva");
		this.usuarios.add(userG);
		
		Usuario userP = new AlunoPosGraduacao();
		userP.setIdUsuario(456);
		userP.setNome("Luiz Fernando Rodrigues");
		this.usuarios.add(userP);
		
		Usuario userG2 = new AlunoGraduacao();
		userG2.setIdUsuario(789);
		userG2.setNome("Pedro Paulo");
		this.usuarios.add(userG2);

		Usuario prof = new Professor();
		prof.setIdUsuario(100);
		prof.setNome("Carlos Lucena");
		this.usuarios.add(prof);
	}
	
	
	public void instanciaLivros(){
		Livro l = new Livro();
		l.setId(100);
		l.setTitulo("Engenharia de Software");
		l.setEditora("AddisonWesley");
		l.setAutores("Ian Sommervile");
		l.setEdicao(6);
		l.setAnoPublicacao(2000);
		
		Exemplar e = new Exemplar();
		e.setIdExemplar(01);
		e.setStatus("Disponivel");
		e.setLivro(l);
		l.adicionarExemplar(e);
		
		Exemplar e12 = new Exemplar();
		e12.setIdExemplar(02);
		e12.setStatus("Disponivel");
		e12.setLivro(l);
		l.adicionarExemplar(e12);
		
		this.livros.add(l);
		
		Livro l2 = new Livro();
		l2.setId(101);
		l2.setTitulo("UML - Guia do Usuario");
		l2.setEditora("Campus");
		l2.setAutores("Grady Booch, James Rumbaugn, Ivan Jacobson");
		l2.setEdicao(7);
		l2.setAnoPublicacao(2000);
		
		Exemplar e2 = new Exemplar();
		e2.setIdExemplar(03);
		e2.setStatus("Disponivel");
		e2.setLivro(l2);
		l2.adicionarExemplar(e);
		
		this.livros.add(l2);

		Livro l3 = new Livro();
		l3.setId(200);
		l3.setTitulo("Code Complete");
		l3.setEditora("Microsoft Press");
		l3.setAutores("Steve McConnell");
		l3.setEdicao(2);
		l3.setAnoPublicacao(2014);
		
		Exemplar e3 = new Exemplar();
		e3.setIdExemplar(04);
		e3.setStatus("Disponivel");
		e3.setLivro(l3);
		l3.adicionarExemplar(e3);
		this.livros.add(l3);
		
		Livro l4 = new Livro();
		l4.setId(201);
		l4.setTitulo("Agile Software Development, Principles, Patterns, and Practices");
		l4.setEditora("Prentice Hall");
		l4.setAutores("Robert Martin");
		l4.setEdicao(1);
		l4.setAnoPublicacao(2002);
		
		Exemplar e4 = new Exemplar();
		e4.setIdExemplar(05);
		e4.setStatus("Disponivel");
		e4.setLivro(l4);
		l4.adicionarExemplar(e4);
		
		this.livros.add(l4);

		Livro l5 = new Livro();
		l5.setId(300);
		l5.setTitulo("Refactoring: Improving the Design of Existing Code");
		l5.setEditora("Addison-Wesley Professional");
		l5.setAutores("Martin Fowler");
		l5.setEdicao(1);
		l5.setAnoPublicacao(1999);
		
		Exemplar e5 = new Exemplar();
		e5.setIdExemplar(06);
		e5.setStatus("Disponivel");
		e5.setLivro(l5);
		l5.adicionarExemplar(e5);
		
		Exemplar e6 = new Exemplar();
		e6.setIdExemplar(07);
		e6.setStatus("Disponivel");
		e6.setLivro(l5);
		l5.adicionarExemplar(e6);

		this.livros.add(l5);
		
		Livro l6 = new Livro();
		l6.setId(301);
		l6.setTitulo("Software Metrics: A Rigorous and Practical Approach");
		l6.setEditora("CRC Press");
		l6.setAutores("Norman Fenton, James Bieman");
		l6.setEdicao(3);
		l6.setAnoPublicacao(2014);
		this.livros.add(l6);
		
		Livro l7 = new Livro();
		l7.setId(400);
		l7.setTitulo("Design Patters: Elements of Reusable Object-Oriented Software");
		l7.setEditora("Addison-Wesley Professional");
		l7.setAutores("Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides");
		l7.setEdicao(1);
		l7.setAnoPublicacao(1994);
		
		Exemplar e7 = new Exemplar();
		e7.setIdExemplar(8);
		e7.setStatus("Disponivel");
		e7.setLivro(l7);
		l7.adicionarExemplar(e7);

		Exemplar e8 = new Exemplar();
		e8.setIdExemplar(9);
		e8.setStatus("Disponivel");
		e8.setLivro(l7);
		l7.adicionarExemplar(e8);
		
		this.livros.add(l7);

		
		Livro l8 = new Livro();
		l8.setId(401);
		l8.setTitulo("UML Distilled: A Brief Guide to the Standard Object Modeling Language");
		l8.setEditora("Addison-Wesley Professional");
		l8.setAutores("Martin Fowler");
		l8.setEdicao(3);
		l8.setAnoPublicacao(2003);
		this.livros.add(l8);
		
	}
		
}
