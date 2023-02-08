package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaLocal extends Llamada{
	//variables instancia
	
	//constructor
	public LlamadaLocal(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor) {
		super(unaFechaYHora,unaDuracion, unRemitente,unReceptor);
	}
	
	//metodos
	public double calcularCosto(double unDescuento) {
		return total() - descuento(unDescuento);
	}
	
	private double descuento(double unDescuento) {
		return total()*unDescuento;
	}
	
	private double total() {
		return this.duracion * 1 ;
	}
	
}
