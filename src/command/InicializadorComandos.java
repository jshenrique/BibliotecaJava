package command;

import java.util.HashMap;

public class InicializadorComandos {
	public static HashMap<String, Comando> inicializarComandos(String stringComando[]){
		HashMap<String, Comando> comandos = new HashMap<String, Comando>();

		comandos.put("emp", new ComandoRealizarEmprestimo());
		comandos.put("res", new ComandoRealizarReserva());
		comandos.put("dev", new ComandoRealizarDevolucao());
		comandos.put("liv", new ComandoRealizarConsultaLivro());
		comandos.put("usu", new ComandoRealizarConsultaUsuario());
		comandos.put("obs", new ComandoRegistrarObservador());
		comandos.put("ntf", new ComandoRealizarConsultaNotificacao());
		return comandos;	
	}

}
