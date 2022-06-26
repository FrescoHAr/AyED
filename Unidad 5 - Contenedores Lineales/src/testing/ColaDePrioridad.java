package testing;

import contenedores.Lista2DLinkedL;

public class ColaDePrioridad extends Lista2DLinkedL{

	@Override
	public boolean iguales(Object elemento1, Object elemento2) {
		Proceso p1 = (Proceso) elemento1;
		Proceso p2 = (Proceso) elemento2;
		return p1.getPrioridad() == p2.getPrioridad();
	}

	@Override
	public boolean esMenor(Object elemento1, Object elemento2) {
		Proceso p1 = (Proceso) elemento1;
		Proceso p2 = (Proceso) elemento2;
		return p1.getPrioridad() < p2.getPrioridad(); //Prioridad más baja se atiende primero
	}

	@Override
	public boolean esMayor(Object elemento1, Object elemento2) {
		Proceso p1 = (Proceso) elemento1;
		Proceso p2 = (Proceso) elemento2;
		return p1.getPrioridad() > p2.getPrioridad();
	}

	public Proceso devolver() {
		Proceso p =(Proceso) super.devolver(0);
		eliminar(0);
		return p;
	}



}
