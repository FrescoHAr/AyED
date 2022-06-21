package testing;

public class TestListaOrdenadaDeProcesos {

	public static void main(String[] args) {
		ListaOrdenadaDeProcesos lop = new ListaOrdenadaDeProcesos();
		for(int k=0;k<10;k++) {
			lop.insertar(new Proceso());
		}
		
		for(int k=0;k<lop.tamanio();k++) {
			System.out.println("Proceso "+(k+1)+": "+lop.devolver(k));
		}
	}

}
