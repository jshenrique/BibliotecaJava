package CommandProfessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class InterfaceUsuario {
	private HashMap<String, Comando> comandos;
	
	public InterfaceUsuario() {
		this.comandos = InicializadorComandos.inicializarComandos();
	}
	
	private String obterComandoConsole() throws IOException {
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println(); 
		System.out.println("Digite o comando:");
		return teclado.readLine();
	}

	private void executarComando(String stringComando) {
		Comando comando = comandos.get(stringComando);
		comando.executar();
	}
	
	public void realizarLoopInteracaoUsuario() throws IOException {
		String stringConando = obterComandoConsole();
		
		while(!stringConando.equals("sai")) {
			executarComando(stringConando);
			
			stringConando = obterComandoConsole();
		}
		
	}
	
	
}
