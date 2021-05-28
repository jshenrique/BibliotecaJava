package observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/** 
* Representa um Suject - padrão Observer
* 
* @since 1.0
*/
public abstract class Sujeito {
	
	private List<Observador> observers = new ArrayList<Observador>();	
	  
	  public void addObservador(Observador observer) {
	    observers.add(observer);
	  }
	  
	  public void removerObservador(Observador observer) {
	    observers.remove(observer);
	  }
	  
	  public void notificarObservadores() {
	    Iterator<Observador> it = observers.iterator();
	    while (it.hasNext()) {
	      Observador obs= (Observador) it.next();
	      obs.atualizar(this); 
	    }
	  }

}
