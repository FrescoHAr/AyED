package contenedores;

import recursos.Contenedor;
import recursos.Nodo;

public class ColaSLinkedList implements Contenedor{
	protected Nodo frenteC;
	protected Nodo finalC;
	
	public ColaSLinkedList() {
		limpiar();
	}
	public ColaSLinkedList(Object o) {
		this.frenteC= new Nodo(o);
		this.finalC=this.frenteC;
	}
	
	@Override
	public void meter(Object o) {
		if(!estaVacia()) {
			this.finalC.setNextNodo(new Nodo(o));
			this.finalC=this.finalC.getNextNodo();
		}else {
			this.frenteC = new Nodo(o);
			this.finalC=this.frenteC;
		}
	}

	@Override
	public Object sacar() {
		if(!estaVacia()) {
			Object primero = this.frenteC.getNodoinfo();
			this.frenteC=this.frenteC.getNextNodo();
			if(estaVacia())
				this.finalC=null;
			return primero;
			
		}
		return null;
	}

	@Override
	public void limpiar() {
		this.frenteC=this.finalC=null;
	}

	@Override
	public boolean estaVacia() {
		return this.frenteC==null;
	}

}
