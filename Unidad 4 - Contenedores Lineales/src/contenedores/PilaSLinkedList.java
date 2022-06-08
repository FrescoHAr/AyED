package contenedores;

import recursos.Contenedor;
import recursos.Nodo;

public class PilaSLinkedList implements Contenedor{
	private Nodo pila;
	
	public PilaSLinkedList() {
		limpiar();
	}
	
	@Override
	public void meter(Object o) {
		this.pila = new Nodo(o,this.pila);
	}

	@Override
	public Object sacar() {
		Object ultimo = null;
		if(!estaVacia()) {
			ultimo = this.pila.getNodoinfo();
			this.pila = this.pila.getNextNodo();
		}
		else
			System.out.println("Pila vacia");
		return ultimo;
	}

	@Override
	public void limpiar() {
		this.pila=null;
	}

	@Override
	public boolean estaVacia() {
		return this.pila == null;
	}
	
}
