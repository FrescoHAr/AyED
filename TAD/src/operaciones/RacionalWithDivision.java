package operaciones;

import interfaces.OperacionesWithDivision;

public class RacionalWithDivision extends Racional implements OperacionesWithDivision{

	public RacionalWithDivision(Entero numerador, Entero denominador) {
		super(numerador, denominador);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void dividir(Object o) {
		Racional r = (Racional) o;
		this.getNumerador().multiplicar(this.getNumerador(), r.getDenominador());
		this.getDenominador().multiplicar(this.getDenominador(),r.getNumerador());
	}

}
