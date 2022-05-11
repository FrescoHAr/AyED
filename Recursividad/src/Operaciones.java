import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author frescoh.ar
 * Hernán Fresco
 * https://frescoh.ar
 */
public class Operaciones {
	
	/**
	 * Atributos usados en el metodo mochila
	 */
	private int cargaMaxima;
	private ArrayList<Integer> mochilaMaxima;
	
	public Operaciones() {
		this.cargaMaxima=0;
		this.mochilaMaxima = new ArrayList<Integer>();
		
	}
	
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
	
	/**Calcula el cociente de la division entera entre dos numeros
	 * 
	 * @param dividendo - int 
	 * @param divisor   - int  
	 * @return cociente
	 */
	public static int cociente(int dividendo, int divisor) {
		if(dividendo<divisor)
			return 0;
		else
			return cocienteR(dividendo-divisor, divisor,1);
	}
	
	/** Calcula el cociente de la division entera de forma recursiva
	 * 
	 * @param dividendo - int 
	 * @param divisor	- int
	 * @param coc		- int
	 * @return coc -> int 
	 */
	private static int cocienteR(int dividendo,int divisor,int coc) {
		if(dividendo<divisor)
			return coc;
		else
			return cocienteR(dividendo-divisor, divisor,coc+1);
	}
	
	/**Devuelve el cociente y resto de la division entre dos numeros en un solor return mediante un parordenado
	 * 
	 * @param dividendo - int 
	 * @param divisor	- int
	 * @return			- ParOrdenado (cociente, resto)
	 */
	public static ParOrdenado cr(int dividendo, int divisor) {
		return new ParOrdenado(cociente(dividendo, divisor),resto(dividendo, divisor));
	}
	
	/**Calcula st entre dos numeros numeroA y numeroB
	 * 
	 * @param numeroA - int
	 * @param numeroB - int 
	 * @return - ParOrdenado (s,t)
	 */
	public static ParOrdenado st(int numeroA, int numeroB) {
		/**
		 * Si b=0 => mcd(a,b)= |a| => s= |a|/a  y t = 0
		 */
		if(numeroB==0)
			return new ParOrdenado(Math.abs(numeroA)/numeroA,0); 
		else {
			/**
			 * 
			 */
			ParOrdenado coRe = cr(numeroA,numeroB);
			ParOrdenado stSalida = st(numeroB,coRe.getB());
			return new ParOrdenado(stSalida.getB(),stSalida.getA()-stSalida.getB()*coRe.getA());
		}		
	}
	
	/**Calcula los factores primos de un numero y las veces que aparece cada uno en la descomposicion en factores primos de dicho numero
	 * 
	 * @param numero - int
	 * @return - hashMap: Diccionario en el que las keys correponden a los factores y los valores a los exponentes de cada factor
	 */
	public static HashMap<Integer,Integer> factoresPrimos(int numero){
		HashMap<Integer,Integer> factores = new HashMap<>(); 
		return factoresPrimosR(numero,factores);
	}
	
	/** Funcion recursiva en apoyo a this.factoresPrimos(int numero)
	 * 
	 * @param numero 	- int 
	 * @param factores 	- HashMap
	 * @return HashMap de todos los factores con sus correspondientes exponentes
	 */
	private static HashMap<Integer,Integer> factoresPrimosR(int numero, HashMap<Integer,Integer> factores){
		if(numero==1)
			return factores;
		else {
			int div = menorDivisor(numero);
			if(factores.containsKey(div))
				factores.put(div, factores.get(div)+1);
			else
				factores.put(div,1);
			return factoresPrimosR(numero/div, factores);
		}
	}
	
	/**
	 * Calcula el menor divisor de un numero
	 * @param numero 	- int 
	 * @return			- int menor divisor
	 */
	public static int menorDivisor(int numero) {
		if(resto(numero,2)==0)
			return 2;
		else
			return menorDivisorR(numero,3);
	}
	
	/** Metodo recursivo en apoyo a menorDivisor(int)
	 * 
	 * @param numero 	- int 
	 * @param divisor	- int 
	 * @return			- int Menor divisor del numero
	 */
	private static int menorDivisorR(int numero, int divisor) {
		if(resto(numero,divisor)==0)
			return divisor;
		else
			return menorDivisorR(numero, divisor+2);
	}
	
	/**Calcula todos los factores de un numero ingresado por parametro
	 * 
	 * @param numero	- int 
	 * @return			- ArrayList de Integer con los factores del numero 
	 */
	public static ArrayList<Integer> todosLosFactores(int numero){
		numero = Math.abs(numero);
		ArrayList<Integer> factores = new ArrayList<>();
		if(numero==0)
			return factores;
		else
			factores.add(1);
			return todosLosFactoresR(numero,factores,2);
	}
	
	/**
	 * 
	 * @param numero	-	int 
	 * @param factores	- 	ArrayList con los factores del numero
	 * @param divisor	-	Divisor que se avaluara para incluirlo en el ArrayList factores en caso de ser un factor de numero
	 * @return			- 	ArrayList con todos los factores del numero desde 1 hasta el mismo numero
	 */
	private  static ArrayList<Integer> todosLosFactoresR(int numero, ArrayList<Integer> factores, int divisor){
		if(divisor*2>numero) {
			factores.add(numero);
			return factores;
		}
			
		else {
			if(resto(numero,divisor)==0)
				factores.add(divisor);
			return todosLosFactoresR(numero, factores, divisor+1);
		}
	}
	
	/**Calcula el promedio de una lista de numeros enteros
	 * 
	 * @param vector	- int[] 	Array de enteros
	 * @return			- double = sum(vector)/length(vector)
	 */
	public static double promedio(int vector[]) {
		int suma = 0;
		return sumaR(vector,0,suma)/vector.length;
	}
	
	/**Metodo recursivo en apoyo a promedio(int[])
	 * 
	 * @param vector 	- int[]
	 * @param indice	- int 	Posicion del vector sobre la que se está trabajando
	 * @param suma		- int 	Suma de los enteros contenidos en vector
	 * @return			- int 	suma de los enteros contenidos en vector
	 */
	private static double sumaR(int vector[], int indice, int suma) {
		if(indice==vector.length)
			return suma;
		else {
			suma +=vector[indice];
			return sumaR(vector, indice+1, suma);
		}
	}
	
	public static int sumaMatriz(int matriz[][]) {
		int suma =0;
		int fila =0;
		return sumaMatrizR(matriz,fila,suma);
	}
	
	private static int sumaMatrizR(int matriz[][], int fila, int suma) {
		if(fila==matriz.length)
			return suma;
		else {
			suma+=sumaR(matriz[fila],0,0);
			return sumaMatrizR(matriz, fila+1, suma);
		}
	}
	
	/**
	 * Devuelve una lista del mismo tamaño que la que se recibe por parametro, pero con valores booleanos
	 * @param lista - int numeros[]
	 * @return		- boolean salida[] donde salida[i] = <br>true: si numeros[i] es primo<br>false: si numeros[i] no es primo 
	 */
	public static boolean[] sonPrimos(int lista[]) {
		boolean evaluados[] = new boolean[lista.length];
		return sonPrimosR(lista, evaluados,0);
		
	}
	
	/**Metodo recursivo
	 * Devuelve una lista del mismo tamaño que la que se recibe por parametro, pero con valores booleanos
	 * @param lista - int numeros[]
	 * @return		- boolean salida[] donde salida[i] = <br>true: si numeros[i] es primo<br>false: si numeros[i] no es primo 
	 */
	private static boolean[] sonPrimosR(int lista[], boolean evaluados[], int indice) {
		if(indice== lista.length)
			return evaluados;
		else {
			evaluados[indice] = esPrimo(lista[indice]);
			return sonPrimosR(lista,evaluados,indice+1);
		}
	}
	
	/**dados dos numeros N y B, tales que B<N, podemos hacer que N explote usando a B como bomba. 
	 * cuando N explota se parte en dos numeros N1 = N/B y n2 = N - N/B produciendo una reaccion en cadena  hasta que los fragmentos de N sean menores o iguales a B
	 * 
	 * @param nExplota
	 * @param bomba
	 */
	public static void bomba(int nExplota, int bomba) {
		if(nExplota>bomba) {
			bomba(nExplota/bomba,bomba);
			bomba(nExplota-nExplota/bomba,bomba);
		}
		else
			System.out.print(nExplota+", ");
		
	}
	
	/**
	 * metodo que se encarga de que cada vez que se llame al moto mochila, los atributos globales que se usaran esten inicializdos de manera correcta.
	 */
	private  void limpiarMochila() {
		this.cargaMaxima=0;
		this.mochilaMaxima = new ArrayList<>();
	}
	
	
	/**
	 * Resuelve el problema de la mochila, intentando ocupar la capacidad total de la misma o, en caso de no poder, reducir el espacio sin usar al minimo 
	 * @param pesos 		- int[] Array con los pesos de los elementos que se cargaran en la mochila
	 * @param capacidad		- int 	Capacidad maxima de la mochila
	 * @return				- ArrayList<Integer> que contiene los indices de pesos[] que optimizan la carga de la mochila
	 */
	public  ArrayList<Integer> mochila(int pesos[], int capacidad) {
		this.limpiarMochila();
		ArrayList<Integer> temp= new ArrayList<>();
		mochilaR(pesos, capacidad,0,0,temp);
		return this.mochilaMaxima;
	}
	
	private  void mochilaR(int pesosDeLibros[],int capacidad,int indice, int cargaActual, ArrayList<Integer> mochilaActual) {
		/**
		 * Este metodo usa dos atributos que se declaran en las primeras lineas de la clase
		 * int cargaMaxima y ArrayList<Integer> mochilaMaxima 
		 */
		if(cargaActual==capacidad) {
			this.mochilaMaxima = mochilaActual;
			this.cargaMaxima = cargaActual;
		}
		else {
			if(indice == pesosDeLibros.length) {
				if(cargaActual>this.cargaMaxima) {
					this.mochilaMaxima=mochilaActual;
					this.cargaMaxima = cargaActual;
				}
			}else {
				ArrayList<Integer> toma = new ArrayList<>(mochilaActual);
				ArrayList<Integer> noToma = new ArrayList<>(mochilaActual);
				int cargaToma = cargaActual;
				if(cargaActual+pesosDeLibros[indice]<=capacidad){
					toma.add(indice);
					cargaToma += pesosDeLibros[indice];
				}
				mochilaR(pesosDeLibros, capacidad, indice+1, cargaToma, toma);
				mochilaR(pesosDeLibros, capacidad, indice+1, cargaActual, noToma);
			}
		}		
	}
	
	/**
	 * Atributo usado exclusivamente por el meotodo mochila
	 * @return int - El peso que tiene la mochila despues de cargarla de manera optima. <br>0 por defecto
	 */
	public int getCargaMaxima() {
		return cargaMaxima;
	}
	
	/**
	 * Atributo usado exclusivamente por el metodo mochila
	 * @return - ArrayList< Integer> que contiene los indices correspondiente a los pesos dentro del array que se envia por parametro a this.mochila,
	 *  que hacen que la carga de la mochila sea optima. <br>Vacio por defecto.
	 */
	public ArrayList<Integer> getMochilaMaxima() {
		return mochilaMaxima;
	}
	
	
	/**
	 * Metodos para resolver el ejercicio 13 del practico de recursividad:
	 * mauricio
	 * daniel
	 * claudio
	 */
	
	public static int mauricio(double  pesos) {
		int diasDaniel =daniel(pesos,0);
		int diasClaudio = claudio(pesos,0);
		if(diasDaniel >diasClaudio)
			return diasDaniel;
		else
			return diasClaudio;
		
	}
	private static int daniel(double pesos,int dias) {
		if(pesos<=1)
			return dias;
		return claudio(pesos*0.5,dias+1);
		
	}
	
	private static int claudio(double pesos, int dias) {
		if(pesos<=1)
			return dias;
		return daniel(pesos*2/3,dias+1);
	}
}
