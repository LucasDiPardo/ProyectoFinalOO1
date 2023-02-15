package ar.edu.unlp.info.oo1.TrabajoFinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FacturaTest {
	private EmpresaTelefonica empresa;
	private Persona cliente1, cliente2;
	private Factura factura1, factura2;
	private Pais argentina, brasil ;
	
	@BeforeEach
	public void setUp() {
		empresa = new EmpresaTelefonica();
		
		argentina = new Pais("Argentina", 1, 2);
		brasil = new Pais("Brasil", 5, 6);
		
		//agrego numero telefonicos para luego asignarlos
		empresa.agregarNumeroTelefonico("10");
		empresa.agregarNumeroTelefonico("20");
		
		cliente1 = empresa.registrarPersonaJuridica("Lucas", "Francisco 129", 37373737, "Sociedad Anonima");
		cliente2 = empresa.registrarPersonaJuridica("Jose", "Calle 30 19", 38383838, "Reparticion Provincial");
		
		empresa.registrarLlamadaLocal(LocalDateTime.of(2023, 2, 10, 15, 0), 10, cliente1.getNumeroTelefonico(), "101010"); //llamada persona juridica
		empresa.registrarLlamadaInterurbana(LocalDateTime.of(2023, 1, 10, 13, 0), 5, cliente1.getNumeroTelefonico(), "101010", 200); //llamada persona juridica
		empresa.registrarLlamadaInternacional(LocalDateTime.of(2023, 1, 15, 9, 0), 20, cliente2.getNumeroTelefonico(), "101010", argentina, brasil); //llamada persona fisica
	}

	@Test
	public void calcularMontoEnPeriodoTest() {
		factura1 = new Factura(cliente1, LocalDate.now(), LocalDate.of(2020, 1, 1), LocalDate.of(2020, 1, 2));
		assertEquals(0, factura1.getMontoTotal());
		
		factura2 = new Factura(cliente1, LocalDate.now(), LocalDate.of(2022, 1, 1), LocalDate.of(2024, 1, 2));
		assertEquals(27.5, factura2.getMontoTotal());
	}
}
