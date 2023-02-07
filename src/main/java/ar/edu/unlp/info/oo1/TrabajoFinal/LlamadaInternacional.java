package ar.edu.unlp.info.oo1.TrabajoFinal;

import java.time.LocalDate;
import java.time.LocalTime;

public class LlamadaInternacional extends Llamada{
	//variables instancia
	private Pais paisOrigen;
	private Pais paisDestino;
	
	//constructor
	public LlamadaInternacional(LocalDate unaFecha, LocalTime unaHoraComienzo, int unaDuracion, Persona unRemitente, Persona unReceptor, Pais unOrigen, Pais unDestino) {
		super(unaFecha,unaHoraComienzo,unaDuracion, unRemitente,unReceptor);
		this.paisOrigen=unOrigen;
		this.paisDestino=unDestino;
	}
	
	//metodos
	public double calcularCosto() {
		
		double totalSinDescuento=duracion*getPrecioPorMinuto();
		
		return totalSinDescuento - totalSinDescuento*this.remitente.getDescuento();
		
	}
	
	private double getPrecioPorMinuto() {
		
		double precioPorMinuto=0;
		
		if (esDiurno()) {			
			precioPorMinuto= this.paisDestino.getPrecioDiurno();
		}else {
			precioPorMinuto =this.paisDestino.getPrecioNocturno();
		}
		
		return precioPorMinuto;
	}
}
