import java.nio.file.spi.FileSystemProvider;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Operaciones op = new Operaciones();
		
		int a= 13;
		int b= 3;
		
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
		
		System.out.println("s,t entre "+a+" y "+b+"= "+Operaciones.st(a,b));
		
		System.out.println("Factores primos de "+a*b+"= "+Operaciones.factoresPrimos(a*b));
		System.out.println("Factores de "+a*b+"= "+Operaciones.todosLosFactores(a*b));
		int v[]= {5,15,2,18,20,0,13,7};
		System.out.println("Promedio= "+Operaciones.promedio(v));
		
		int matriz[][] = new int[5][3];
		int l =1;
		int suma =0;
		for(int i =0;i<5;i++) {
			for(int j=0;j<3;j++) {
				matriz[i][j]=l;
				suma+=l;
				l++;	
			}
		}
		System.out.println("Suma de los elementos de la matriz mientras se la cargaba= "+suma);
		System.out.println("Suma de los elemtentos de la matriz con el metodo sumaMatriz= "+Operaciones.sumaMatriz(matriz));
	}

}
