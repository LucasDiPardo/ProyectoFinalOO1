package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;

public class Factura {
	//variables instancia
	private Persona cliente;
	private LocalDate fechaFacturacion;
	private LocalDate fechaInicioPeriodo;
	private LocalDate fechaFinPeriodo;
	private double montoTotal; //ver
	
	
	//constructor
	public Factura(Persona unCliente, LocalDate unFeFacturacion, LocalDate fInicio, LocalDate fFin, double unMontoTotal) {
		this.cliente=unCliente;
		this.fechaFacturacion=unFeFacturacion;
		this.fechaInicioPeriodo=fInicio;
		this.fechaFinPeriodo=fFin;
		this.montoTotal= unMontoTotal;
	}
	
	
	//getters
	public double getMontoTotal() {
		return this.montoTotal;
	}
	public LocalDate getFechaFacturacion() {
		return fechaFacturacion;		
	}
	public LocalDate getFechaInicioPeriodo() {
		return fechaInicioPeriodo;		
	}
	public LocalDate getFechaFinPeriodo() {
		return fechaFinPeriodo;		
	}
}	
