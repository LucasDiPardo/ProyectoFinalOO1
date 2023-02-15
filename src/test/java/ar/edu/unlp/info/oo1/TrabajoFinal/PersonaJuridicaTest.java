package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaJuridicaTest {
	PersonaJuridica personaJuridicaConLlamadas, personaJuridicaSinLlamadas;
	LlamadaLocal llamadaLocal1;
	LlamadaInterurbana llamadaUrbana1;
	LlamadaInternacional llamadaInternacional1;
	private Pais argentina, brasil;
	
	
	@BeforeEach
	public void setUp() {
		
		
		argentina = new Pais("Argentina", 10, 5);
		brasil = new Pais("Brasil", 15, 6);
		
		personaJuridicaConLlamadas = new PersonaJuridica("LuP", "Pueyrredon 963", "1515", 202020, "Sociedad Anonima");
		personaJuridicaSinLlamadas = new PersonaJuridica("Jose Hnos", "Soarez 63", "1550", 303030, "Inversionista");
		
		
		llamadaLocal1 = personaJuridicaConLlamadas.registrarLlamadaLocal(LocalDateTime.of(2023, 2, 10, 15, 0), 10, personaJuridicaConLlamadas.getNumeroTelefonico(), "5050");
		llamadaUrbana1 = personaJuridicaConLlamadas.registrarLlamadaInterurbana(LocalDateTime.of(2023, 2, 13, 12, 0), 10, personaJuridicaConLlamadas.getNumeroTelefonico(), "5050", 670);
		llamadaInternacional1 = personaJuridicaConLlamadas.registrarLlamadaInternacional(LocalDateTime.of(2022, 2, 10, 15, 0), 10, personaJuridicaSinLlamadas.getNumeroTelefonico(), "1515", argentina, brasil);
	
		
	}
	
	@Test
	public void registroLlamadasTest() {
		assertEquals(0, personaJuridicaSinLlamadas.getLlamadas().size());
		assertEquals(3, personaJuridicaConLlamadas.getLlamadas().size());
	}
	
	@Test
	public void getLlamadasEnPeriodoTest() {
		assertEquals(2, personaJuridicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 10)).size());
		assertEquals(1, personaJuridicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 1)).size());
		assertEquals(0, personaJuridicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2020, 1, 1), LocalDate.of(2021, 12, 1)).size());
	}
	
	@Test
	public void montoLlamadasEnPeriodoTest() {
		//llamada local:  10minutos x $1 = $10
		assertEquals(10, personaJuridicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2023, 2, 9), LocalDate.of(2023, 2, 11)));
		
		//llamada InterUrbana: 10minutos x $3(670km) = $30 + $5 Conexion = $35
		assertEquals(35, personaJuridicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2023, 2, 12), LocalDate.of(2023, 2, 15)));
		
		//llamada Internacional: costo minuto destino brasil diurno $15 x 10minutos = $150
		assertEquals(150, personaJuridicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2022, 2, 9), LocalDate.of(2022, 2, 15)));
		
		//persona fisica sin llamadas
		assertEquals(0, personaJuridicaSinLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2020, 2, 9), LocalDate.of(2023, 2, 11)));
	}
	
}
