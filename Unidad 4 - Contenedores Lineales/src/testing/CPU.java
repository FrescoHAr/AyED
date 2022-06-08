package testing;

import contenedores.ColaSLinkedList;

//import contenedores.ColaArr;

public class CPU {
	private ColaSLinkedList cola;
	private int tiempo;
	private int tam;
	
	public CPU(int tam, int tiempo){
		this.cola = new ColaSLinkedList();
		this.tiempo = tiempo;
		this.tam=tam;
	}
	
	//para colaArr
	/*
	public void cargar(){
		while (!this.cola.estaLlena()) {
			this.cola.meter(new Proceso());
		}
	}
	*/
	public void cargar() {
		for(int i=0;i<this.tam;i++)
			this.cola.meter(new Proceso());
	}
	public void atender(){
		int i=0;
		while(!this.cola.estaVacia()){
			System.out.println("Atencion: "+(++i));
			Proceso aux = (Proceso)this.cola.sacar();
			System.out.println(aux);
			aux.incNumAtenciones();
			if (aux.getTiempo() > this.tiempo) {
				aux.setTiempo(aux.getTiempo() - this.tiempo);
				this.cola.meter(aux);
				
			}else{
				System.out.println("ProcesoID: " + aux.getId() + " fue atendido " + aux.getNumDeAtenciones() + " veces");
				System.out.println("tiempo ocioso por este proceso: " + (this.tiempo - aux.getTiempo()));
			}
		}
	}
	

}
