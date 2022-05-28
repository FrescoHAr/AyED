package operaciones;

import interfaces.Operaciones;
import interfaces.OperacionesMatriz;

public class Matriz implements Operaciones,OperacionesMatriz {
	private int filas;
	private int columnas;
	private  double matriz[][];
	
	public Matriz(int filas, int columnas) {
		this.filas=filas;
		this.columnas= columnas;
		matriz = new double[filas][columnas];
	}
	
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
	
	public void setValor(int fila,int columna,double valor) {
		this.matriz[fila][columna]=valor;
	}
	
	public double getValor(int fila,int columna) {
		return this.matriz[fila][columna];
	}

	@Override
	public void sumar(Object a, Object b) {
		Matriz m1 = (Matriz)a;
		Matriz m2 = (Matriz)b;
		if(m1.getFilas()==m2.getFilas() && m1.getColumnas()==m2.getColumnas()){
			for(int i=0;i<m1.getFilas();i++) {
				for(int j=0;j<m1.getColumnas();j++) {
					m1.setValor(i,j, m1.getValor(i, j)+m2.getValor(i, j));;
				}
			}
			this.filas=m1.filas;
			this.columnas=m1.columnas;
			this.matriz = new double[filas][columnas];
			for(int i=0;i<m1.getFilas();i++) {
				for(int j=0;j<m1.getColumnas();j++) {
					this.setValor(i, j, m1.getValor(i, j));
				}
			}
		}
		
	}

	@Override
	public void restar(Object a, Object b) {
		Matriz m1 = (Matriz)a;
		Matriz m2 = (Matriz)b;
		if(m1.getFilas()==m2.getFilas() && m1.getColumnas()==m2.getColumnas()){
			for(int i=0;i<m1.getFilas();i++) {
				for(int j=0;j<m1.getColumnas();j++) {
					m1.setValor(i,j, m1.getValor(i, j)-m2.getValor(i, j));;
				}
			}
			this.crearMatriz(filas, columnas);
			this.multiplicarxEscalar(m1, 1);
		}else
			System.out.println("Imposible realizar suma. El numero de filas y de columnas de las matrices no coincide.");
		
	}
	
	private double productoEscalar(double v1[],double v2[]) {
		double suma =0;
		if(v1.length==v2.length) {
			for(int i=0;i<v1.length;i++) {
				suma+=v1[i]*v2[i];
			}
		}
		return suma;
	}
	
	@Override
	public void multiplicar(Object a, Object b) {
		Matriz m1 = (Matriz)a;
		Matriz m2 = (Matriz)b;
		if(m1.getColumnas()==m2.getFilas()) {
			this.filas=m1.getFilas();
			this.columnas=m2.getColumnas();
			double matriz[][] = new double[this.filas][this.getColumnas()];
			for(int i=0;i<this.getFilas();i++) {
				for(int j=0;j<this.columnas;j++) {
					double columna[]= new double[m1.getColumnas()+1];
					double fila[]= new double[m1.getColumnas()+1];
					for(int k=0;k<m1.getColumnas()+1;k++) {
						fila[k] = m1.getValor(i, k);
						columna[k]=m2.getValor(k, j);
					}
					matriz[i][j]= this.productoEscalar(fila, columna);
				}
				
			}
			
			this.matriz= new double[this.filas][this.getColumnas()];
			for(int i=0;i<this.getFilas();i++) {
				for(int j=0;j<this.columnas;j++) {
					this.setValor(i, j, matriz[i][j]);
				}
			}
		}else{
			System.out.println("Error! El numnero de Columnas de la primera matriz y el numero de filas de la segunda matriz no coinciden");
			System.out.println("col m1= "+m1.getColumnas()+"filas m2= "+m2.getFilas());
		}
	}

	@Override
	public void potencia(Object a, int b) {
		Matriz matriz = (Matriz)a;
		this.crearMatriz(matriz.getFilas(), matriz.getColumnas());
		if(b>0&&matriz.getColumnas()==matriz.getFilas()) {
			this.multiplicarxEscalar(matriz, 1);
			for(int i=1;i<b;i++) {
				this.multiplicar(a, matriz);
			}
		}
		else {
			System.out.println("No se puede ejecutar la operacion");
		}
	}

	@Override
	public boolean igual(Object otro) {
		Matriz m = (Matriz) otro;
		if(m.getColumnas()!=this.columnas|| m.getFilas()!=this.filas)
			return false;
		for(int i=0;i<this.filas;i++) {
			for(int j=0;j<this.columnas;j++) {
				if(this.getValor(i, j)!=m.getValor(i,j))
					return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		String salida = "(Matriz)=\n";
		for(int i=0;i<this.filas;i++) {
			for (int j=0;j<this.columnas;j++) {
				salida+=this.getValor(i, j)+"\t";
			}
			salida+="\n";
		}
		return salida;
	}

	@Override
	public void crearMatriz(int filas, int columnas) {
		this.filas=filas;
		this.columnas=columnas;
		this.matriz=new double[filas][columnas];
		
	}

	@Override
	public void multiplicarxEscalar(Object o, int e) {
		Matriz m = (Matriz)o;
		this.crearMatriz(m.getFilas(), m.getColumnas());
		for(int i =0; i <this.filas;i++) {
			for(int j=0;j<this.columnas;j++) {
				this.setValor(i, j, m.getValor(i, j)*e);
			}
		}
	}

	@Override
	public void transponer() {
		Matriz transpuesta= new Matriz(this.columnas,this.filas);
		for(int i=0;i<this.filas;i++) {
			for(int j=0;j<this.columnas;j++) {
				transpuesta.setValor(j, i, this.getValor(i, j));
			}
		}
		this.crearMatriz(columnas,filas);
		this.multiplicarxEscalar(transpuesta, 1);
	}

	@Override
	public double determinante(Object o) {
		Matriz m = (Matriz) o;
		if(m.filas == m.columnas) {
			if(m.filas==1)
				return getValor(0, 0);
			if(m.filas==2) {
				return m.getValor(0, 0)*m.getValor(1, 1) - m.getValor(0, 1)*m.getValor(1, 0);
			}
			else {
				double suma =0;
				for(int i=0;i<m.filas;i++) {
					suma+= signo(0,i)*m.getValor(0, i)*determinante(matrizAdjunta(m, 0, i));
				}
				return suma;
			}
		}
		else {
			System.out.println("Error, N° filas != N° culumnas");
			return 0;
		}
		
	}
	
	public double determinante() {
		return determinante((Object)this);
	}
	
	private int signo(int fila, int columna) {
		if((fila+columna)%2==0)
			return 1;
		return -1;
	}
	
	private Object matrizAdjunta(Matriz m,int fila, int columna) {
		int filas = m.getFilas()-1;
		Matriz adjunta = new Matriz(filas,filas);
		int f =0;
		int c;
		for(int i=0;i<filas+1;i++) {
			 c=0;
			 
			for(int j=0;j<filas+1;j++) {
				if(i!=fila&&j!=columna) {
					adjunta.setValor(f, c, m.getValor(i, j));
					c++;
				}
				if(fila==i) {
					break;
				}
					
			}
			if(fila!=i)
				f++;
		}
		return (Object) adjunta;
	}
	
	

}
