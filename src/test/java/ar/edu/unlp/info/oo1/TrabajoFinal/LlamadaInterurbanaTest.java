package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaInterurbanaTest {
	private LlamadaInterurbana llamadaInterUrbana;
	
	
	
	@BeforeEach
	public void setUp() {
		llamadaInterUrbana = new LlamadaInterurbana(LocalDateTime.of(2023, 2, 10, 9, 0), 10, null, null, 99);
		
	}
	
	@Test
	public void llamadaInterurbanaTest() {
		
		//valores menores a 100
		assertEquals(25,llamadaInterUrbana.calcularCosto(0));
		
		
		//valores mayores a 100, pero menores a 500
		llamadaInterUrbana = new LlamadaInterurbana(LocalDateTime.of(2023, 2, 10, 9, 0), 10, null, null, 100);
		assertEquals(30,llamadaInterUrbana.calcularCosto(0));
		llamadaInterUrbana = new LlamadaInterurbana(LocalDateTime.of(2023, 2, 10, 9, 0), 10, null, null, 499);
		assertEquals(30,llamadaInterUrbana.calcularCosto(0));
		
		
		//valores mayores a 500
		llamadaInterUrbana = new LlamadaInterurbana(LocalDateTime.of(2023, 2, 10, 9, 0), 10, null, null, 500);
		assertEquals(35,llamadaInterUrbana.calcularCosto(0));
	}
}
