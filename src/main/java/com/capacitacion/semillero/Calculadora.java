package com.capacitacion.semillero;

import java.util.List;

public class Calculadora {

	public Integer add(List<Integer> listaEnteros) {
		Integer resultado = new Integer(0);
		for (Integer pivo : listaEnteros) {
			resultado += pivo;
		}
		return resultado;
	}
}
