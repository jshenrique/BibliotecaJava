package command;

import java.util.HashMap;

public class InicializadorComandos {
	public static HashMap<String, Comando> inicializarComandos(String stringComando[]){
		HashMap<String, Comando> comandos = new HashMap<String, Comando>();
		//comando = comandos.split(2,3);
		//comandos = comandos.split(1);
		//comandos.put(comando.split(1), new ComandoRealizarEmprestimo(comando.split(1), comando.split(1)));
				
		comandos.put("emp", new ComandoRealizarEmprestimo());
		comandos.put("res", new ComandoRealizarReserva());
		comandos.put("dev", new ComandoRealizarDevolucao());
		comandos.put("liv", new ComandoRealizarConsultaLivro());
		comandos.put("usu", new ComandoRealizarConsultaUsuario());
		
		return comandos;
		
	}

}
