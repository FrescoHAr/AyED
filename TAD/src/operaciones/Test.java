package operaciones;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complejo c1 = new Complejo(-4, 5);
		Complejo c2 = new Complejo(8, -2);
		Complejo c3 = new Complejo(3,4);
		System.out.println("Modulo c3= "+c3.modulo());
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

		c3.dividir(c1, c2);
		System.out.println("c1/c2= "+c3);
		
		
		
		Matriz m1 =  new Matriz(2,4);
		Matriz m2= new Matriz(3,3);
		
		double a[][]= {{5,3,-4,-2},{8,-1,0,-3}};
		
		//double b[][] ={{1,4,0},{-5,3,7},{0,-9,5},{5,1,4}};
		
		double b[][] ={{2,1,0},{0,-1,-2},{-1,0,2}};
		for(int i =0;i<2;i++) {
			for(int j=0;j<4;j++) {
				m1.setValor(i, j, a[i][j]);
			}
		}
		for(int i =0;i<3;i++) {
			for(int j=0;j<3;j++) {
				m2.setValor(i, j, b[i][j]);
			}
		}
		System.out.println(m1);
		System.out.println(m2);
		m1.multiplicar(m1, m2);
		System.out.println(m1);
		m1.transponer();
		System.out.println("transpuesta:\n"+m1);
		System.out.println("determinante m2= "+m2.determinante());
		
		
	}

}
