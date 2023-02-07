package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	
	//variables instancia
	private LocalDate fechaLlamada;
	protected LocalTime horaComienzo;
	protected int duracion;
	protected Persona remitente;
	private Persona receptor;
	private LocalTime horaInicioDiurno;
	private LocalTime horaFinDiurno;
	
	//constructor
	public Llamada(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor) {
		this.fechaLlamada=unaFecha;
		this.horaComienzo=unaHoraComienzo;
		this.duracion=unaDuracion;
		this.remitente=unRemitente;
		this.receptor=unReceptor;
		
		this.horaInicioDiurno= LocalTime.of(8, 0);
		this.horaFinDiurno= LocalTime.of(20, 0);
	}
	
	
	//metodo
	public abstract double calcularCosto();

	public boolean seEncuentraEnPeriodo(LocalDate fInicio,LocalDate fFin) {
		DateLapse d = new DateLapse(fInicio, fFin);
		return d.includesDate(this.fechaLlamada);
	}
	
	public boolean esDiurno() {
		return (horaComienzo.isAfter(horaInicioDiurno))&&(horaComienzo.isBefore(horaFinDiurno));
	}
	
	
}
