package Model;

import java.util.HashSet;
import java.util.Set;

public class Grafo {

	private int [][] A; 
	
	public Grafo (int vertices) {
		this.A = new int [vertices][vertices];
	}
	
	public int [][] getA() {
		return A;
	}
	
	public void agregarArista(int verticeOrigen, int verticeDestino, int impactoAmbiental) {
		verificarVertice(verticeOrigen);
		verificarVertice(verticeDestino);
		verificarDistintos(verticeOrigen, verticeDestino);
		verificarImpactoAmbiental(impactoAmbiental);
		
		this.A[verticeOrigen][verticeDestino] = impactoAmbiental;
		this.A[verticeDestino][verticeOrigen] = impactoAmbiental;
		
	}
	
	public void eliminarArista(int verticeOrigen, int verticeDestino) {
		verificarVertice(verticeOrigen);
		verificarVertice(verticeDestino);
		verificarDistintos(verticeOrigen, verticeDestino);
		
		this.A[verticeOrigen][verticeDestino] = 0;
		this.A[verticeDestino][verticeOrigen] = 0;
		
	}
	
	public boolean existeArista(int verticeOrigen, int verticeDestino) {
		verificarVertice(verticeOrigen);
		verificarVertice(verticeDestino);
		verificarDistintos(verticeOrigen, verticeDestino);
		return A[verticeOrigen][verticeDestino] != 0;
	}
	
	public int getImpactoAmbientalArista(int verticeOrigen, int verticeDestino) {
		verificarVertice(verticeOrigen);
		verificarVertice(verticeDestino);
		verificarDistintos(verticeOrigen, verticeDestino);
		return A[verticeOrigen][verticeDestino];
	}
	
	public Set<Integer> vecinos(int vertice){
		verificarVertice(vertice);
		Set<Integer> vecinos = new HashSet<>();

		for (int i = 0; i < this.getTamanio(); ++i) {
			if (vertice != i) {
				if (this.existeArista(vertice, i))
					vecinos.add(i);
			}
		}
		return vecinos;
	}
	
	public int getTamanio() {
		return A.length;
	}

	private void verificarVertice(int i){
		if( i < 0 )
			throw new IllegalArgumentException("El vertice no puede ser negativo: " + i);
		
		if( i >= A.length )
			throw new IllegalArgumentException("Los vertices deben estar entre 0 y |V|-1: " + i);
	}

	private void verificarDistintos(int i, int j){
		if( i == j )
			throw new IllegalArgumentException("No se permiten loops: (" + i + ", " + j + ")");
	}
	
	private void verificarImpactoAmbiental(int imp) {
		if(imp <= 0)
			throw new IllegalArgumentException("El impacto ambiental no puede ser 0, debe ser un numero entre 1 y 10: " + imp);
		if(imp > 10)
			throw new IllegalArgumentException("El impacto ambiental no puede ser 0, debe ser un numero entre 1 y 10: " + imp);
	}
}
