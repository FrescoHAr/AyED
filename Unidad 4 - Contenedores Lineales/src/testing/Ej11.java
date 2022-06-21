 package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import contenedores.PilaSLinkedList;

public class Ej11 {
	public static void main(String args[]) {
		PilaSLinkedList pila;
		Capicua capicua;
		System.out.print("Ingrese el nombre del archivo: ");
		Scanner scanner = new Scanner(System.in);
		String nombreArchivo = scanner.nextLine();
		scanner.close();
		pila= leerArchivo(nombreArchivo);
		capicua = new Capicua(pila);
		System.out.println("Capicuas");
		capicua.mostrarCola();
		System.out.println("\n\nNo capicuas");
		capicua.mostrarPila();
		
		
	}
	public static PilaSLinkedList leerArchivo(String nombre) {
		PilaSLinkedList numeros= new PilaSLinkedList();
		File file = new File("./src/txt", nombre);
		FileReader fr= null;
		BufferedReader br = null;
		try {
			if(file.exists()) {
				fr = new FileReader(file);
				br = new BufferedReader(fr);
				String linea = br.readLine();
				while(linea!=null) {
					int[] n= Arrays.stream(linea.toString().substring(0,linea.length()).split(",")).map(String::trim).mapToInt(Integer::parseInt).toArray();
					for(int num:n)
						numeros.meter(num);
					linea=br.readLine();
				}				
			}
			
		} catch (IOException e) {
			System.out.println("No se pudo leer el archivo. "+e.getLocalizedMessage());
		}finally {
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return numeros;
	}
}
