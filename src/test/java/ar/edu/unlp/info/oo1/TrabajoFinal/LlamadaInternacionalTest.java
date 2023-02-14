package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LlamadaInternacionalTest {
	private LlamadaInternacional llamadaInternacional;
	private Pais argentina, brasil ;
	
	@BeforeEach
	public void setUp() {
	
		argentina = new Pais("Argentina", 10, 5);
		brasil = new Pais("Brasil", 15, 6);
		
		llamadaInternacional= new LlamadaInternacional(LocalDateTime.of(2023, 1, 1, 7, 59), 10, null, null, argentina, brasil);
	}
	
	@Test
	public void llamadaInternacionalTest() {
		
		//rangos para llamadas nocturas
		
			//destino brasil
			assertEquals(60,llamadaInternacional.calcularCosto(0));
			llamadaInternacional = new LlamadaInternacional(LocalDateTime.of(2023, 1, 1, 20, 1), 10, null, null, argentina, brasil);
			assertEquals(60,llamadaInternacional.calcularCosto(0));
			
			//destino argentina
			llamadaInternacional = new LlamadaInternacional(LocalDateTime.of(2023, 1, 1, 20, 1), 10, null, null, brasil, argentina);
			assertEquals(50,llamadaInternacional.calcularCosto(0));
		
		
	
		//rangos para llamadas diurnas
		
			//destino brasil
			llamadaInternacional = new LlamadaInternacional(LocalDateTime.of(2023, 1, 1, 8, 0), 10, null, null, argentina, brasil);
			assertEquals(60,llamadaInternacional.calcularCosto(0));
			
			//destino argentina
			llamadaInternacional = new LlamadaInternacional(LocalDateTime.of(2023, 1, 1, 20, 0), 10, null, null, brasil, argentina);
			assertEquals(50,llamadaInternacional.calcularCosto(0));
	
	}
}
