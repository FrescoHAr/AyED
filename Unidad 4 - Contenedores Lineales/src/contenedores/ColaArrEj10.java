package contenedores;

import recursos.MetodosEj10;

public class ColaArrEj10 extends ColaArr implements MetodosEj10{

	public ColaArrEj10(int tam) {
		super(tam);
	}

	@Override
	public int cardinal() {
		if(this.estaVacia()) {
			return 0;
		}else {
			if(this.primero==this.tam-1)
				return this.ultimo+1;
			else
				if(this.ultimo>this.primero)
					return this.ultimo-this.primero;
				else
					return this.tam - (this.primero+this.ultimo);
		}
		
	}

	@Override
	public void invertir() {
		PilaArr pila = new PilaArr(cardinal());
		while(!estaVacia()) {
			pila.meter(sacar());
		}
		while(!pila.estaVacia()) {
			meter(pila.sacar());
		}
		
	}

	@Override
	public void concatenar(Object o) {
		ColaArrEj10 aux = (ColaArrEj10) o;
		while(!aux.estaVacia()&&!this.estaLlena()) {
			this.meter(aux.sacar());
		}
		if(!aux.estaVacia())
			System.out.println("No se pudo completar la concatenacion. Cola llena");
	}

}
