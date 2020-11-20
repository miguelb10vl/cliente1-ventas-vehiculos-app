/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package pe.com.arland.cliente1.registro;

import org.junit.jupiter.api.Test;

import pe.com.arland.cliente1.registro.entity.VehiculoAutomovilBase;
import pe.com.arland.cliente1.registro.entity.factory.FabricaVehiculoElectricidad;
import pe.com.arland.cliente1.registro.entity.factory.IFabricaVehiculo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

@DisplayName ("Test del Flujo principal de Ventas de Vehiculos")
class AppTest {
	
	/* Intanciando la aplicacion principal
    @Test void appHasAGreeting() {
      App classUnderTest = new App();
      assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }*/
    
	@BeforeAll
	static void setupAll() {
		System.out.println("****************************************");
		System.out.println("*ETAPA :BEFFOREALL                  ******");
		System.out.println("Configurar TODAS LAS PRUEBAS en la clase");
		System.out.println("****************************************");
	}

	@BeforeEach
	void setup() {
		System.out.println("****************************************");
		System.out.println(">>ETAPA :BEFORE EACH");
		System.out.println("Configurar ANTES CADA PRUEBA en la clase");
		System.out.println("****************************************");
	}

	@DisplayName ("Metodo UNO ")
	@Test
	void testOne() {
		System.out.println("TEST 1");
	}

	@DisplayName ("Metodo DOS Deshabilitado ")
	@Test
	void testTwo() {
		System.out.println("TEST 2");
	}
	
	@DisplayName ("Metodo TRES ")
	@Test
	void testThree() {
		System.out.println("TEST 3");
	}

	@AfterEach
	void teardown() {
		System.out.println("Teardown EACH TEST in the class");
		System.out.println("****************************************");
		System.out.println(">>ETAPA :AFTEREACH ");
		System.out.println("Configurar LUEGO DE CADA PRUEBA en la clase");
		System.out.println("****************************************");
	}

	@AfterAll
	static void teardownAll() {
		System.out.println("****************************************");
		System.out.println("*ETAPA :AFTERPALL                  ******");
		System.out.println("Desmontando  TODAS LAS PRUEBAS en la clase");
		System.out.println("****************************************");
	}
  
}
