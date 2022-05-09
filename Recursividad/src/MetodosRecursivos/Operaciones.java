package MetodosRecursivos;

/**
 * 
 * @author frescoh.ar
 * Hernán Fresco
 * https://frescoh.ar
 */
public class Operaciones {
	
	/**Calcula la potencia de una base elevado a un exponente. Datos pasados por parametro
	 * 
	 * @param base - int base
	 * @param exponente - int exponente
	 * @return int - Rsultado de elevar base al exponente 
	 */
	public static int potencia(int base, int exponente) {
		if(exponente<1)
			return 1;
		if(exponente==1)
			return base;
		else
			return base * potencia(base,exponente-1);
		
	}
	
	/**evalua la primalidad de un número
	 * 
	 * @param a - int Número que se evalúa
	 * @return boolean - true si número es primo, false si no lo es.
	 */
	public static boolean esPrimo(int a) {
		if(Math.abs(a)==1)
			return false;
		if(resto(a,2)==0)
			if(a==2)
				return true;
			else
				return false;
		else 
			return primoR(Math.abs(a),3);
	}
	
	
	/**
	 * Calcula el resto de la division entera entre un dividendo y un divisor
	 * @param dividendo - int
	 * @param divisor 	- int
	 * @return - int.
	 */ 
	public static int resto(int dividendo , int divisor) {
		if(dividendo<divisor)
			return dividendo;
		else
			return resto(dividendo-divisor,divisor);
	}
	
	/**
	 * Metodo privado recursivo para evaluar la primalidad de un numero mediante la busqueda de divisores impares mayores o iguales a 3
	 * @param num
	 * @param divisor
	 * @return
	 */
	private static boolean primoR(int num, int divisor) {
		if(divisor*divisor>num)
			return true;
		else {
			if(resto(num,divisor)==0)
				return false;
			else 
				return primoR(num,divisor+2);
		}
	}
	
	public static int getCantidadDigitos(int numero) {
		if(numero ==0)
			return 0;
		else
			return 1+getCantidadDigitos(numero/10);
	}
	
	/**
	 * Calcula el mcd entre dos numeros
	 * @param numeroA - int
	 * @param numeroB - int 
	 * @return int
	 * -1 error
	 */
	public static int mcd(int numeroA, int numeroB) {
		numeroA = Math.abs(numeroA);
		numeroB = Math.abs(numeroB);
		if(numeroA == 0 && numeroB==0)
			return -1;
		else 
			return mcdR(numeroA,numeroB);
	}
	
	/**
	 * Caclula el mcd entre dos numeros usando el algoritmod e Euclides
	 * @param a - int 
	 * @param b	- int 
	 * @return - int 
	 */
	private static int mcdR(int a, int b) {
		if(b==0)
			return a;
		else
			return mcdR(b,resto(a,b));
	}

}
