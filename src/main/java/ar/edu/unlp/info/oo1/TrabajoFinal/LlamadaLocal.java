package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada{
	//variables instancia
	
	//constructor
	public LlamadaLocal(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor) {
		super(unaFecha,unaHoraComienzo,unaDuracion, unRemitente,unReceptor);
	}
	
	//metodos
	public double calcularCosto() {
		return this.duracion * 1;
	}
}
