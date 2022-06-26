package testing;

public class Test {
	public static void main(String[] args) {
		Integer obj1, obj2, obj3, obj4, obj5, obj6;

		obj1 = new Integer(100);
		obj2 = new Integer(90);
		obj3 = new Integer(80);
		obj4 = new Integer(70);
		obj5 = new Integer(55);
		obj6 = new Integer(77);


		ListaEnteros lista = new ListaEnteros();

		lista.insertar(obj1, 0); // inserto inicio
		lista.insertar(obj2, 0);
		lista.insertar(obj3, 0);
		lista.insertar(obj4, 3); // inserto fin

		lista.muestra();

		lista.eliminar(4);
		lista.eliminar(3);
		lista.muestra();

		System.out.println(" 90 en que posicion esta? " + lista.buscar(new Integer(90)));
		System.out.println("-90 en que posicion esta? " + lista.buscar(new Integer(-90)));

		//System.out.println("mostrando posicion 3 " + lista.devolver(3).toString());
		lista.reemplazar(new Integer(666), 0);

		lista.muestra();


//
//		ListaEnteros2 lista2 = new ListaEnteros2();
//		lista2.insertar(obj1);
//		lista2.insertar(obj2);
//		lista2.insertar(obj3);
//		lista2.insertar(obj4);
//
//		lista2.muestra();
//		System.out.println("****");
//
//		lista2.insertar(obj5);
//		lista2.insertar(obj6);
//		lista2.muestra();


	}

}
