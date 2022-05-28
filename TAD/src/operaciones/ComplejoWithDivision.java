package operaciones;

import interfaces.OperacionesWithDivision;

public class ComplejoWithDivision extends Complejo implements OperacionesWithDivision{

	
	
	/**
	 * 
	 */
	public ComplejoWithDivision() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param c
	 */
	public ComplejoWithDivision(Complejo c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param real
	 * @param imaginaria
	 */
	public ComplejoWithDivision(double real, double imaginaria) {
		super(real, imaginaria);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Division entre complejos
	 * @param c1 - Complejo
	 * @param c2 - Complejo != (0+0i)
	 */
	public void dividir(Object o) {
		Complejo c = (Complejo)o;
		Complejo resultado = new Complejo(0,0);
		if(c!=resultado) {
			resultado.multiplicar(this, c.conjugar());
			double divisor = Math.pow(c.getReal(), 2) +Math.pow(c.getImaginaria(), 2);
			resultado.setImaginaria((double)Math.round(resultado.getImaginaria()/divisor*100)/100);
			resultado.setReal((double)Math.round(resultado.getReal()/divisor*100)/100);
		}
		this.setReal(resultado.getReal());
		this.setImaginaria(resultado.getImaginaria());
	}

}
