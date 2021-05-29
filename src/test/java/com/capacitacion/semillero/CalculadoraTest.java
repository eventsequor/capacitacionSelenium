package com.capacitacion.semillero;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
	private Calculadora cal;
	
	@Before
	public void precondiciones() {
		cal = new Calculadora();
		System.out.println("Inicio de test");
	}

	@Test
	public void testAdd() {
		System.out.println("Test 1");
		Integer[] lista = { 5, 4, 3, 8, 7, 4 };
		assertEquals(new Integer(31), cal.add(Arrays.asList(lista)));
	}
	
	@Test
	public void testAdd3() {
		System.out.println("Test 3");
		Integer[] lista = { 5, 4, 3, 8, 7 };
		assertEquals(new Integer(27), cal.add(Arrays.asList(lista)));
	}
	
	@Test
	public void testAdd2() {
		System.out.println("Test 2");
		Integer[] lista = { 5, 4, 3, 8, 7, 4 ,10};
		assertEquals(new Integer(41), cal.add(Arrays.asList(lista)));
	}
	
	@After
	public void postConditions() {
		System.out.println("Fin del test\n");
		cal = null;
	}
	

}
