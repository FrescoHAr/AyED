package testing;

import contenedores.Lista2DLinkedL;

public class ListaOrdenadaDeProcesos extends Lista2DLinkedL {

	@Override
	public boolean iguales(Object elemento1, Object elemento2) {
		Proceso p1= (Proceso) elemento1;
		Proceso p2= (Proceso) elemento2;
		return p1.getTiempo()==p2.getTiempo();
	}

	@Override
	public boolean esMenor(Object elemento1, Object elemento2) {
		Proceso p1= (Proceso) elemento1;
		Proceso p2= (Proceso) elemento2;
		return p1.getTiempo()<p2.getTiempo();
	}

	@Override
	public boolean esMayor(Object elemento1, Object elemento2) {
		Proceso p1= (Proceso) elemento1;
		Proceso p2= (Proceso) elemento2;
		return p1.getTiempo()>p2.getTiempo();
	}

}
