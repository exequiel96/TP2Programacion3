package Model;

public class Arista {
	
	private int origen;
	private int destino;
	private int impactoAmbiental;
	
	public Arista(int origen, int destino, int impactoAmbiental) {
		this.origen = origen;
		this.destino = destino;
		this.impactoAmbiental = impactoAmbiental;
	}

	public int getOrigen() {
		return origen;
	}

	public void setOrigen(int origen) {
		this.origen = origen;
	}

	public int getDestino() {
		return destino;
	}

	public void setDestino(int destino) {
		this.destino = destino;
	}

	public int getImpactoAmbiental() {
		return impactoAmbiental;
	}

	public void setImpactoAmbiental(int impactoAmbiental) {
		this.impactoAmbiental = impactoAmbiental;
	}
	
	
}
