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
			System.out.println("entré");
			this.frenteC = new Nodo(o);
			this.finalC=this.frenteC;
			System.out.println("Frente: "+this.frenteC);
		}
	}

	@Override
	public Object sacar() {
		if(!estaVacia()) {
			Object primero = this.frenteC.getNodoinfo();
			System.out.println(primero+" es el primero");
			this.frenteC=this.frenteC.getNextNodo();
			if(estaVacia())
				this.finalC=null;
			return primero;
			
		}
		System.out.println("Paso por aqui");
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
