package Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import ar.usa.edu.Unidad1.Entero;

/**
 * 
 * @author Hernán Fresco 
 *
 * https://github.com/frescoh
 */
public class Test {
	
	public static void main(String[] args) {
		Entero numero = new Entero();
		int a= 1580;
		//int b =4;
		
		/*
		System.out.println("Cociente entre "+a+" y "+b+"= "+numero.cociente(a,b)+" resto= "+numero.resto(a, b));

		System.out.println();
		a= 39;
		b =-4;
		System.out.println("Cociente entre "+a+" y "+b+"= "+numero.cociente(a,b)+" resto= "+numero.resto(a, b));
		
		System.out.println();
		a= -39;
		b =4;
		System.out.println("Cociente entre "+a+" y "+b+"= "+numero.cociente(a,b)+" resto= "+numero.resto(a, b));
		
		System.out.println();
		a= -39;
		b =-4;
		System.out.println("Cociente entre "+a+" y "+b+"= "+numero.cociente(a,b)+" resto= "+numero.resto(a, b));
		*/
		
		
		HashMap<Integer,Integer> factores = numero.factorizacion(a);//new HashMap<Integer,Integer>();
		//factores = numero.factorizacion(96);
		ArrayList<Integer> primos = new ArrayList<Integer>(factores.keySet());
		Collections.sort(primos);
		System.out.println(factores);
		System.out.print("Factorizacion de "+a+" : ");
		if(primos.size()!=0) {
			if(factores.get(primos.get(0))!=1)
				System.out.print(primos.get(0)+"^"+factores.get(primos.get(0)));
			else
				System.out.print(primos.get(0));
		}
		for(int i=1;i<primos.size();i++) {
			if(factores.get(primos.get(i))!=1)
				System.out.print(" x "+primos.get(i)+"^"+factores.get(primos.get(i)));
			else
				System.out.print(" x "+primos.get(i));
		}
		numero.criba(1, 100);
		
		System.out.println(numero.cribaLimpia(0, 100));
		System.out.println(numero.menorDivisor(2047));
	}

} 