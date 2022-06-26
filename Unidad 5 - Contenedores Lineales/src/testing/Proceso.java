package testing;
import java.util.Random;
public class Proceso {
	private static int nextID = 1; //Atributo de la clase y no de la instancia.
	private int id;
	private int tiempo;
	private int numDeAtenciones;
	private int prioridad;

	public Proceso(){
		this.id = nextID++;
		this.tiempo = (new Random().nextInt(10)) + 1;
		this.numDeAtenciones = 0;
		this.prioridad = (new Random().nextInt(10)) + 1;
		System.out.println("Proceso ID: " + this.id + " tiempo: " + this.tiempo+" prioridad:"+this.prioridad);
	}

	public int getId(){
		return this.id;
	}

	public int getTiempo(){
		return this.tiempo;
	}

	public void setTiempo(int tiempo){
		this.tiempo = tiempo;
	}

	public void incNumAtenciones(){
		this.numDeAtenciones++;
	}

	public int getNumDeAtenciones(){
		return this.numDeAtenciones;
	}



	public int getPrioridad() {
		return prioridad;
	}

	public void setPrioridad(int prioridad) {
		this.prioridad = prioridad;
	}

	@Override
	public String toString() {
		return "Proceso [id=" + id + ", tiempo=" + tiempo + ", numDeAtenciones=" + numDeAtenciones + ", prioridad="
				+ prioridad + "]";
	}




}
