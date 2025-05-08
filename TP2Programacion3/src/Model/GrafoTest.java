package Model;

import static org.junit.Assert.*;

import org.junit.Test;

public class GrafoTest {
	
	@Test
	public void crearGrafoVacioTest() {
		Grafo grafo = new Grafo(0);
		assertEquals(0, grafo.getTamanio());
	}
	
	public void crearGrafo() {
		Grafo grafo = new Grafo(3);
		int[][] esperado = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		assertArrayEquals(esperado, grafo.getA());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(-1, 3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeNegativoTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(1, -3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void primerVerticeMayorAlVerticeLimite()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(5, 3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void segundoVerticeMayorAlVerticeLimite()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 5, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void loopTest()
	{
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(3, 3, 8);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void impactoAmbientalMenorIgual0() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 0);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void impactoAmbientaMayorA10() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 11);
	}
	
	@Test
	public void aristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		assertTrue(grafo.existeArista(2, 3));
	}
	
	@Test
	public void aristaExistenteOpuesta() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		assertTrue(grafo.existeArista(3, 2));
	}
	
	@Test
	public void aristaNoExise() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		assertFalse(grafo.existeArista(4, 3));
	}
	
	@Test
	public void impactoAmbientalAristaCorrecto() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		assertEquals(9, grafo.getImpactoAmbientalArista(2, 3));
	}
	
	@Test
	public void impactoAmbientalAristaCorrectoOpueto() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		assertEquals(9, grafo.getImpactoAmbientalArista(3, 2));
	}
	
	@Test
	public void eliminarAristaExistente() {
		Grafo grafo = new Grafo(5);
		grafo.agregarArista(2, 3, 9);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}
	
	@Test
	public void eliminarAristaInexistente() {
		Grafo grafo = new Grafo(5);
		grafo.eliminarArista(2, 3);
		assertFalse(grafo.existeArista(2, 3));
	}
	
	
}
