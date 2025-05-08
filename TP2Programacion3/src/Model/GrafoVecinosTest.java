package Model;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class GrafoVecinosTest {
	
	@Test
	public void vecinosCorrectosTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 2, 6);
		grafo.agregarArista(1, 3, 6);
		grafo.agregarArista(1, 4, 6);
		grafo.agregarArista(3, 2, 6);
		Set<Integer> vecinos = new HashSet<Integer>();
		vecinos.add(2);
		vecinos.add(3);
		vecinos.add(4);
		assertEquals(vecinos, grafo.vecinos(1));	
	}
	
	@Test
	public void vecinosIncorrectosTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, 2, 6);
		grafo.agregarArista(1, 3, 6);
		grafo.agregarArista(1, 4, 6);
		grafo.agregarArista(3, 2, 6);
		Set<Integer> vecinos = new HashSet<Integer>();
		vecinos.add(2);
		vecinos.add(3);
		assertNotEquals(vecinos, grafo.vecinos(1));	
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinosDeVerticeNegativoTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(-1);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void vecinosDeVerticeMayorAlLimiteTest() {
		Grafo grafo = new Grafo(5);
		grafo.vecinos(5);
	}
	
	@Test
	public void verticeAisladoTest() {
		Grafo grafo = new Grafo(5);
		assertEquals(0, grafo.vecinos(4).size());
	}
	
	@Test
	public void verticeUniversalTest() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(0, 1, 6);
		grafo.agregarArista(0, 2, 6);
		grafo.agregarArista(0, 3, 6);
		grafo.agregarArista(0, 4, 6);
		Set<Integer> vecinos = new HashSet<Integer>();
		vecinos.add(1);
		vecinos.add(2);
		vecinos.add(3);
		vecinos.add(4);
		assertEquals(vecinos, grafo.vecinos(0));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
