package testing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SumaBinarioGrande{
	private ListaEnteros a;
	private ListaEnteros b;
	private ListaEnteros resultado;

	public SumaBinarioGrande() {
		a = new ListaEnteros();
		b = new ListaEnteros();
		resultado = new ListaEnteros();
	}

	private void meterA(int dig) {
		a.insertar(dig, a.tamanio());
	}
	private void meterB(int dig) {
		b.insertar(dig, b.tamanio());
	}

	public void cargar(String rutaArchivo) {
		File file = new File(rutaArchivo);
		FileReader fr = null;
		BufferedReader br  = null;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String linea = br.readLine();
			if(linea!=null) {
				String digitos[] = linea.split(",");
				for (String element : digitos) {
					meterA(Integer.parseInt(element));
				}
			}

			linea = br.readLine();
			if(linea!=null) {
				String digitos[] = linea.split(",");
				for (String element : digitos) {
					meterB(Integer.parseInt(element));
				}
			}
		} catch (IOException e) {
			System.out.println("Error. "+e.getLocalizedMessage());
		}finally {
			try {
				fr.close();
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		System.out.print("A: ");
		mostrar(a);
		System.out.print("B: ");
		mostrar(b);
		sumar();

	}


	public void sumar() {
		int cout =0;
		int posA =a.tamanio()-1;
		int posB = b.tamanio()-1;
		while(posA>=0&&posB>=0) {
			int suma = (int)a.devolver(posA--)+(int)b.devolver(posB--)+cout;
			if(suma>1) {
				if(suma==2)
					suma=0;
				else
					suma=1;
				cout =1;
			}else {
				cout =0;
			}
			this.resultado.insertar(suma, 0);
		}
		while(posA>=0) {
			if(cout>0) {
				int suma= (int)a.devolver(posA--)+cout;
				if(suma>1)
					this.resultado.insertar(0,0);
				else {
					this.resultado.insertar(suma,0);
					cout =0;
				}
			}
			else {
				this.resultado.insertar(a.devolver(posA--), 0);

			}


		}
		while(posB>=0) {
			if(cout>0) {
				int suma= (int)b.devolver(posB--)+cout;
				if(suma>1)
					this.resultado.insertar(0,0);
				else {
					this.resultado.insertar(suma,0);
					cout =0;
				}
			}
			else {
				this.resultado.insertar(b.devolver(posB--), 0);

			}
		}
		if(cout!=0)
			this.resultado.insertar(cout,0);
		System.out.print("Resultado: ");
		mostrar(resultado);
	}

	private void mostrar(ListaEnteros l) {
		if(!l.estaVacia()) {
			for(int i=0;i<l.tamanio();i++) {
				System.out.print(l.devolver(i));
			}
		}else {
			System.out.println("Lista vacia");
		}
		System.out.println();
	}
}
