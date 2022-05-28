package operaciones;

import interfaces.Operaciones;
import interfaces.OperacionesEntero;

public class Entero implements Operaciones, OperacionesEntero{
	private int valor;
	
	/**
	 * @param valor
	 */
	public Entero(int valor) {
		this.valor = valor;
	}
	
	public Entero() {
		this.valor = 0;
	}
	public Entero(Entero e) {
		this.setValor(e.getValor());
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	@Override
	public void sumar(Object a, Object b) {
		Entero x = (Entero) a;
		Entero y= (Entero) b;
		this.valor = x.getValor()+y.getValor();
	}

	@Override
	public void restar(Object a, Object b) {
		Entero x = (Entero) a;
		Entero y= (Entero) b;
		this.valor = x.getValor()-y.getValor();		
	}

	@Override
	public void multiplicar(Object a, Object b) {
		Entero x = (Entero) a;
		Entero y= (Entero) b;
		this.valor = x.getValor()*y.getValor();
		
	}

	@Override
	public void potencia(Object a, int b) {
		Entero x = (Entero) a;
		this.valor =  (int) Math.pow(x.getValor(),b);	
	}

	@Override
	public boolean igual(Object otro) {
		Entero e = (Entero) otro;
		return e.getValor()== this.valor;
	}

	@Override
	public int resto(Object o1) {
		Entero divisor=(Entero) o1;
		return resto(this.getValor(),divisor.getValor());
		
	}
	
	public static  int resto(int dividendo, int divisor) {
		int a= Math.abs(dividendo);
		int b= Math.abs(divisor);
		while(a>=b)
			a-=b;
		if(dividendo<0&&divisor>0)
			return divisor-a; // resto por ecceso ya que en negativos d = d+1 para que se pueda complir qxd <= D< (q+1)xd
		else
			return a;
	}

	@Override
	public int mcd(Object o1) {
		int b= ((Entero) o1).getValor();
		return resto(this.getValor(),b);
	}
	
	public static int mcd(int e1, int e2) {
		int a = Math.abs(e1);
		int b = Math.abs(e2);
		while(resto(a,b)!=0) {
			int c =a;
			a=b;
			b= resto(c,b);
		}
		return b;
	}
	

}
