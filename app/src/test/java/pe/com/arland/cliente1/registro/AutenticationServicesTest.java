package pe.com.arland.cliente1.registro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import pe.com.arland.cliente1.registro.entity.ClienteEntity;
import pe.com.arland.cliente1.registro.entity.DireccionEntity;
import pe.com.arland.cliente1.registro.entity.UsuarioAplicacionEntity;
import pe.com.arland.seguridad1.autenticacion.repository.mongodb.ClientesRepositoryImpl;
import pe.com.arland.seguridad1.autenticacion.repository.mongodb.UsuariosAplicacionRepositoryImpl;
import pe.com.arland.seguridad1.autenticacion.service.impl.AutenticacionServiceImpl;

@DisplayName("SERVICIO DE AUTENTICACION")
class AutenticationServicesTest {

	private static String codUsuario = null;
	private static String password = null;
	private static AutenticacionServiceImpl serviceAuth = new AutenticacionServiceImpl();

	@DisplayName("CONFIGURACION DEL ENTORNO")
	@BeforeAll
	static void configuracionDelEscenario() {
		System.out.println("****************************************");
		System.out.println("**	ETAPA :CONFIGURACION DEL ENTORNO  **");
		System.out.println("****************************************");
		System.out.println("**  AMBIENTE DE PRUEBA                **");
		System.out.println("****************************************");
		System.out.println("**  REGISTRO DE DATOS DE PRUEBA       **");
		System.out.println("****************************************");
		serviceAuth.setClienteDAO(new ClientesRepositoryImpl());
		serviceAuth.setUsuarioDAO(new UsuariosAplicacionRepositoryImpl());

	}

	@DisplayName("CONFIGURACION DE CADA PRUEBA")
	@BeforeEach
	void configuracionCadaPrueba() {
		System.out.println("******************************************************");
		System.out.println("** ETAPA :CONFIGURACION PREVIA ANTES DE CADA PRUEBA **");
		System.out.println("******************************************************");
		codUsuario = "USR2002";
		password = "pwdUSR2002";
		// password = "";
		// password = null;
	}

	/*
	 * Validacion de clientes que se registraron como usuarios efectivamente estan
	 * actualizando sus datos
	 */
	@DisplayName("AUTENTICACION - Clientes que se registraron como usuarios ")
	@Test
	void testEscenario1() {

		// EJEMPLO ASSERTNOTNULL VALORES
		assertNotNull(codUsuario, "Codigo Usuario es nullo");
		assertNotNull(password, "Password Usuario es nullo");

		// EJEMPLO USO DIRECTO DE FAIL
		if (codUsuario.isEmpty() || password.isEmpty()) {
			fail("Codigo de Usuario o Password estan Vacios");
		}

		// *RECUPERACION DE OBJETO
		// USR2001,USR2002,USR2003
		UsuarioAplicacionEntity usuario = serviceAuth.validarUsuarioAplicacionporCodUsuario(codUsuario, password);

		// EJEMPLO ASSERTNOTNULL OBJETOS
		assertNotNull(usuario, "Usuario registrado con codigo " + codUsuario + "No esta registrado");

		// EJEMPLO ASSERTFALSE EMPTY
		assertFalse(usuario.getTipoDocumento().isEmpty());
		assertFalse(usuario.getNumeroDocumento().isEmpty());

		// *RECUPERACION DE OBJETO
		ClienteEntity cliente = serviceAuth.recuperarCliente(usuario.getTipoDocumento(), usuario.getNumeroDocumento());

		// EJEMPLO ASSERTNOTNULL OBJETOS
		assertNotNull(cliente, "Usuario registrado con codigo " + codUsuario + "No esta registrado");

		// EJEMPLO ASSERT ALL COMPROBAR QUE SE REGISTRARON EFECTIVAMENTE IGUALES
		assertAll("Nombre del grupo : Verificar Explicitamente a un valor",
				() -> assertEquals(cliente.getNombrePrincipal(), usuario.getNombrePrincipal()),
				() -> assertEquals(cliente.getApellidoPaterno(), usuario.getApellidoPaterno()),
				() -> assertEquals(cliente.getApellidoMaterno(), usuario.getApellidoMaterno()),
				() -> assertEquals(cliente.getTipoDocumento(), usuario.getTipoDocumento()),
				() -> assertEquals(cliente.getNumeroDocumento(), usuario.getNumeroDocumento()));

	}

	@DisplayName("LIBERACION DE DATOS DE CADA PRUEBA")
	@BeforeEach
	void restauracionDeCadaPrueba() {
		System.out.println("******************************************************");
		System.out.println("** ETAPA :CONFIGURACION PREVIA ANTES DE CADA PRUEBA **");
		System.out.println("******************************************************");
		codUsuario = "";
		password = "";
	}

	@DisplayName("RESTAURACION DEL ENTORNO")
	@AfterAll
	static void restauracionDelEscenario() {
		System.out.println("****************************************");
		System.out.println("**	ETAPA :RECONFIGURACION DEL ENTORNO  **");
		System.out.println("****************************************");
		System.out.println("**  ELIMINACION DE DATOS DE PRUEBA  ***");
		System.out.println("****************************************");
	}
}
