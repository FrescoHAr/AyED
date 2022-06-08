package testing;
import java.util.Random;
public class Proceso {
	private static int nextID = 1; //Atributo de la clase y no de la instancia.
	private int id;
	private int tiempo;
	private int numDeAtenciones;
	
	public Proceso(){
		this.id = nextID++;
		this.tiempo = (new Random().nextInt(10)) + 1;
		this.numDeAtenciones = 0;
		System.out.println("Proceso ID: " + this.id + " tiempo: " + this.tiempo);
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
	
	
}
