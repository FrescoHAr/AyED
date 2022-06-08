package testing;

import contenedores.PilaArr;
import contenedores.PilaSLinkedList;

public class PilaEnteros {
	PilaArr pila;
	PilaSLinkedList aux;
	
	public PilaEnteros(int cant) {
		this.pila =new PilaArr(cant); 
		this.aux= new PilaSLinkedList();
	}
	
	public void generarPila() {
		while(!this.pila.estaLlena()) {
			this.pila.meter((int)(Math.random()*500));
		}
	}
	
	public void mostrarPila() {
		System.out.println("Inicio de pila: ");
		while(!this.pila.estaVacia()) {
			int ultimo = (int) this.pila.sacar();
			System.out.println(ultimo);
			this.aux.meter(ultimo);
		}
		vaciarAux();
		System.out.println("Fin de pila");
	}
	
	public void reempleazar(int en, int nuevo) {
		while(!this.pila.estaVacia()) {
			int ultimo =  (int) this.pila.sacar();
			if(ultimo == en) {
				this.aux.meter(nuevo);
			}else {
				this.aux.meter(ultimo);
			}
		}
		vaciarAux();
	}
	
	private void vaciarAux() {
		while(!this.aux.estaVacia()) {
			this.pila.meter(this.aux.sacar());
		}
	}
	

}
