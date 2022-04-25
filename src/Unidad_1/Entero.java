package Unidad_1;
import java.util.ArrayList;
import java.util.HashMap;

public class Entero {
	private int valor;
	
	/** Full constructor Entero
	 * @param a - int 
	 * @param b - int
	 */
	public Entero(int valor) {
		this.valor = valor;
	}

	public Entero() {
		setValor(0);
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	public int cociente(int dividendo, int divisor) {
		int a = dividendo;
		int b= divisor;
		dividendo = Math.abs(dividendo);
		divisor  = Math.abs(divisor);
		int cociente =0;
		while(dividendo>=divisor) {
			dividendo-=divisor;
			cociente++;
		}
		if(a*b<0) {
			if(-(cociente+1)*b<a)
				return -(cociente+1);
			else
				return-cociente;
		}
		else
			if((cociente+1)*b<a)
				return cociente+1;
			else 
				return cociente;
		
	}
	
	public int cociente(int divisor) {
		return cociente(getValor(),divisor);
	}
	
	public int cociente(Entero e) {
		return cociente(getValor(),e.getValor());
	}
	
	
	public int resto(int dividendo, int divisor) {
		return dividendo -divisor*cociente(dividendo,divisor); //Por propiedades de la division entera
		
		// Tambien se podria haber calculado de manera independiente 
		/*int a= Math.abs(dividendo);
		int b= Math.abs(divisor);
		while(a>=b)
			a-=b;
		if(dividendo<0&&divisor>0)
			return divisor-a; // resto por ecceso ya que en negativos d = d+1 para que se pueda complir qxd <= D< (q+1)xd
		else 
			return a;
		*/
		
	}
	
	public int resto(int divisor) {
		return resto(getValor(),divisor);
	}
	
	public int resto(Entero e) {
		return resto(getValor(),e.getValor());
	}
	
	
	public boolean esPrimo(int valor) {
		if(valor<2) 
			return false;
		if(resto(valor,2)==0) {
			if(valor==2)
				return true;
			else
				return false;
		}
		else {
			int divisor=3;
			while(divisor*divisor<valor && resto(valor,divisor)!=0) {
				divisor+=2;
			}
			if(resto(valor,divisor)==0&&valor!=3)
				return false;
			else
				return true;
		}
	}
	
	public boolean esPrimo() {
		return this.esPrimo(this.getValor());
	}
	
	public ParOrdenado  cr(int dividendo, int divisor) {
		ParOrdenado salida = new ParOrdenado(cociente(dividendo,divisor), resto(dividendo,divisor));
		return salida;
		
	}
	
	
	/**int mcd(a,b) -> int
	 * @param a - int  @param b - int
	 * Devuelve el maximo comun divisor entre a y b
	 */
	public int mcd(int a, int b) {
		a= Math.abs(a);
		b= Math.abs(b);
		while(resto(a,b)!=0) {
			int c =a;
			a=b;
			b= resto(c,b);
		}
		return b;
	}
	
	/**int mcd(a) -> int
	 * @param a - int
	 * Devuelve el maximo comun divisor entre a y el valor almacenado en esta clase
	 */
	public int mcd(int a) {
		return this.mcd(this.getValor(), a);
	}
	
	/**int mcd(e) -> int
	 * @param a - Entero
	 * Devuelve el maximo comun divisor entre e.getValor() y this.getValor()
	 */
	public int mcd(Entero e) {
		return this.mcd(this.getValor(), e.getValor());
	}
	
	
	/**int mcm(a,b) -> int
	 * @param a - int  @param b - int
	 * Devuelve el minimo comun multiplo entre a y b
	 */
	public int mcm(int a,int b) {
		return a*b/this.mcd(a,b);
	}
	
	/**int mcd(a) -> int
	 * @param a - int
	 * Devuelve el minimo común multiplo entre a y el valor almacenado en esta clase
	 */
	public int mcm(int a) {
		return this.mcm(this.getValor(), a);
	}

	/**int mcd(e) -> int
	 * @param a - Entero
	 * Devuelve el Minimo común multiplo  entre e.getValor() y this.getValor()
	 */
	public int mcm(Entero e) {
		return this.mcm(this.getValor(), e.getValor());
	}
	
	
	
	public void trianguloPrueba(int pisos) {
		if(pisos>0) {
			System.out.println("*");
		}
		for(int i=2;i<pisos;i++) {
			String vacios = new String(new char[i-2]).replace("\0", " ");
			System.out.println("*"+vacios+"*");
		}
		String estrellas = new String(new char[pisos]).replace("\0", "*");
		System.out.println(estrellas);
		
	}
	
	
	/** factorizacion(valor) ->HasMap<base,exponente>
	 * @param valor - int
	 * @param base - Integer
	 * @param exponente - Integer
	 * Devuelve la factorizacion en numeros primos del parametro <valor>, en un HasMap que contiene 
	 * {base=exponente} donde 
	 * 	base es un factor primo y
	 * 	exponente es la cantidad de veces que aparece 
	 */
	public HashMap<Integer,Integer> factorizacion(int numero) {
		HashMap<Integer,Integer> factores = new HashMap<Integer,Integer>();
		while(numero!=1) {
			int divisor=2;
			if(numero%2!=0) {
				divisor=3;

				while(numero%divisor!=0) {
					divisor+=2;
				}

			}
			if(factores.containsKey(divisor)) {
				factores.put(divisor,factores.get(divisor)+1);
			}
			else
				factores.put(divisor, 1);
			numero /=divisor;
				
		}
		return factores;
		
	}
	
	/**
	 * factorizacion() -> HasMap<base,exponente>
	 * @param base - Integer
	 * @param exponente - Integer
	 * Devuelve la factorizacion en numeros primos del parametro almacenado con setValor(), en un HasMap que contiene 
	 * {base=exponente} donde 
	 * 	base es un factor primo y
	 * 	exponente es la cantidad de veces que aparece 
	 */
	public HashMap<Integer,Integer> factorizacion(){
		return this.factorizacion(this.getValor());
	}
	
	/**
	 * factorizacion(e) -> HasMap<base,exponente>
	 * @param e - Entero()
	 * @param base - Integer
	 * @param exponente - Integer
	 * Devuelve la factorizacion en numeros primos del parametro almacenado con e.gtValor(), en un HasMap que contiene 
	 * {base=exponente} donde 
	 * 	base es un factor primo y
	 * 	exponente es la cantidad de veces que aparece 
	 */
	public HashMap<Integer,Integer> factorizacion(Entero e){
		return this.factorizacion(e.getValor());
	}
	
	
	
	
	/**
	 * Retorna la criba Erastotenes hasta un limite pasado por parametro
	 * en un array de enteros, donde los numeros que son primos conservan su valor y los compuestos fueron reeemplazados por 0
	 * 
	 * criba(int inicio, int fin) -> int[] 
	 * @param inicio -> int
	 * @param fin -> int 
	 * 
	 * 
	 */
	public int[] criba(int inicio,int fin) {
		int [] listado = new int[fin-inicio+1];
		int multiplos;
		for(int i=0;i<=fin-inicio;i++) {
			listado[i]=i+inicio;
		}
		System.out.println();
		int indice = 0;
		while(indice<fin/2) {
			if(listado[indice]!=0) {
				if(esPrimo(listado[indice])) {
					multiplos = listado[indice];
				}
				
				else {
					if(listado[indice]>1) {
						multiplos = menorDivisor(listado[indice]);	
					}
					else
						multiplos = inicio+fin;
					listado[indice]=0;
					
					
				}
				for(int i=indice+multiplos;i<=fin-inicio;i=i+multiplos) {
					listado[i]=0;
				}
			}
			indice++;
		}
		return listado;
	}
	
	
	/**
	 * Retorna la criba Erastotenes hasta un limite pasado por parametro
	 * en un array de enteros, donde los numeros que son primos conservan su valor y los compuestos fueron reeemplazados por 0
	 * 
	 * criba(int inicio, int fin) -> int[] 
	 * @param fin -> int 
	 * 
	 * 
	 */
	public int[] criba(int fin) {
		return criba(0,fin);
	}
	
	/**
	 * Retorna la criba Erastotenes hasta un limite igual al valor almacenado el objeto que llamé a esta funcion
	 * en un array de enteros, donde los numeros que son primos conservan su valor y los compuestos fueron reeemplazados por 0
	 * 
	 * criba(int inicio, int fin) -> int[] 
	 */
	public int[] criba() {
		return criba(0,this.getValor());
	}
	
	
	/**Limpia el array criba quitandole los valores compuestos
	 * 
	 * @param criba es una representacion de la criba de erastotenes donde los valores compuestos estan reemplazados por 0
	 * @return Un ArrayList de Integer con los primos que contenga el array criba
	 */
	public ArrayList<Integer> limpiarCriba(int[] criba){
		ArrayList<Integer> listaCriba = new ArrayList<>();
		for(int i=0;i<criba.length;i++) {
			if(criba[i]!=0)
				listaCriba.add(criba[i]);
		}
		return listaCriba;
	}
	
	/**
	 * Genera una  lista de primos entre dos valores pasados por parametros
	 * @param inicio - int
	 * @param fin - int 
	 * @return ArrayList Integer con todos los valores primos que esten entre i 	nicio y fin
	 */
	public ArrayList<Integer> cribaLimpia(int inicio, int fin) {
		return this.limpiarCriba(this.criba(inicio,fin));
	}
	
	
	public int menorDivisor(int valor) {
		if(resto(valor,2)==0)
			return 2;
		else {
			int divisor=3;
			while(divisor*divisor<valor&&resto(valor,divisor)!=0)
				divisor+=2;
			if(resto(valor,divisor)==0)
				return divisor;
			else
				return valor;
		}
	}
}
