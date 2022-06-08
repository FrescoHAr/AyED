package testing;

import java.util.Scanner;

/**
 * 
 * @author frescoh.ar
 * Hernán Fresco
 * http://frescoh.ar
 */
public class Ej8 {
	/**
	 * Pre condicion: La pila no está vacia
	 * Salida: La pila con los cambios solicitados
	 * Poscondicion: Pila con los valors igual a un valor ingresado cambiados por un segundo argumento
	 */
	public static void main(String args[]) {
		PilaEnteros pila = new PilaEnteros(20);
		pila.generarPila();
		pila.mostrarPila();
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese el valor que desea reemplazar: ");
		int anterior = scanner.nextInt();
		System.out.print("Ingrese el nuevo valor: ");
		int nuevo = scanner.nextInt();
		scanner.close();
		pila.reempleazar(anterior, nuevo);
		pila.mostrarPila();
	}
}
