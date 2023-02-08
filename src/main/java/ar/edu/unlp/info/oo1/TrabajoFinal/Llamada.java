package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public abstract class Llamada{
	
	//variables instancia
	protected LocalDateTime fechaYHoraLlamada;
	protected int duracion;
	protected String remitente;
	private String receptor;
	private int horaInicioDiurno;
	private int horaFinDiurno;
	
	//constructor
	public Llamada(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor) {
		this.fechaYHoraLlamada=unaFechaYHora;
		this.duracion=unaDuracion;
		this.remitente=unRemitente;
		this.receptor=unReceptor;		
		this.horaInicioDiurno= 8;
		this.horaFinDiurno= 20;
	}
	
	
	//metodo
	public abstract double calcularCosto(double unDescuento);
	// public abstract double descuento();
	// public abstract double precioMinuto();

	
	public boolean seEncuentraEnPeriodo(LocalDate fInicio,LocalDate fFin) {
			DateLapse d = new DateLapse(fInicio, fFin);
		return d.includesDate(this.fechaYHoraLlamada);
	}
	
	public boolean esDiurno() {
		return (fechaYHoraLlamada.getHour()>horaInicioDiurno)&& (fechaYHoraLlamada.getHour()<horaFinDiurno);
	}
	
	
}
