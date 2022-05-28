package interfaces;

public interface Operaciones {
	/**
	 * 
	 * @param a
	 * @param b
	 */
	public void sumar(Object a, Object b);
	public void restar(Object a, Object b);
	public void multiplicar(Object a, Object b);
	public void potencia(Object a, int b);
	public boolean igual(Object otro);
}
