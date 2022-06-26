package testing.laboratorio;

import java.time.LocalTime;

public class TestLaboratorio {

	public static void main(String[] args) {

		Laboratorio lab1 = new Laboratorio(15);
		System.out.println("tamaño inicial: "+lab1.tamanio());
		int minuto =0;
		double porcentaje;
		while(minuto<=600|| minuto>600&&!lab1.estaVacia()) {//600 minutos entre las 10:00 y las 20:00 hs
			LocalTime ltm = LocalTime.of(10+(minuto/60), minuto%60);
			System.out.println(ltm);
			lab1.restarTiempo();
			lab1.desocupar();
			lab1.asignarPC();
			if(minuto<600) {
				porcentaje = Math.random();
				if(porcentaje<0.015) {
					int tiempoDeUso = 30+ (int)(Math.random()*31);
					Usuario u = new Usuario("Usuario "+minuto, ltm, tiempoDeUso);
					lab1.insertar(u);
					System.out.println("\nLlega "+u);
				}
			}
			minuto++;
		}

		LocalTime ltm = LocalTime.of(10+(minuto/60), minuto%60);
		System.out.println(ltm+" Fin del dia");
		System.out.println("resumen");
		lab1.mostrarDia();
	}

}
