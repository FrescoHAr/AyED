package testing;

public class TestColaDePrioridad {

	public static void main(String[] args) {
		ColaDePrioridad cdp = new ColaDePrioridad();
		for(int k=0;k<10;k++) {
			cdp.insertar(new Proceso());
		}
		System.out.println("\n");
		int i =1;
		while(!cdp.estaVacia()) {
			System.out.println("Sale "+(i++)+" :\t"+cdp.devolver());
		}
		System.out.println("FIN");

	}

}
