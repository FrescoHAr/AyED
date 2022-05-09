package MetodosRecursivos;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Operaciones op = new Operaciones();
		
		int a= 9;
		int b= 15;
		
		for(int i=0;i<10;i++) {
			System.out.println("2^"+i+"= "+Operaciones.potencia(2, i));
		}
		
		System.out.println(Operaciones.resto(11, 2));
		
		for(int i=0;i<100;i++) {
			if(Operaciones.esPrimo(i))
				System.out.println(i+" es primo");
		}
		
		System.out.println(Operaciones.getCantidadDigitos(123456789));
		
		System.out.println("mcd("+a+","+b+")= "+Operaciones.mcd(a,b));
	}

}
