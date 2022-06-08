package contenedores;

import recursos.MetodosEj10;

public class ColaSLinkedListEj10 extends ColaSLinkedList implements MetodosEj10{
	
	
	@Override
	public int cardinal() {
		int i=0;
		ColaSLinkedList aux = new ColaSLinkedList();
		while(!estaVacia()) {
			aux.meter(sacar());
			i++;
		}
		while(!aux.estaVacia())
			meter(aux.sacar());
		return i;
	}

	@Override
	public void invertir() {
		ColaSLinkedList aux = new ColaSLinkedList();
		while(!estaVacia()) {
			aux.meter(sacar());
		}
		while(!aux.estaVacia()) {
			meter(aux.sacar());
		}
		
	}

	@Override
	public void concatenar(Object o) {
		ColaArr otra = (ColaArr) o;
		while(!otra.estaVacia())
			meter(otra.sacar());
		
	}

}
