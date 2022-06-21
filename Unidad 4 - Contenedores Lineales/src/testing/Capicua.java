package testing;

import contenedores.ColaArr;
import contenedores.ColaSLinkedList;
import contenedores.PilaArr;
import contenedores.PilaSLinkedList;

public class Capicua {
	PilaSLinkedList pila;
	ColaSLinkedList cola;
	
	public Capicua() {
		pila = new PilaSLinkedList();
		cola = new ColaSLinkedList();
	}
	public Capicua(PilaSLinkedList pila) {
		this();
		separar(pila);
	}
	
	public void separar(PilaSLinkedList pila) {
		ColaArr colaDigitos;
		PilaArr pilaDigitos;
		while(!pila.estaVacia()) {
			int ultimo = (int) pila.sacar();
			int aux = ultimo;
			colaDigitos = new ColaArr(String.valueOf(ultimo).length());
			pilaDigitos = new PilaArr(String.valueOf(ultimo).length());
			while(ultimo>0) {
				int digito = ultimo%10;
				ultimo /=10;
				colaDigitos.meter(digito);
				pilaDigitos.meter(digito);
			}
			while(!pilaDigitos.estaVacia()&&!colaDigitos.estaVacia()) {
				if(pilaDigitos.sacar()!=colaDigitos.sacar())
					break;
			}
			if(pilaDigitos.estaVacia()) {
				this.cola.meter(aux);
			}else {
				this.pila.meter(aux);
			}
		}
		invertirPila();
	
	}
	
	private void invertirPila() {
		PilaSLinkedList nueva = new PilaSLinkedList();
		while(!pila.estaVacia()) {
			nueva.meter(pila.sacar());
		}
		this.pila= nueva;
	}
	
	public void mostrarPila() {
		System.out.println("Pila:");
		while(!this.pila.estaVacia()) {
			System.out.println((int)this.pila.sacar());
		}
		System.out.println("---Fin de pila---");
	}
	
	public void mostrarCola() {
		System.out.println("Cola:");
		while(!this.cola.estaVacia()){
			System.out.println((int)cola.sacar());
		}
		System.out.println("---Fin de cola---");
	}
	

}
