package contenedores;

import recursos.Contenedor;

public class PilaArr implements Contenedor{
	private int capacidad;
	private int ultimo;
	private Object pila[];
	
	public PilaArr(int capacidad) {
		this.capacidad = capacidad;
		this.pila=new Object[this.capacidad];
		limpiar();
	}
	
	
	public int getCapacidad() {
		return capacidad;
	}


	@Override
	public void meter(Object o) {
		if(!estaLlena()) {
			this.ultimo++;
			this.pila[this.ultimo] = o;
		}else {
			System.out.println("Imposible meter. Pila llena");
		}
	}

	@Override
	public Object sacar() {
		if(!estaVacia()) {
			this.ultimo--;
			return this.pila[this.ultimo+1];
		}else {
			System.out.println("Imposible sacar. Pila vacia");
		}
		return null;
	}

	@Override
	public void limpiar() {
		this.ultimo=-1;
		
	}

	@Override
	public boolean estaVacia() {
		return this.ultimo==-1;
	}
	
	public boolean estaLlena() {
		return this.capacidad ==this.ultimo+1;
	}

}
