package testing;
import contenedores.*;
import recursos.*;

// lista ordenada de enteros
public class ListaEnteros2 extends Lista2DLinkedL{
	public boolean iguales(Object elemento1, Object elemento2) {
		if (((Integer)elemento1).intValue() == ((Integer)elemento2).intValue()) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean esMenor(Object elemento1, Object elemento2) {
		if (((Integer)elemento1).intValue() < ((Integer)elemento2).intValue()) {
			return true;
		}else {
			return false;
		}
	}
	
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
