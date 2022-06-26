package testing.FIFA;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import contenedores.Lista2DLinkedL;

public class RankingFIFA extends Lista2DLinkedL{


	@Override
	public boolean iguales(Object elemento1, Object elemento2) {
		Seleccion s1= (Seleccion) elemento1;
		Seleccion s2=(Seleccion) elemento2;
		return s1.getPais().compareTo(s2.getPais())==0;
	}

	/**
	 * El mayor es el que menor puntos tiene, porque la lista esta ordenada de menor a mayor y el mayor debe quedar al final.
	 */
	@Override
	public boolean esMayor(Object elemento1, Object elemento2) {
		Seleccion s1= (Seleccion) elemento1;
		Seleccion s2=(Seleccion) elemento2;
		if(s1.getDifencia()<s2.getDifencia())
			return true;
		else if(s1.getDifencia()==s2.getDifencia()){
			return s1.getPais().compareTo(s2.getPais())>0;
		}
		return false;
	}

	@Override
	public boolean esMenor(Object elemento1, Object elemento2) {
		Seleccion s1= (Seleccion) elemento1;
		Seleccion s2=(Seleccion) elemento2;
		if(s1.getDifencia()>s2.getDifencia())
			return true;
		else if(s1.getDifencia()==s2.getDifencia()){
			return s1.getPais().compareTo(s2.getPais())<0;
		}
		return false;
	}
	
	@Override
	public Seleccion devolver(int pos) {
		return (Seleccion) super.devolver(pos);
	}

	public void cargar(String path) {
		File file = new File(path);
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			while( linea !=null) {
				String atributos[] = linea.toString().split(",");
				this.insertar(new Seleccion(atributos[0],Integer.parseInt(atributos[1]),Integer.parseInt(atributos[2])));// pais, pg, pep
				linea = br.readLine();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
}
