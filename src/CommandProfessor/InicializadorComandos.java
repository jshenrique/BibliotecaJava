package CommandProfessor;

import java.util.HashMap;

public class InicializadorComandos {
	public static HashMap<String, Comando> inicializarComandos(){
		HashMap<String, Comando> comandos = new HashMap<String, Comando>();
		
		comandos.put("emp", new ComandoRealizarEmprestimo());
		comandos.put("res", new ComandoRealizarReserva());
		comandos.put("dev", new ComandoRealizarDevolucao());
		
		return comandos;
		
	}

}
