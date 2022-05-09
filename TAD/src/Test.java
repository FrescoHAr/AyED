
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complejo c1 = new Complejo(3, 7);
		Complejo c2 = new Complejo(10, 33);
		Complejo c3 = new Complejo();
		c3.sumar(c1, c2);
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		c3.restar(c1, c2);
		System.out.println(c3);
		
		c3.setReal(2.598);
		c3.setImaginaria(1.5);
		c3.potencia(c3, 4);
		System.out.println(c3);

	}

}
