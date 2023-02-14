package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaLocalTest {
	private LlamadaLocal llamadaLocal;
	
	
	@BeforeEach
	public void setUp() {
		llamadaLocal = new LlamadaLocal(LocalDateTime.of(2023, 1, 1, 9, 0), 0, null, null);
		
	}
	
	@Test
	public void llamadaLocalTest() {
		assertEquals(0, llamadaLocal.calcularCosto(0));
		
		llamadaLocal = new LlamadaLocal(LocalDateTime.of(2023, 1, 1, 9, 0), 10, null, null);
		assertEquals(10,llamadaLocal.calcularCosto(0));
	}
}
