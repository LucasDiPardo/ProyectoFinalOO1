package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Factura {
	//variables instancia
	private Persona cliente;
	private LocalDate fechaFacturacion;
	private LocalDate fechaInicioPeriodo;
	private LocalDate fechaFinPeriodo;
	private double montoTotal;
	
	
	//constructor
	public Factura(Persona unCliente, LocalDate unFeFacturacion, LocalDate fInicio, LocalDate fFin) {
		this.cliente=unCliente;
		this.fechaFacturacion=unFeFacturacion;
		this.fechaInicioPeriodo=fInicio;
		this.fechaFinPeriodo=fFin;
		this.montoTotal= montoLlamadasEnPeriodo();
	}
	
	//metodo
	
	private List<Llamada> llamadasDeCliente() {		
		return cliente.getLlamadasEnPeriodo(fechaInicioPeriodo, fechaFinPeriodo);
	}
	
	private double montoLlamadasEnPeriodo() {		
		return this.llamadasDeCliente().stream()
				.mapToDouble(l -> l.calcularCosto(cliente.getDescuento()))
				.sum();
	}

	//getters
	public double getMontoTotal() {
		return this.montoTotal;
	}
}	
