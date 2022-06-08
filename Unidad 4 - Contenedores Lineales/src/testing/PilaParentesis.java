package testing;

import contenedores.PilaSLinkedList;

public class PilaParentesis {
	PilaSLinkedList pila;
	public PilaParentesis() {
		pila = new PilaSLinkedList();
	}
	
	public boolean verificarCadena(String cadena) {
		for(int i=0;i<cadena.length();i++) {
			if(cadena.charAt(i) == '(')
				this.pila.meter('(');
			else {
				if(cadena.charAt(i)==')') {
					if(!this.pila.estaVacia()) {
						this.pila.sacar();
					}else {
						return false;
					}
				}
			}
		
		}
		return this.pila.estaVacia();
	}

}
