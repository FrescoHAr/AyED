package testing;

public class TestCPU {

	public static void main(String[] args) {
		CPU cpu = new CPU(13, 5);
		cpu.cargar();
		System.out.println();
		cpu.atender();
		System.out.println("FIN");
	}

}
