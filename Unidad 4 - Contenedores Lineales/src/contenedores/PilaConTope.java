package contenedores;

//public class PilaConTope extends PilaArr{
public class PilaConTope extends PilaSLinkedList{
	 /**
	  * Constructor utilizado para la clase PilaArr y sus herederos 
	  */
	/*
	public PilaConTope(int capacidad) {
		super(capacidad);
	}
	*/
	
	/**
	 * Constructor usado para la clase PilaSLinkedList y su descendencia
	 */
	public PilaConTope() {
		super();
	}
	
	public Object topePila() {
		Object tope = this.sacar();
		if(tope!=null)
			this.meter(tope);
		else
			System.out.println("Pila vacia");
		return tope;
	}
}
