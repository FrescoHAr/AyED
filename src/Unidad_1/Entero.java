package Unidad_1;

public class Entero {
	private int valor;
	
	/** Full constructor Entero
	 * @param a - int 
	 * @param b - int
	 */
	public Entero(int valor) {
		this.valor = valor;
	}

	public Entero() {
		setValor(0);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int cociente(int dividendo, int divisor) {
		int a = dividendo;
		int b= divisor;
		dividendo = Math.abs(dividendo);
		divisor  = Math.abs(divisor);
		int iteraciones =0;
		while(dividendo>=divisor) {
			dividendo-=divisor;
			iteraciones++;
		}
		if(a*b<0) {
			if(a<0)
				return -iteraciones-1;
			else
				return -iteraciones;
		}
		else
			return iteraciones;
		
	}
	
	public int cociente(int divisor) {
		return cociente(getValor(),divisor);
	}
	
	public int cociente(Entero e) {
		return cociente(getValor(),e.getValor());
	}
	
	
	public int resto(int dividendo, int divisor) {
		int a= Math.abs(dividendo);
		int b= Math.abs(divisor);
		while(a>=b)
			a-=b;
		if(dividendo<0&&divisor>0)
			return divisor-a;
		else 
			return a;
		
	}
	
	public int resto(int divisor) {
		return resto(getValor(),divisor);
	}
	
	public int resto(Entero e) {
		return resto(getValor(),e.getValor());
	}
	
	
	public boolean esPrimo(int valor) {
		if(valor<2) 
			return false;
		if(resto(valor,2)==0) {
			if(valor==2)
				return true;
			else
				return false;
		}
		else {
			int divisor=3;
			while(divisor*divisor<valor && resto(valor,divisor)!=0) {
				divisor+=2;
			}
			if(resto(valor,divisor)==0&&valor!=3)
				return false;
			else
				return true;
		}
	}
	
	public boolean esPrimo() {
		return this.esPrimo(this.getValor());
	}
	
	public ParOrdenado  cr(int dividendo, int divisor) {
		ParOrdenado salida = new ParOrdenado(cociente(dividendo,divisor), resto(dividendo,divisor));
		return salida;
		
	}
	
	
	/**int mcd(a,b) -> int
	 * @param a - int  @param b - int
	 * Devuelve el maximo comun divisor entre a y b
	 */
	public int mcd(int a, int b) {
		a= Math.abs(a);
		b= Math.abs(b);
		while(resto(a,b)!=0) {
			int c =a;
			a=b;
			b= resto(c,b);
		}
		return b;
	}
	
	/**int mcd(a) -> int
	 * @param a - int
	 * Devuelve el maximo comun divisor entre a y el valor almacenado en esta clase
	 */
	public int mcd(int a) {
		return this.mcd(this.getValor(), a);
	}
	
	/**int mcd(e) -> int
	 * @param a - Entero
	 * Devuelve el maximo comun divisor entre e.getValor() y this.getValor()
	 */
	public int mcd(Entero e) {
		return this.mcd(this.getValor(), e.getValor());
	}
	
	
	/**int mcm(a,b) -> int
	 * @param a - int  @param b - int
	 * Devuelve el minimo comun multiplo entre a y b
	 */
	public int mcm(int a,int b) {
		return a*b/this.mcd(a,b);
	}
	
	/**int mcd(a) -> int
	 * @param a - int
	 * Devuelve el minimo común multiplo entre a y el valor almacenado en esta clase
	 */
	public int mcm(int a) {
		return this.mcm(this.getValor(), a);
	}

	/**int mcd(e) -> int
	 * @param a - Entero
	 * Devuelve el Minimo común multiplo  entre e.getValor() y this.getValor()
	 */
	public int mcm(Entero e) {
		return this.mcm(this.getValor(), e.getValor());
	}
}
