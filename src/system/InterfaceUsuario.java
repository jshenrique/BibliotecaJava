package system;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import command.Comando;
import command.InicializadorComandos;

public class InterfaceUsuario {
	
	private static InterfaceUsuario instanciaInterfaceUsuario;
	
	private HashMap<String, Comando> comandos;
	
	private InterfaceUsuario() {		
	}
	
	public static InterfaceUsuario obterInstancia() {
		if(instanciaInterfaceUsuario == null){
			instanciaInterfaceUsuario = new InterfaceUsuario();
		}
		return instanciaInterfaceUsuario;
	}
	
	private String obterComandoConsole() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(); 
		System.out.println("Digite o comando:");
		return teclado.readLine();
	}

	private void executarComando(String stringComando) {
		
		String array[] = new String[3];
		array = stringComando.split(" ");
		
		this.comandos = InicializadorComandos.inicializarComandos(array);
		
		Comando comando = comandos.get(array[0]);
		comando.executar(array);
	}
	
	public void realizarLoopInteracaoUsuario() throws IOException {
		String stringComando = obterComandoConsole();
		
		while(!stringComando.equals("sai")) {
			executarComando(stringComando);			
			stringComando = obterComandoConsole();
		}
		
	}
	
	public void imprimirMensagem(String mensagem) {
		System.out.println(mensagem);
	}
	
	public void imprimirMensagemErro(String mensagemErro) {
		System.err.println(mensagemErro);
	}
	
	
}
