package operaciones;

import interfaces.Operaciones;

/**
 * @author frescoh.ar
 * Hernán Fresco
 * http://frescoh.ar
 */
public class Racional implements Operaciones{
	private Entero numerador;
	private Entero denominador;
	
	/**Full constructor Racional
	 * @param numerador
	 * @param denominador - debe ser distinto de 0
	 */
	public Racional(Entero numerador, Entero denominador) {
		this.numerador = new Entero(numerador);
		this.denominador= new Entero(denominador);
		this.simplificar();
	}
	
	/**
	 * 
	 * @return numerador - int 
	 */
	public Entero getNumerador() {
		return numerador;
	}
	
	/**
	 * set numerador 
	 * @param numerador - int 
	 */
	public void setNumerador(Entero numerador) {
		this.numerador = numerador;
	}
	
	/**
	 * 
	 * @return denominador - int
	 */
	public Entero getDenominador() {
		return denominador;
	}
	
	/**
	 * 
	 * @param denominador - int
	 */
	public void setDenominador(Entero denominador) {
		this.denominador = denominador;
	}
	
	
	private void simplificar() {
		int mcd= numerador.mcd(denominador);
		this.denominador.setValor(this.getDenominador().getValor()/mcd);
		this.numerador.setValor(this.getNumerador().getValor()/mcd);
		
	}
	
	@Override
	/**
	 * Suma dos racionales a y b y almacena el valor en el racional que llama a la operacion
	 * @param a - Racional
	 * @param b - Racional
	 * @return Void
	 * a.sumar(a,b) entonces a = a+b
	 */
	public void sumar(Object a, Object b) {
		Racional r1 = (Racional) a;
		Racional r2 = (Racional) b;
		int numerador = r1.getNumerador().getValor()*r2.getDenominador().getValor()+r2.getNumerador().getValor()*r1.getDenominador().getValor();
		int denominador = r1.getDenominador().getValor()*r2.getDenominador().getValor();
		this.numerador.setValor(numerador);
		this.denominador.setValor(denominador);
		this.simplificar();
		
	}

	@Override
	public void restar(Object a, Object b) {
		Racional r1 = (Racional) a;
		Racional r2 = (Racional) b;
		int numerador = r1.getNumerador().getValor()*r2.getDenominador().getValor()-r2.getNumerador().getValor()*r1.getDenominador().getValor();
		int denominador = r1.getDenominador().getValor()*r2.getDenominador().getValor();
		this.numerador.setValor(numerador);
		this.denominador.setValor(denominador);
		this.simplificar();
		
	}

	@Override
	public void multiplicar(Object a, Object b) {
		Racional r1 = (Racional) a;
		Racional r2 = (Racional) b;
		int numerador = r1.getNumerador().getValor()*r2.getNumerador().getValor();
		int denominador = r1.getDenominador().getValor()*r2.getDenominador().getValor();
		this.numerador.setValor(numerador);
		this.denominador.setValor(denominador);
		this.simplificar();
		
	}

	@Override
	public void potencia(Object a, int b) {
		Racional racional = (Racional) a;
		this.numerador.setValor((int)Math.pow((double)racional.getNumerador().getValor(), b));
		this.denominador.setValor((int)Math.pow((double)racional.getDenominador().getValor(), b));
		this.simplificar();
	}

	@Override
	public boolean igual(Object otro) {
		Racional racional = (Racional) otro;
		return this.numerador == racional.getNumerador() && this.denominador == racional.getDenominador();
	}

}
