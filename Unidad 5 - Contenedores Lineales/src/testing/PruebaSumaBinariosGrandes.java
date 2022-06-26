package testing;

import java.util.Scanner;

public class PruebaSumaBinariosGrandes {

	public static void main(String[] args) {
		SumaBinarioGrande sb = new SumaBinarioGrande();
		System.out.print("Ingrese el nombre del archivo (en recursos) que contiene los números para operar: ");
		Scanner scanner = new Scanner(System.in);
		String archivo = scanner.nextLine();
		scanner.close();
		sb.cargar("./src/recursos/"+archivo);
	}

}
