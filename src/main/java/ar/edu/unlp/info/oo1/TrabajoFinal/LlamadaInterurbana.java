package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada{
	//variables instancia
	private int distanciaKms;
	
	
	//constructor
	public LlamadaInterurbana(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Cliente unRemitente, Cliente unReceptor, int unaDistanciaKms) {
		super(unaFecha,unaHoraComienzo,unaDuracion, unRemitente,unReceptor);
		this.distanciaKms=unaDistanciaKms;
	}
}
