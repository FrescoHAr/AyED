/**
 * 
 * @author frescoh.ar
 * Hernán Fresco
 * http://frescoh.ar
 */
public class ParOrdenado {
	private int a;
	private int b;
	/** Full contructor 
	 * @param a - int 
	 * @param b - int 
	 */
	public ParOrdenado(int a, int b) {
		this.a = a;
		this.b = b;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public int getB() {
		return b;
	}
	public void setB(int b) {
		this.b = b;
	}
	
	@Override
	public String toString() {
		return "ParOrdenado [a=" + a + ", b=" + b + "]";
	}
}
