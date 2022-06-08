package contenedores;

import recursos.Contenedor;

public class ColaArr implements Contenedor{
	protected int tam;
	protected int primero;
	protected int ultimo;
	private Object[] cola;
	
	public ColaArr(int tam) {
		this.tam= tam+1;
		this.primero=tam;
		this.ultimo=tam;
		this.cola = new Object[tam+1];
	}
	
	
	public boolean estaLlena() {
		int p;
		if(this.ultimo==this.tam-1)
			p=0;
		else
			p=this.ultimo+1;
		return p==this.primero;
	}

	private void incrementarUltimo() {
		if(this.ultimo==this.tam-1)
			this.ultimo=0;
		else
			this.ultimo++;
	}
	
	private void incrementarPrimero() {
		if(this.primero==this.tam-1)
			this.primero=0;
		else
			this.primero++;
	}
	
	
	
	@Override
	public void meter(Object o) {
		if(!estaLlena()) {
			incrementarUltimo();
			this.cola[this.ultimo]=o;
		}else
			System.out.println("Imposible meter. Cola llena");
	}


	@Override
	public Object sacar() {
		if(!estaVacia()) {
			incrementarPrimero();
			return this.cola[this.primero];
		}else {
			System.out.println("Cola vacia");
		}
		return null;
	}


	@Override
	public void limpiar() {
		this.ultimo=this.tam-1;
		this.primero=this.ultimo;
	}


	@Override
	public boolean estaVacia() {
		return this.ultimo==this.primero;
	}
	
	

}
