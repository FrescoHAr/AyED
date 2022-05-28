package operaciones;

import interfaces.Operaciones;

public class Complejo implements Operaciones {
	private double real;
	private double imaginaria;
	
	public Complejo(double real, double imaginaria) {
		this.real = real;
		this.imaginaria = imaginaria;
	}
	public Complejo(Complejo c) {
		this.setReal(c.getReal());
		this.setImaginaria(c.getImaginaria());
	}
	
	public Complejo(){
		this(0, 0);
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginaria() {
		return imaginaria;
	}

	public void setImaginaria(double imaginaria) {
		this.imaginaria = imaginaria;
	}
	
	public String toString(){
		if(getImaginaria()>=0)
			return getReal() + " + " + getImaginaria() + " i";
		else
			return getReal() + " - " + -getImaginaria() + " i";
	}
	
	public void sumar(Object a, Object b) {
		Complejo aux1 = (Complejo)a;
		Complejo aux2 = (Complejo)b;
		this.real = aux1.getReal() + aux2.getReal();
		this.imaginaria = aux1.getImaginaria() + aux2.getImaginaria();
		
	}

	public void restar(Object a, Object b) {
		Complejo aux1 = (Complejo)a;
		Complejo aux2 = (Complejo)b;
		this.real = aux1.getReal() - aux2.getReal();
		setImaginaria(aux1.getImaginaria() - aux2.getImaginaria());
		
	}
	/**
	 * Multiplica dos complejos. Para ello debemos 
	 */
	public void multiplicar(Object a, Object b) {
		/*
		 * v = (a + b.i)
		 * w = (c + d.i)
		 * v*w = ac + adi + cbi + bdii =  (ac - bd) + (ad + cb)i
		 */
		Complejo aux1 = (Complejo)a;
		Complejo aux2 = (Complejo)b;
		double a1 = aux1.getReal();
		double b1 = aux1.getImaginaria();
		double c = aux2.getReal();
		double d = aux2.getImaginaria();
		this.real = a1*c - b1*d;
		this.imaginaria = a1*d + c*b1;
		
		
	}
	
	
	public Complejo conjugar() {
		Complejo c = new Complejo(this);
		c.setImaginaria(-c.getImaginaria());
		return c;
	}

	public void potencia(Object a, int b) {
		// TODO Auto-generated method stub
		//ver cómo se puede hacer esto con polares.
		Complejo polar = this.aPolar((Complejo)a);
		this.real=(double)Math.round(Math.pow(polar.getReal(), b)*1000)/1000;
		this.imaginaria = polar.getImaginaria()*b;
		

	}
	
	/**
	 * Convierte un numero complejo en su forma polar. 
	 * @param a Complejo (a +bi)
	 * 
	 */
	private Complejo aPolar(Complejo a) {
		
		double r= Math.sqrt(Math.pow(a.getReal(), 2)+Math.pow(a.getImaginaria(), 2));
		r= (double) Math.round(r*1000)/1000;
		double angulo = Math.atan(a.getImaginaria()/a.getReal());
		angulo = Math.toDegrees(angulo);
		if (a.getReal()>0&&a.getImaginaria()<0)
			angulo +=180;
		if (a.getReal()<0&&a.getImaginaria()<0)
			angulo -=180;
		angulo = (double) Math.round(angulo*1000)/1000;
		Complejo salida= new Complejo(r,angulo);
		return salida;
		
	}
	
	public boolean igual(Object otro) {
		// TODO Auto-generated method stub
		Complejo a = (Complejo) otro;
		return this.getReal() == a.getReal() && this.getImaginaria() == a.getImaginaria();
	}

	
	public double modulo() {
		return (double)Math.round(Math.sqrt(Math.pow(real, 2)+Math.pow(imaginaria,2))*100)/100;
	}

}
