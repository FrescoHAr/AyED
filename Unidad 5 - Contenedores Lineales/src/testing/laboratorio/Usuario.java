package testing.laboratorio;

import java.time.LocalTime;

public class Usuario {
	private String nombre;
	private LocalTime horaLlega;
	private int tiempoConexion; //minutos
	private int tiempoRestante;

	/**
	 * @param nombre 			- Nombre del usuario
	 * @param horaLlega			- Hora de llegada
	 * @param tiempoConexion	- Tiempo de conexion en minutos
	 */
	public Usuario(String nombre, LocalTime horaLlega, int tiempoConexion) {
		this.nombre = nombre;
		this.horaLlega = horaLlega;
		this.tiempoConexion = tiempoConexion;
		this.tiempoRestante=this.tiempoConexion;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalTime getHoraLlega() {
		return horaLlega;
	}

	public int getTiempoConexion() {
		return tiempoConexion;
	}

	public int getTiempoRestante() {
		return this.tiempoRestante;
	}

	public void restar() {
		this.tiempoRestante--;
	}

	@Override
	public String toString() {
		return "Usuario [nombre= " + nombre + "\tHora de llegada= " + horaLlega + "\tTiempo de conexion= " + tiempoConexion +" minutos ]";	}


}
