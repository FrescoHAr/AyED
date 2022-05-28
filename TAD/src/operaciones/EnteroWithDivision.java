package operaciones;

import interfaces.OperacionesWithDivision;

public class EnteroWithDivision extends Entero implements OperacionesWithDivision{
	
	
	/**
	 * 
	 */
	public EnteroWithDivision() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param e
	 */
	public EnteroWithDivision(Entero e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param valor
	 */
	public EnteroWithDivision(int valor) {
		super(valor);
		// TODO Auto-generated constructor stub
	}

	/**
	 * Almacena en la instancia que llama al metodo el resultado de la division entera entre esta y el Entero que se envia por parametro
	 */
	@Override
	public void dividir(Object o) {
		Entero e = (Entero)o;
		while(this.getValor()>e.getValor()) {
			this.setValor(this.getValor()-e.getValor());
		}
		
	}
}
