import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/**
		 * Quedan las pruebas comentadas para despues hacer un menú
		 */	
		/*
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
		
		
		int listaPrimos[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
		boolean resultado[] = Operaciones.sonPrimos(listaPrimos);
		for(boolean valor:resultado)
			System.out.println(valor);
		
		Operaciones.bomba(15, 3);
		*/
		Operaciones mochila = new Operaciones();
		int pesos[] = {4,3,6,2,1};
		System.out.println("Antes de la copia: "+mochila.mochila(pesos, 12));
		ArrayList<Integer> solucion = new ArrayList<>(mochila.mochila(pesos, 12));
		System.out.println("Solucion: "+solucion);
		for(int indice: solucion)
			System.out.print(pesos[indice]+"  ");
		
		
		System.out.println();
		for(int i=0; i <20; i++) {
			System.out.println("Mauricio les regala "+i+" pesos: ");
			System.out.println(Operaciones.mauricio(i)+" dias");
		}
			
	}

}
