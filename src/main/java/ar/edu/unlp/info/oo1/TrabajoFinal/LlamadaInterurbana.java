package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInterurbana extends Llamada{
	//variables instancia
	private int distanciaKms;
	private int precioConexion=5;
	
	
	//constructor
	public LlamadaInterurbana(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor, int unaDistanciaKms) {
		super(unaFecha,unaHoraComienzo,unaDuracion, unRemitente,unReceptor);
		this.distanciaKms=unaDistanciaKms;
	}
	
	//metodos
	
	public double calcularCosto() {
		return precioConexion + (duracion*distanciaKms);
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
