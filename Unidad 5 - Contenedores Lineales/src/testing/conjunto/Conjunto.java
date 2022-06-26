package testing.conjunto;

import contenedores.Lista2DLinkedL;
import recursos.OperacionesConjunto;

public abstract class Conjunto extends Lista2DLinkedL implements OperacionesConjunto{
	public boolean esta(Object o) {
		return buscar(o)>=0;
	}
	
	public void meter(Object o) {
		int pos = buscar(o);
		if(pos==-1)
			super.insertar(o);
		else
			System.out.println("Error. El valor que intenta ingresar ya pertenece al conjunto");
	}
	
	public void sacar(Object o) {
		int pos = buscar(o);
		if(pos>=0) {
			this.eliminar(pos);
		}else {
			System.out.println("El elemento que desea sacar no se encuentra en el conjunto");
		}
	}
}
