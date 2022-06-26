package testing.FIFA;

public class Seleccion{
	private String pais;
	private int pg;
	private int pep;
	/**
	 * @param pais  - Nombre del pais al que representa el selecciondo
	 * @param pg	- Cantidad de partidos ganados
	 * @param pep	- Cantidad de partidos empatados o perdidos
	 */
	public Seleccion(String pais, int pg, int pep) {
		super();
		this.pais = pais;
		this.pg = pg;
		this.pep = pep;
	}
	public String getPais() {
		return pais;
	}
	public int getPg() {
		return pg;
	}
	public int getPep() {
		return pep;
	}

	public void addWon() {
		this.pg++;
	}

	public void addLost() {
		this.pep++;
	}

	public int getDifencia() {
		return this.pg-this.pep;
	}
	@Override
	public String toString() {
		return "Seleccion: pais=" + pais +" ".repeat(12-pais.length())+pais+"\tpg=" + pg + "\tpep=" + pep+"\tdif. goles: "+getDifencia();
	}


}
