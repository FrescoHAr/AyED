package contenedores;
import recursos.NodoDoble;
import recursos.OperacionesCL4;

// lista ordenada
public abstract class Lista2DLinkedL extends Lista0DLinkedL implements OperacionesCL4 {

	// insercion ordenada
	@Override
	public void insertar(Object elemento) {
		NodoDoble nodo;

		if (estaVacia()) {
			this.frenteL = this.finalL = new NodoDoble(elemento);

		} else{
			if (esMenor(elemento, this.frenteL.getNodoInfo())) {		//insercion al frente
				this.frenteL = new NodoDoble(elemento, null, this.frenteL); // nuevo frente
				this.frenteL.getNextNodo().setPrevNodo(this.frenteL); // vamos al 2do y conectamos con el 1ero

			}else{

				if (esMayor(elemento, this.finalL.getNodoInfo()) || iguales(elemento, this.finalL.getNodoInfo())) {	//insercion al final, si es igual no puede ponerse antes.
					//Al final
					//Mi porcion de codigo
					this.finalL.setNextNodo(new NodoDoble(elemento));
					this.finalL.getNextNodo().setPrevNodo(this.finalL);
					this.finalL = this.finalL.getNextNodo();


				}else{
					// al medio
					NodoDoble temp = this.frenteL;
					boolean flag = false;
					while (temp.getNextNodo() != null && !flag) {
						if (esMayor(elemento, temp.getNextNodo().getNodoInfo()) || iguales(elemento, temp.getNextNodo().getNodoInfo())) {
							temp = temp.getNextNodo();
						}else{
							flag = true;
						}
					}

					// insercion al medio. entre temp y temp.next
					nodo = new NodoDoble(elemento, temp, temp.getNextNodo());
					temp.getNextNodo().setPrevNodo(nodo);
					temp.setNextNodo(nodo);
				}
			}
		}

		this.ultimo++; // incrementamos "ultima posicion" de lista
	}

	public abstract boolean iguales(Object elemento1, Object elemento2);
	public abstract boolean esMenor(Object elemento1, Object elemento2);
	public abstract boolean esMayor(Object elemento1, Object elemento2);

	// implementar algún metodo de búsqueda
	@Override
	public int buscar(Object elemento){
		if(!this.estaVacia()) { //Implemento busqueda secuencial para evitar recorrer varias veces la lista buscando ubicar el medio para una busqueda binaria
			NodoDoble nodo =this.frenteL;
			int i=0;
			while(nodo!=null) {
				if(iguales(nodo.getNodoInfo(), elemento))
					return i;
				i++;
				nodo = nodo.getNextNodo();
			}
			return -1;
		}
		return -1;
	}

}
