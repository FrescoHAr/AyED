package testing;

import java.util.Scanner;

public class Ej9 {

	public static void main(String[] args) {
		PilaParentesis pila = new PilaParentesis();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese la cadena que desea comprobar: ");
		String cadena  = scanner.next();
		scanner.close();
		if(pila.verificarCadena(cadena))
			System.out.println("Cadena balanceada");
		else
			System.out.println("No está balanceda");
	}

}
