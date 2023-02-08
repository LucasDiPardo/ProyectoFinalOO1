package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada{
	//variables instancia
	private int distanciaKms;
	private int precioConexion=5;
	
	
	//constructor
	public LlamadaInterurbana(LocalDateTime unaFechaYHora, int unaDuracion, String unRemitente, String unReceptor, int unaDistanciaKms) {
		super(unaFechaYHora,unaDuracion, unRemitente,unReceptor);
		this.distanciaKms=unaDistanciaKms;
	}
	
	//metodos
	
	public double calcularCosto(double unDescuento) {
		return total() - (total()*unDescuento);
	}
	
	private double total() {
		return precioConexion + (this.duracion*getPrecioPorkms());
	}
	
	private double getPrecioPorkms() {
		if (distanciaKms<100) {
			return 2;
		}else {
			if ((distanciaKms>=100)&&(distanciaKms<=500)){
				return 2.5;
			}else {
				return 3;
			}
		}
	}
}
