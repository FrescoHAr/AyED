package testing;
import java.util.Scanner;

import contenedores.*;

public class Test2 {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		/*
		Object objAux;
		Scanner sc1, sc2;
		int n, elemento; 
		
		System.out.println("Ingrese cantidad");
		sc1 = new Scanner(System.in);
		n = sc1.nextInt();
		
		if (n > 0) {
			PilaSLinkedList objPila = new PilaSLinkedList();
			
			for (int i=0; i<n; i++) {
				System.out.println("Ingrese elemento");
				sc2 = new Scanner(System.in);
				elemento=sc2.nextInt();
				
				objPila.meter(new Integer(elemento));				
			}
			
			while (!objPila.estaVacia()) {
				objAux = objPila.sacar();
				if (objAux != null){
					System.out.println("Elemento Pila " + objAux.toString());
				}		
			}
			
			objAux=objPila.sacar();
		}

		
		*/
		Object objAux;
		Scanner sc1, sc2;
		int n, elemento; 
		
		System.out.println("Ingrese cantidad");
		sc1 = new Scanner(System.in);
		n = sc1.nextInt();
		sc1.close();
		
		if (n > 0) {
			ColaSLinkedList objCola = new ColaSLinkedList();
			
			for (int i=0; i<n; i++){
				System.out.println("Ingrese elemento");
				sc2 = new Scanner(System.in);
				elemento = sc2.nextInt();
				
				objCola.meter(new Integer(elemento));				
			}
			
			while (!objCola.estaVacia()) {
				objAux = objCola.sacar();
				if (objAux != null){
					System.out.println("Elemento Cola " + objAux.toString());
				}		
			}
			
			objAux = objCola.sacar();
		}
	}		
		
}
