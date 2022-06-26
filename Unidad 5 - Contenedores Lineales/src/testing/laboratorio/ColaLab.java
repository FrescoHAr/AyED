package testing.laboratorio;

import contenedores.Lista1DLinkedL;

public class ColaLab extends Lista1DLinkedL{

	@Override
	public boolean iguales(Object elementoL, Object elemento) {
		Usuario u1 = (Usuario) elementoL;
		Usuario u2 = (Usuario)elemento;
		return u1.getNombre().compareTo(u2.getNombre())==0;
	}

	public void insertar(Object elemento) {
		super.insertar(elemento, tamanio());
	}


	public Usuario devolver() {
		Usuario u = null;
		if(!estaVacia()) {
			u = (Usuario) devolver(0);
			eliminar(0);
		}
		return u;
	}


}
