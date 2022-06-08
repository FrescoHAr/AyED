package recursos;

public interface Contenedor {
	public void meter(Object o);
	public Object sacar();
	public void limpiar();
	public boolean estaVacia();
}
