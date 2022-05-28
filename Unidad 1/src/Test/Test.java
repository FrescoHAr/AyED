package src.Test;
import java.util.Scanner;

import src.ar.edu.unsa.Unidad1.Entero;


/**
 *
 * @author Hernán Fresco
 *
 * https://github.com/frescoh
 */
public class Test {

	public static void main(String[] args) {
		Entero entero = new Entero(5);
		System.out.println(entero.cociente(2));
		
		String s = "123.5";
		float f = 0.5f;
		System.out.println(Float.parseFloat(s)+f);
		Scanner scanner = new Scanner(System.in);
		System.out.print("float: ");
		f= scanner.nextFloat();
		System.out.println(Float.parseFloat(s)+f);
	
	}

}