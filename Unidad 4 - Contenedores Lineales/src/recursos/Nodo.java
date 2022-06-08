package recursos;

public class Nodo {
	private Object nodoinfo;
	private Nodo nextNodo;
	
	public Nodo(Object nodoInfo) {
		this(nodoInfo,null);
	}
	public Nodo(Object nodoInfo,Nodo nextNodo) {
		this.nodoinfo=nodoInfo;
		this.nextNodo=nextNodo;
	}
	public Object getNodoinfo() {
		return nodoinfo;
	}
	public void setNodoinfo(Object nodoinfo) {
		this.nodoinfo = nodoinfo;
	}
	public Nodo getNextNodo() {
		return nextNodo;
	}
	public void setNextNodo(Nodo nextNodo) {
		this.nextNodo = nextNodo;
	}
	
	

}
