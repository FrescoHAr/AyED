package testing;
import java.util.Scanner;

import contenedores.*;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		Object objAux;
		Scanner sc1, sc2;
		int n, elemento; 
		/*	
		System.out.println("Ingrese cantidad");
		sc1 = new Scanner(System.in);
		n = sc1.nextInt();
		
		if (n > 0) {
			PilaArr objPila = new PilaArr(n);
			
			for (int i=0; i<n; i++) {
				System.out.println("Ingrese elemento");
				sc2 = new Scanner(System.in);
				elemento = sc2.nextInt();
				
				objPila.meter(new Integer(elemento));				
			}
			
			while (!objPila.estaVacia()) {
				objAux = objPila.sacar();
				if (objAux!=null){
					System.out.println("Elemento Pila " + objAux.toString());
				}		
			}
			
			objAux = objPila.sacar();
		}
		*/
		
		
		
		
		ColaArr objCola = new ColaArr(5);
		
		Integer objInt1, objInt2, objInt3, objInt4, objInt5;
		
		objInt1 = new Integer(10);
		objInt2 = new Integer(20);
		objInt3 = new Integer(30);
		objInt4 = new Integer(40);
		objInt5 = new Integer(50);
						
		objCola.meter(objInt1);
		objCola.meter(objInt2);
		objCola.meter(objInt3);
		objCola.meter(objInt4);
		objCola.meter(objInt5);
		objCola.meter(objInt1);

		
		while (!objCola.estaVacia()) {
			objAux = objCola.sacar();		
			if (objAux != null) {
				System.out.println("Elemento Cola " + objAux.toString());
			}	
		}		

	}

}
