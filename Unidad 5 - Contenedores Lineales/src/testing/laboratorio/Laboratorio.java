package testing.laboratorio;

import contenedores.Lista1DLinkedL;

public class Laboratorio extends  Lista1DLinkedL{
	private int capacidad;
	private ColaLab espera;
	private ColaLab atendidos;

	/**
	 * @param capacidad
	 */
	public Laboratorio(int capacidad) {
		this.capacidad = capacidad;
		espera = new ColaLab();
		atendidos = new ColaLab();
	}

	@Override
	public boolean iguales(Object elementoL, Object elemento) {
		return false;
	}

	public void insertar(Object elemento) {
		if(!estaLlena())
			super.insertar(elemento, tamanio());
		else
			System.out.println("Todas las computadoras de la sala estan ocupadas");
	}

	public void desocupar() {
		int i =0;
		while(i<tamanio()) {
			Usuario user= (Usuario) this.devolver(i);
			if(user.getTiempoRestante()==0) {
				eliminar(i);
				atendidos.insertar(user);
				System.out.println("se retira: "+user);
			}

			else
				i++;
		}

	}

	public boolean estaLlena() {
		return tamanio()==capacidad;
	}

	public void restarTiempo() {
		for(int i=0;i<tamanio();i++) {
			Usuario user = (Usuario) this.devolver(i);
			user.restar();
			reemplazar(user, i);
		}
	}

	public void nuevoUser(Usuario user) {
		if(espera.estaVacia() &&!this.estaLlena()) {
			this.insertar(user);
		}else {
			espera.insertar(user);
		}
	}

	public void asignarPC() {
		while(!this.estaLlena()&&!espera.estaVacia()) {
			this.insertar(espera.devolver());
		}
	}

	public void mostrarDia() {
		while(!atendidos.estaVacia())
			System.out.println(atendidos.devolver());
	}
}
