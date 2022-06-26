package testing.FIFA;

import java.util.Scanner;

public class TestRankingFIFA {

	public static void main(String[] args) {
		RankingFIFA ranking = new RankingFIFA();
		System.out.print("Ingrese el nombre del archivo donde estan los datos de las selecciones: "); // en recursos
		Scanner scanner = new Scanner(System.in);
		String path = scanner.nextLine(); // selecciones.txt
		scanner.close();
		ranking.cargar("./src/recursos/"+path);
		for(int i=0;i<ranking.tamanio();i++) {
			System.out.println("Puesto "+(i+1)+" "+ranking.devolver(i));
		}

	}

}
