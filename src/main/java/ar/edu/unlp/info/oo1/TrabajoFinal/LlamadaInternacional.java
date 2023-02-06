package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	//variables instancia
	private String paisOrigen;
	private String paisDestino;
	
	//constructor
	public LlamadaInternacional(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Cliente unRemitente, Cliente unReceptor, String unOrigen, String unDestino) {
		super(unaFecha,unaHoraComienzo,unaDuracion, unRemitente,unReceptor);
		this.paisOrigen=unOrigen;
		this.paisDestino=unDestino;
	}
}
