package testing;
import contenedores.Lista1DLinkedL;
import recursos.NodoDoble;

public class ListaEnteros extends Lista1DLinkedL {
	@Override
	public boolean iguales(Object elementoL, Object elemento) {
		if (((Integer)elementoL).intValue() == ((Integer)elemento).intValue()) {
			return true;
		}else {
			return false;
		}
	}

	public void muestra() {
		NodoDoble temp;

		if (!estaVacia()){
			temp=this.frenteL; // el primero
			while (temp != null) {

				System.out.println(temp.getNodoInfo().toString());
				temp = temp.getNextNodo();
			}
		}else{
			System.out.println("Error muestra. Lista vacia");
		}

	}
}
