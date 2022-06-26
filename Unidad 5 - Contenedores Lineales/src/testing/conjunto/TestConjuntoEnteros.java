package testing.conjunto;

public class TestConjuntoEnteros {

	public static void main(String[] args) {
		ConjuntoEnteros ce = new ConjuntoEnteros();
		
		for(int i=0;i<100;i++) {
			int operacion = (int)(Math.random()*5);
			int num = (int)(Math.random()*20);
			System.out.println("Iteracion= "+(i+1));
			switch(operacion) {
				case 0://meter
					System.out.println("Intento meter "+num);
					ce.meter(num);
					break;
				case 1: //sacar
					System.out.println("Intento sacar "+num);
					ce.sacar(num);
					break;
				case 2: //esta
					System.out.println("Compruebo si "+num+" está en el conjunto");
					System.out.println(ce.esta(num));
					break;
				case 3://Esta vacia
					System.out.println("Verifico si el conjunto esta vacio");
					System.out.println(ce.estaVacia());
					break;
				case 4://lipiar
					System.out.println("Limpio el conjunto");
					ce.limpiar();
					break;
			}
			System.out.println();
			
		}

	}
	

}
