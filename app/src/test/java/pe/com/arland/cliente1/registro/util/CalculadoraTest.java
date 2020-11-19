package pe.com.arland.cliente1.registro.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	void testSuma() {
		double esperado = 50;
		double resultado = Calculadora.suma(20, 30);
		assertEquals(esperado, resultado);
	}

	@Test
	void testResta() {
		double esperado = 10;
		double resultado = Calculadora.resta(30, 20);
		assertEquals(esperado, resultado);
	}

	@Test
	void testMultiplicacion() {
		double esperado = 50;
		double resultado = Calculadora.multiplicacion(10, 5);
		assertEquals(esperado, resultado);
	}

	@Test
	void testDivision() {
		double esperado = 5;
		double resultado = Calculadora.division(50, 10);
		assertEquals(esperado, resultado);
	}

}
