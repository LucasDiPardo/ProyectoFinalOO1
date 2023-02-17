package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmpresaTelefonicaTest {
	
	
	private EmpresaTelefonica empresa1, empresaVacia;
	private PersonaJuridica personaJuridicaSinLlamadas, personaJuridicaConLlamadas;
	private PersonaFisica personaFisicaSinLlamadas, personaFisicaConLlamadas;
	
	private Pais argentina, brasil ;
	
	@BeforeEach
	
	public void setUp() {
		
		//creo empresas
		empresa1 = new EmpresaTelefonica();
		empresaVacia = new EmpresaTelefonica();
		
		//creo paises - Nombre, precio diurno, precio nocturno
		argentina = new Pais("Argentina", 1, 2);
		brasil = new Pais("Brasil", 5, 6);

		
		//agrego numero telefonicos para luego asignarlos
		empresa1.agregarNumeroTelefonico("10");
		empresa1.agregarNumeroTelefonico("20");
		empresa1.agregarNumeroTelefonico("30");
		empresa1.agregarNumeroTelefonico("40");
		empresa1.agregarNumeroTelefonico("50");
		
		//alta clientes

		
		//personas Juridicas
		personaJuridicaConLlamadas = empresa1.registrarPersonaJuridica("Lucas", "Francisco 129", 37373737, "Sociedad Anonima");
		personaJuridicaSinLlamadas = empresa1.registrarPersonaJuridica("Jose", "Calle 30 19", 38383838, "Reparticion Provincial");
		
		//personas Fisicas
		
		personaFisicaConLlamadas = empresa1.registrarPersonaFisica("Nicolas", "Pueyrredon 963", 20202020);
		personaFisicaSinLlamadas = empresa1.registrarPersonaFisica("Tomas", "Las Heras 12", 505050);
		
	}
	
	@Test 
	public void agregarNumeroTelefonicoTest() {		
		assertEquals(5, empresa1.getNumerosTelefonicos().size()); //se cargaron 5 numeros, se asignaron 4, resta 1
		assertEquals(0, empresaVacia.getNumerosTelefonicos().size());
	}
	
	
	@Test 
	public void buscarClienteEmisorTest() {		
		//busca por numero telefonico
		assertEquals(null, empresa1.buscarClienteEmisorPorNumero("151515"));
		assertEquals("Lucas", empresa1.buscarClienteEmisorPorNumero(personaJuridicaConLlamadas.getNumeroTelefonico()).getNombre());
	}
	
	@Test
	public void registrarLlamadasTest() {
		//registro llamadas
		empresa1.registrarLlamadaLocal(LocalDateTime.of(2023, 2, 10, 15, 0), 10, personaJuridicaConLlamadas.getNumeroTelefonico(), "101010"); //llamada persona juridica
		empresa1.registrarLlamadaInterurbana(LocalDateTime.of(2023, 1, 10, 13, 0), 5, personaJuridicaConLlamadas.getNumeroTelefonico(), "101010", 200); //llamada persona juridica
		empresa1.registrarLlamadaInternacional(LocalDateTime.of(2023, 1, 15, 9, 0), 20, personaFisicaConLlamadas.getNumeroTelefonico(), "101010", argentina, brasil); //llamada persona fisica
		
		//sin llamadas
		assertEquals(0, personaFisicaSinLlamadas.getLlamadas().size());
		assertEquals(0, personaJuridicaSinLlamadas.getLlamadas().size());
		
		//con llamadas
		assertEquals(2, personaJuridicaConLlamadas.getLlamadas().size());
		assertEquals(1, personaFisicaConLlamadas.getLlamadas().size());
		
		
		
	}
	
}
