package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PersonaFisicaTest {
	PersonaFisica personaFisicaConLlamadas, personaFisicaSinLlamadas;
	LlamadaLocal llamadaLocal1;
	LlamadaInterurbana llamadaUrbana1;
	LlamadaInternacional llamadaInternacional1;
	private Pais argentina, brasil ;
	
	
	@BeforeEach
	public void setUp() {
		
		argentina = new Pais("Argentina", 10, 5);
		brasil = new Pais("Brasil", 5, 6);
		
		personaFisicaConLlamadas = new PersonaFisica("Nicolas", "Pueyrredon 963", "1540", 20202020);
		personaFisicaSinLlamadas = new PersonaFisica("Jose", "Pueyrredon 963", "1550", 303030);
		
		
		llamadaLocal1 = personaFisicaConLlamadas.registrarLlamadaLocal(LocalDateTime.of(2023, 2, 10, 15, 0), 10, personaFisicaConLlamadas.getNumeroTelefonico(), "1550");
		llamadaUrbana1 = personaFisicaConLlamadas.registrarLlamadaInterurbana(LocalDateTime.of(2023, 2, 13, 12, 0), 10, personaFisicaConLlamadas.getNumeroTelefonico(), "1550", 170);
		llamadaInternacional1 = personaFisicaConLlamadas.registrarLlamadaInternacional(LocalDateTime.of(2022, 2, 10, 15, 0), 10, personaFisicaConLlamadas.getNumeroTelefonico(), "1550", brasil, argentina);
	
		
		
	}
	
	@Test
	public void registroLlamadasTest() {
		assertEquals(0, personaFisicaSinLlamadas.getLlamadas().size());
		assertEquals(3, personaFisicaConLlamadas.getLlamadas().size());
	}
	
	@Test
	public void getLlamadasEnPeriodoTest() {
		assertEquals(2, personaFisicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2023, 1, 1), LocalDate.of(2023, 10, 10)).size());
		assertEquals(1, personaFisicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2022, 1, 1), LocalDate.of(2022, 12, 1)).size());
		assertEquals(0, personaFisicaConLlamadas.getLlamadasEnPeriodo(LocalDate.of(2020, 1, 1), LocalDate.of(2021, 12, 1)).size());
	}
	
	
	@Test
	public void montoLlamadasEnPeriodoTest() {
		//llamada local:  10minutos x $1 = $10 - 10% descuento por ser persona fisica = $9
		assertEquals(9, personaFisicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2023, 2, 9), LocalDate.of(2023, 2, 11)));
		
		//llamada InterUrbana: 10minutos x $2.5(170km) = $25 + $5 Conexion = $30 - 10% = $27
		assertEquals(27, personaFisicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2023, 2, 12), LocalDate.of(2023, 2, 15)));
		
		//llamada Internacional: costo minuto destino argentina diurno $10 x 10minutos = $100 - 10% =$90
		assertEquals(90, personaFisicaConLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2022, 2, 9), LocalDate.of(2022, 2, 15)));
		
		//persona fisica sin llamadas
		assertEquals(0, personaFisicaSinLlamadas.montoLlamadasEnPeriodo(LocalDate.of(2020, 2, 9), LocalDate.of(2023, 2, 11)));
	}
}
