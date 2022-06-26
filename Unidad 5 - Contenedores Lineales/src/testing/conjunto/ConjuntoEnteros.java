package testing.conjunto;

public class ConjuntoEnteros extends Conjunto{

	@Override
	public boolean iguales(Object elemento1, Object elemento2) {
		return (int)elemento1 == (int) elemento2;
	}

	@Override
	public boolean esMenor(Object elemento1, Object elemento2) {
		return (int)elemento1 < (int) elemento2;
	}

	@Override
	public boolean esMayor(Object elemento1, Object elemento2) {
		return (int)elemento1 > (int) elemento2;
	}
	
}
