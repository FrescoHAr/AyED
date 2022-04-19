package Unidad_1;

public class Entero {
	private int valor;

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
	
	
	
}
