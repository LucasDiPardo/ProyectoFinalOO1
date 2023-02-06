package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public abstract class Llamada {
	
	//variables instancia
	private LocalDate fechaLlamada;
	private LocalTime horaComienzo;
	private int duracion;
	private Cliente remitente;
	private Cliente receptor;
	
	
	//constructor
	public Llamada(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Cliente unRemitente, Cliente unReceptor) {
		this.fechaLlamada=unaFecha;
		this.horaComienzo=unaHoraComienzo;
		this.duracion=unaDuracion;
		this.remitente=unRemitente;
		this.receptor=unReceptor;
	}
}
