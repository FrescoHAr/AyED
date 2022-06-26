package testing;
import contenedores.Lista2DLinkedL;
import recursos.NodoDoble;

// lista ordenada de enteros
public class ListaEnteros2 extends Lista2DLinkedL{
	@Override
	public boolean iguales(Object elemento1, Object elemento2) {
		if (((Integer)elemento1).intValue() == ((Integer)elemento2).intValue()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean esMenor(Object elemento1, Object elemento2) {
		if (((Integer)elemento1).intValue() < ((Integer)elemento2).intValue()) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean esMayor(Object elemento1, Object elemento2) {
		if (((Integer)elemento1).intValue() > ((Integer)elemento2).intValue()){
			return true;
		}else {
			return false;
		}
	}


	public void muestra() {
		NodoDoble temp;

		if (!estaVacia()) {
			temp=this.frenteL; // el primero
			while (temp != null){

				System.out.println(temp.getNodoInfo().toString());
				temp = temp.getNextNodo();
			}
		}else{
			System.out.println("Error muestra. Lista vacia");
		}

	}
}
