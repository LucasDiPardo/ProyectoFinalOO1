package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada{
	//variables instancia

	
	//constructor
	public LlamadaLocal(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor) {
		super(unaFechaYHora,unaDuracion, unRemitente,unReceptor);
		setPrecioPorMinuto(1);
		
	}

	
	//metodos
	public double calcularCosto(double unDescuento) {
		return calculo() - descuento(calculo(),unDescuento);
	}
	
}
